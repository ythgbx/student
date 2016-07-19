package net.bus.web.controller;

import net.bus.web.aspect.Auth;
import net.bus.web.context.PhoneSMSContext;
import net.bus.web.context.Position;
import net.bus.web.context.SessionContext;
import net.bus.web.controller.dto.*;
import net.bus.web.model.User;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import net.bus.web.service.IUserService;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Random;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private IUserService service;
    @Autowired
    private HttpSession session;

    private Logger logger = Logger.getLogger(this.getClass().getName());

    @RequestMapping(value="/login")
    public ModelAndView index(Model model)
    {
        logger.info("url:/user");

        ModelAndView mv =new ModelAndView();
        mv.setViewName("user_login");

        return mv;
    }

    @Auth(role = Auth.Role.NONE)
    @ResponseBody
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public LoginResult login(@RequestBody Login login)
    {
        User user = service.loginCheck(login.getPhone(),login.getPassword());

        LoginResult result = new LoginResult();

        if(user!=null) {
            session.setAttribute(SessionContext.CURRENT_USER, user);
            session.setAttribute(SessionContext.CURRENT_USER_ROLE, Auth.Role.USER);

            result.setSession_id(session.getId());
            result.setResult("success");
        }else{
            result.setSession_id(null);
            result.setResult("failure");
        }

        return result;
    }

    @Auth(role = Auth.Role.USER)
    @ResponseBody
    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    public BaseResult logout()
    {
        session.removeAttribute(SessionContext.CURRENT_USER);
        session.removeAttribute(SessionContext.CURRENT_USER_ROLE);
        BaseResult result = new BaseResult();
        result.setResult("logout");
        return result;
    }

    @Auth(role = Auth.Role.NONE)
    @ResponseBody
    @RequestMapping(value = "/sms", method = RequestMethod.POST)
    public BaseResult registerSms(@RequestBody Register register)
    {
        BaseResult result = new BaseResult();
        if(register.getPhone()!=""){
            //TODO Request sms server for send code sms to the phone
            String smsCode = getRandNum(6);
            PhoneSMSContext.getInstance().savePhonesSmsCode(register.getPhone(),smsCode);

            result.setResult("success");
        }else{
            result.setResult("failure");
        }
        return result;
    }

    @Auth(role = Auth.Role.NONE)
    @ResponseBody
    @RequestMapping(value = "/sms/callback", method = RequestMethod.POST)
    public String registerSmsCallback(String phone,String code)
    {
        //TODO Receive code form sms server prepare for register add to cache(out date?)
        return "registerSmsCallback:"+ phone;
    }

    @Auth(role = Auth.Role.NONE)
    @ResponseBody
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public BaseResult register(@RequestBody Register register)
    {
        BaseResult result = new BaseResult();
        if(!checkCodeWithPhone(register.getPhone(),register.getCode()))
        {
            result.setResult("failure");
            return result;
        }

        try {
            service.register(register.getPhone(),register.getPassword(),register.getName());
            result.setResult("success");
        }catch (Exception ex){
            result.setResult("error");
            result.setError(ex.getMessage());
        }
        return result;
    }

    @Auth(role = Auth.Role.USER)
    @ResponseBody
    @RequestMapping(value = "/modify/password", method = RequestMethod.PUT)
    public BaseResult modifyPassword(@RequestBody UserAccount account)
    {
        BaseResult result = new BaseResult();
        try {
            User currentUser = (User)session.getAttribute(SessionContext.CURRENT_USER);
            if(account.getPhone().equals(currentUser.getPhone())&& (
                    (account.getPassword()!=null&&account.getPassword().equals(currentUser.getPassword()))
                            || (account.getCode()!=null&&checkCodeWithPhone(account.getPhone(),account.getCode()))
            )){

                service.setAccount(currentUser,currentUser.getPhone(),account.getNew_password());

                currentUser.setPassword(account.getNew_password());
                session.setAttribute(SessionContext.CURRENT_USER, currentUser);

                result.setResult("success");
            }
            else{
                result.setResult("failure");
            }
        }catch (Exception ex){
            result.setResult("error");
            result.setError(ex.getMessage());
        }
        return result;
    }

    @Auth(role = Auth.Role.USER)
    @ResponseBody
    @RequestMapping(value = "/modify/phone", method = RequestMethod.PUT)
    public BaseResult modifyAccount(@RequestBody UserAccount account)
    {
        BaseResult result = new BaseResult();
        try {
            User currentUser = (User)session.getAttribute(SessionContext.CURRENT_USER);
            if(account.getPhone().equals(currentUser.getPhone()) &&
                    checkCodeWithPhone(account.getPhone(),account.getCode())){
                service.setAccount(currentUser,account.getNew_phone(),currentUser.getPassword());

                currentUser.setPhone(account.getNew_phone());
                session.setAttribute(SessionContext.CURRENT_USER, currentUser);

                result.setResult("success");
            }
            else{
                result.setResult("failure");
            }
        }catch (Exception ex){
            result.setResult("error");
            result.setError(ex.getMessage());
        }
        return result;
    }

    @Auth(role = Auth.Role.USER)
    @ResponseBody
    @RequestMapping(value = "/modify/base", method = RequestMethod.PUT)
    public BaseResult modifyPos(@RequestBody UserBase base)
    {
        BaseResult result = new BaseResult();
        try {
            User currentUser = (User)session.getAttribute(SessionContext.CURRENT_USER);

            Position pos = new Position();
            if(base.getLat()!=null&&base.getLng()!=null){
                pos.setLat(base.getLat());
                pos.setLng(base.getLng());
                currentUser.setLat(base.getLat());
                currentUser.setLng(base.getLng());
            }else {
                pos.setLat(currentUser.getLat());
                pos.setLng(currentUser.getLng());
            }
            if (base.getName()!=null)
            {
                currentUser.setName(base.getName());
            }
            if( base.getPhoto()!=null)
            {
                currentUser.setPhoto(base.getPhoto());
            }

            service.setBase(currentUser, pos, currentUser.getName(), currentUser.getPhoto());

            session.setAttribute(SessionContext.CURRENT_USER, currentUser);

            result.setResult("success");
        }catch (Exception ex){
            result.setResult("error");
            result.setError(ex.getMessage());
        }
        return result;
    }

    @Auth(role = Auth.Role.USER)
    @RequestMapping(value="/list")
    public ModelAndView list(Model model)
    {
        logger.info("url:/user/list");

        ModelAndView mv = new ModelAndView();
        mv.setViewName("user_list");

        List<User> users= service.getAllUsers(1,10);
        mv.addObject("userList",users);

        return mv;
    }

    private boolean checkCodeWithPhone(String phone,String code)
    {
        //TODO Check code by key is phone
        if(code.equals("888"))//TempCode for test
        {
            return true;
        }
        if( PhoneSMSContext.getInstance().checkPhonesSmsCode(phone,code))
        {
            return true;
        }
        return false;
    }

    private String getRandNum(int charCount) {
        String charValue = "";
        for (int i = 0; i < charCount; i++) {
            char c = (char) (randomInt(0, 10) + '0');
            charValue += String.valueOf(c);
        }
        return charValue;
    }

    private int randomInt(int from, int to) {
        Random r = new Random();
        return from + r.nextInt(to - from);
    }
}
