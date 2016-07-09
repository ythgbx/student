package net.bus.web.controller;

import net.bus.web.aspect.Auth;
import net.bus.web.context.SessionContext;
import net.bus.web.controller.dto.Login;
import net.bus.web.controller.dto.Register;
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
    public Login login(String phone, String password)
    {
        User user = service.loginCheck(phone,password);
        Login loginResult = new Login();

        if(user!=null) {
            session.setAttribute(SessionContext.CURRENT_USER, user);
            session.setAttribute(SessionContext.CURRENT_USER_ROLE, Auth.Role.USER);

            loginResult.setSession_id(session.getId());
            loginResult.setResult("success");
        }else{
            loginResult.setSession_id(null);
            loginResult.setResult("error");
        }

        return loginResult;
    }

    @Auth(role = Auth.Role.USER)
    @ResponseBody
    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    public String logout()
    {
        //TODO Remove session
        return "logout";
    }

    @Auth(role = Auth.Role.NONE)
    @ResponseBody
    @RequestMapping(value = "/register/sms", method = RequestMethod.POST)
    public String registerSms(@RequestBody Register register)
    {
        //TODO Request sms server for send code sms to the phone
        return "registerSms"+register.getPhone();
    }

    @Auth(role = Auth.Role.NONE)
    @ResponseBody
    @RequestMapping(value = "/register/sms/callback", method = RequestMethod.POST)
    public String registerSmsCallback(String phone,String code)
    {
        //TODO Receive code form sms server prepare for register add to cache(out date?)
        return "registerSmsCallback:"+ phone;
    }

    @Auth(role = Auth.Role.NONE)
    @ResponseBody
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public Register register(@RequestBody Register register)
    {
        //TODO Check register.code and then add User
        //User user = service.register(register.getPhone(),register.getPassword(),register.getName());
        return register;
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
}
