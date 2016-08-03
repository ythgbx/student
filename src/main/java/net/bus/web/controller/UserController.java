package net.bus.web.controller;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.filter.HTTPBasicAuthFilter;
import com.sun.jersey.core.util.MultivaluedMapImpl;
import net.bus.web.aspect.Auth;
import net.bus.web.context.PhoneSMSContext;
import net.bus.web.context.Position;
import net.bus.web.context.SessionContext;
import net.bus.web.controller.dto.*;
import net.bus.web.model.Pojo.SignRecordPojo;
import net.bus.web.model.User;
import net.bus.web.service.IPointRecordService;
import net.bus.web.service.impl.SignService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import net.bus.web.service.IUserService;

import javax.servlet.http.HttpSession;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.Random;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private IUserService service;
    @Autowired
    private HttpSession session;

    @Autowired
    private IPointRecordService pointRecordService;

    @Autowired
    private SignService signService;

    private Logger logger = Logger.getLogger(this.getClass().getName());

    @Value("#{sysProperties['smsDebug']}")
    private boolean _smsDebug;
    @Value("#{sysProperties['smsDebugCode']}")
    private String _smsDebugCode;

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
    public IResult login(@RequestBody Login login)
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

    /**
     * 获取用户信息
     * @return 用户信息result
     */
    @Auth(role = Auth.Role.USER)
    @ResponseBody
    @RequestMapping(value = "/getinfo", method = RequestMethod.GET)
    public IResult getInfo(){
        User user = (User) session.getAttribute(SessionContext.CURRENT_USER);
        user = service.getUser(user.getId());
        session.setAttribute(SessionContext.CURRENT_USER,user);
        UserBase userBase = new UserBase();
        userBase.setPoints(user.getPoints());
        userBase.setPhone(user.getPhone());
        userBase.setPhoto(user.getPhoto());
        return userBase;
    }

    /**
     * 获得用户积分
     * @return 用户积分result
     */
    @Auth(role = Auth.Role.USER)
    @ResponseBody
    @RequestMapping(value = "/getPoints", method = RequestMethod.GET)
    public IResult getPoints(){
        User user = (User) session.getAttribute(SessionContext.CURRENT_USER);
        user = service.getUser(user.getId());
        session.setAttribute(SessionContext.CURRENT_USER, user);
        UserBase userBase = new UserBase();
        userBase.setPoints(user.getPoints());
        return userBase;
    }

    /**
     * 获得用户签到记录
     * @return 用户签到记录
     */
    @Auth(role = Auth.Role.USER)
    @ResponseBody
    @RequestMapping(value = "/getsignrecord", method = RequestMethod.GET)
    public IResult getSignRecord(int page,int limit){
        User user = (User) session.getAttribute(SessionContext.CURRENT_USER);
        List<SignRecordPojo> records = signService.getSignRecordByUserId(user.getId(),page,limit);
        int totoal_count = pointRecordService.getSignRecordCount(user);
        SignRecordList signRecordList = new SignRecordList();
        for (SignRecordPojo item : records){
            signRecordList.getList().add(new SignRecordItem(item.getSuccession(),item.getAccount()));
        }
        signRecordList.setPage(page);
        signRecordList.setTotal_count(totoal_count);
        return signRecordList;
    }

    @Auth(role = Auth.Role.USER)
    @ResponseBody
    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    public IResult logout()
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
    public IResult registerSms(@RequestBody Register register)
    {
        BaseResult result = new BaseResult();
        if(register.getPhone()!=""){

            //避免接口被大量重复调用造成费用损失
            if(PhoneSMSContext.getInstance().checkPhone(register.getPhone())){
                result.setResult("failure");
                return result;
            }

            String smsCode = getRandNum(6);
            PhoneSMSContext.getInstance().savePhonesSmsCode(register.getPhone(), smsCode);

            if(!_smsDebug){
                if(smsCodeSend(register.getPhone(),smsCode)){
                    result.setResult("success");
                }else{
                    result.setResult("failure");
                }
            }else{
                result.setResult("success");
                result.setContent(new String(smsCode));
            }
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
    public IResult register(@RequestBody Register register)
    {
        BaseResult result = new BaseResult();
        if(!checkCodeWithPhone(register.getPhone(),register.getCode()))
        {
            result.setResult("failure");
            return result;
        }

        try {
            if(service.registerCheck(register.getPhone())){
                service.register(register.getPhone(), register.getPassword(), register.getName());
                result.setResult("success");
            }else {
                result.setResult("failure user had");
            }
        }catch (Exception ex){
            result.setResult("error");
            result.setError(ex.getMessage());
        }
        return result;
    }

    @Auth(role = Auth.Role.USER)
    @ResponseBody
    @RequestMapping(value = "/modify/password", method = RequestMethod.PUT)
    public IResult modifyPassword(@RequestBody UserAccount account)
    {
        BaseResult result = new BaseResult();
        try {
            User currentUser = (User)session.getAttribute(SessionContext.CURRENT_USER);
            if(account.getPhone().equals(currentUser.getPhone())&&account.getNew_password()!=null&&(
                    (account.getPassword()!=null&&account.getPassword().equals(currentUser.getPassword())))){

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

    @Auth(role = Auth.Role.NONE)
    @ResponseBody
    @RequestMapping(value = "/retrieve/password", method = RequestMethod.PUT)
    public IResult retrievePassword(@RequestBody UserAccount account)
    {
        BaseResult result = new BaseResult();
        try {
            if(account.getCode()!=null&&account.getNew_password()!=null&&checkCodeWithPhone(account.getPhone(), account.getCode())){
                User retrieveUser = service.getUser(account.getPhone());
                service.setAccount(retrieveUser,retrieveUser.getPhone(),account.getNew_password());
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
    public IResult modifyAccount(@RequestBody UserAccount account)
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
    public IResult modifyPos(@RequestBody UserBase base)
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
    @ResponseBody
    @RequestMapping(value = "/add/point", method = RequestMethod.POST)
    public IResult modifyPoint(@RequestBody UserPointAdd pointAdd)
    {
        BaseResult result = new BaseResult();
        try {
            User currentUser = (User)session.getAttribute(SessionContext.CURRENT_USER);
            if(service.addPoint(currentUser,pointAdd.getAddNum())) {
                session.setAttribute(SessionContext.CURRENT_USER, currentUser);
                result.setResult("success");
            }else{
                result.setResult("failure");
            }
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
        if(_smsDebug){
            //TempCode for sms debug
            if(code.equals(_smsDebugCode))
            {
                return true;
            }
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

    private boolean smsCodeSend(String phone,String code){
        Client client = Client.create();
        client.addFilter(new HTTPBasicAuthFilter(
                "api","key-4d8e068e8d8b5084ada9a49ff8621333"));//螺丝帽 sms api key
        WebResource webResource = client.resource(
                "http://sms-api.luosimao.com/v1/send.json");
        MultivaluedMapImpl formData = new MultivaluedMapImpl();
        formData.add("mobile", phone);
        formData.add("message", "验证码："+code+"【铁壳测试】");//TODO 待提交签名审核后修改为追风巴士
        ClientResponse response =  webResource.type( MediaType.APPLICATION_FORM_URLENCODED).
                post(ClientResponse.class, formData);

        int status = response.getStatus();
        return (status==200);
    }
}
