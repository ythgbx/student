package net.bus.web.controller;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.filter.HTTPBasicAuthFilter;
import com.sun.jersey.core.util.MultivaluedMapImpl;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import net.bus.web.aspect.Auth;
import net.bus.web.common.config.RString;
import net.bus.web.context.PhoneSMSContext;
import net.bus.web.context.Position;
import net.bus.web.context.SessionContext;
import net.bus.web.controller.dto.*;
import net.bus.web.model.Pojo.PagePojo;
import net.bus.web.model.Pojo.SignRecordPojo;
import net.bus.web.model.User;
import net.bus.web.model.UserCoupon;
import net.bus.web.model.type.UserCouponType;
import net.bus.web.service.*;
import net.bus.web.service.impl.SignService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import net.bus.web.controller.dto.BaseResult;

import javax.servlet.http.HttpServletRequest;
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
    private HttpServletRequest _request;

    @Autowired
    private SignService signService;

    @Autowired
    private IUserCouponService _userCouponService;

    @Autowired
    private IFeedbackService _feedbackService;

    private Logger logger = Logger.getLogger(this.getClass().getName());

    @Value("#{sysProperties['smsDebug']}")
    private boolean _smsDebug;
    @Value("#{sysProperties['smsDebugCode']}")
    private String _smsDebugCode;
    @Autowired
    private FileUploadController fileUploadController;


    /**
     * 用户登录
     * @param login
     * @return
     */
    @Auth(role = Auth.Role.NONE)
    @ResponseBody
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ApiOperation(value = "用户登录", httpMethod = "POST", response = LoginResult.class, notes = "用户登录")
    public IResult login(@ApiParam(name = "login", value = "登陆登录")@RequestBody Login login)
    {
        User user = service.loginCheck(login.getPhone(),login.getPassword());

        LoginResult result = new LoginResult();

        if(user!=null) {
            session.setAttribute(SessionContext.CURRENT_USER, user);
            session.setAttribute(SessionContext.CURRENT_USER_ROLE, Auth.Role.USER);

            result.setSession_id(session.getId());
            result.setResult("success");
            result.setContent(RString.LOGIN_SUCCESS);
        }else{
            result.setSession_id(null);
            result.setResult("failure");
            result.setContent(RString.LOGIN_FAILED);
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
        userBase.setId(user.getId());
        userBase.setCertification(user,user.getRealName(),user.getIdCard());
        userBase.setWxBind(user,user.getWxUnionId());

        UserCoupon userCoupon = _userCouponService.getUserTimePeriodTicketCoupon(user.getId());
        userBase.setVip_type("common");//普通会员(不拥有时段优惠券用户)
        if(userCoupon!=null){

            if(userCoupon.getType().equals(UserCouponType.YearlyTicket.ordinal())){
                userBase.setVip_type("year");
            }else{
                userBase.setVip_type("month");
            }

            userBase.setExpiry_date(userCoupon.getEndTime().getTime());
        }

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
    @ApiOperation(value = "用户登出", httpMethod = "POST", response = BaseResult.class, notes = "用户登出")
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
    @ApiOperation(value = "发送短信验证码", httpMethod = "POST", response = BaseResult.class, notes = "发送短信验证码")
    public IResult registerSms(@ApiParam(required = true, name = "register", value = "注册-手机号")@RequestBody Register register)
    {
        BaseResult result = new BaseResult();
        if(register.getPhone()!=null&&register.getPhone()!=""){

            //避免接口被大量重复调用造成费用损失
            if(PhoneSMSContext.getInstance().checkPhone(register.getPhone())){
                result.setResult("failure");
                result.setContent(RString.SMS_FAILED_REPEAT_SEND);
                return result;
            }

            String smsCode = getRandNum(6);
            PhoneSMSContext.getInstance().savePhonesSmsCode(register.getPhone(), smsCode);

            if(!_smsDebug){
                if(smsCodeSend(register.getPhone(),smsCode)){
                    result.setResult("success");
                }else{
                    result.setResult("failure");
                    result.setContent(RString.SMS_FAILED_SEND);
                }
            }else{
                result.setResult("success");
                result.setContent(new String(smsCode));
            }
        }else{
            result.setResult("failure");
            result.setContent(RString.SMS_FAILED_NO_PHONE);
        }
        return result;
    }

    @Auth(role = Auth.Role.NONE)
    @ResponseBody
    @RequestMapping(value = "/sms/callback", method = RequestMethod.POST)
    @ApiOperation(value = "[弃]短信平台回调", httpMethod = "POST", response = BaseResult.class, notes = "[弃]短信平台回调")
    public String registerSmsCallback(String phone,String code)
    {
        //TODO Receive code form sms server prepare for register add to cache(out date?)
        return "registerSmsCallback:"+ phone;
    }

    @Auth(role = Auth.Role.NONE)
    @ResponseBody
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ApiOperation(value = "注册", httpMethod = "POST", response = BaseResult.class, notes = "注册")
    public IResult register(@ApiParam(required = true, name = "register", value = "注册请求")@RequestBody Register register)
    {
        BaseResult result = new BaseResult();
        if(!checkCodeWithPhone(register.getPhone(),register.getCode()).equals(PhoneSMSContext.SmsCheckResult.Success))
        {
            result.setResult("failure");
            result.setContent(RString.REGISTER_FAILED_SMS_CODE);
            return result;
        }

        try {
            if(service.registerCheck(register.getPhone())){
                service.register(register.getPhone(), register.getPassword(), register.getName());
                result.setResult("success");
            }else {
                result.setResult("failure");
                result.setContent(RString.REGISTER_FAILED_USER_HAD);
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
    @ApiOperation(value = "密码修改", httpMethod = "PUT", response = BaseResult.class, notes = "密码修改")
    public IResult modifyPassword(@ApiParam(required = true, name = "account",
            value = "用户账户请求-手机号+原密码+新密码")@RequestBody UserAccount account)
    {
        BaseResult result = new BaseResult();
        try {
            User currentUser = (User)session.getAttribute(SessionContext.CURRENT_USER);
            if(account.getPhone().equals(currentUser.getPhone())&&account.getNew_password()!=null&&(
                    (account.getPassword()!=null&&service.checkPassword(currentUser, account.getPassword())))){

                service.setAccount(currentUser, currentUser.getPhone(), account.getNew_password());

                session.setAttribute(SessionContext.CURRENT_USER, currentUser);

                result.setResult("success");
            }
            else{
                result.setResult("failure");
                result.setContent(RString.MODIFY_PASSWORD_FAILED);
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
    @ApiOperation(value = "密码找回", httpMethod = "PUT", response = BaseResult.class, notes = "密码找回")
    public IResult retrievePassword(@ApiParam(required = true, name = "account", value = "用户账户请求-手机号+短信验证码+新密码")@RequestBody UserAccount account)
    {
        BaseResult result = new BaseResult();
        try {
            if(account.getCode()!=null&&account.getNew_password()!=null&&checkCodeWithPhone(account.getPhone(), account.getCode()).equals(PhoneSMSContext.SmsCheckResult.Success)){
                User retrieveUser = service.getUser(account.getPhone());
                service.setAccount(retrieveUser,retrieveUser.getPhone(),account.getNew_password());
                result.setResult("success");
            }
            else{
                result.setResult("failure");
                result.setContent(RString.RETRIEVE_PASSWORD_FAILED);
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
    @ApiOperation(value = "手机号修改", httpMethod = "PUT", response = BaseResult.class, notes = "手机号修改")
    public IResult modifyAccount(@ApiParam(required = true, name = "account", value = "用户账户请求-手机号+短信验证码+新手机号")@RequestBody UserAccount account)
    {
        BaseResult result = new BaseResult();
        try {
            User currentUser = (User)session.getAttribute(SessionContext.CURRENT_USER);
            //if(account.getPhone().equals(currentUser.getPhone()) && checkCodeWithPhone(account.getPhone(),account.getCode()))
            if(account.getPhone().equals(currentUser.getPhone())){

                PhoneSMSContext.SmsCheckResult checkResult = checkCodeWithPhone(account.getNew_phone(), account.getCode());
                if(checkResult.equals(PhoneSMSContext.SmsCheckResult.Success)){
                    if(service.registerCheck(account.getNew_phone())) {
                        service.setAccount(currentUser,account.getNew_phone(),currentUser.getPassword());

                        currentUser.setPhone(account.getNew_phone());
                        session.setAttribute(SessionContext.CURRENT_USER, currentUser);

                        result.setResult("success");
                    }else{
                        result.setResult("failure");
                        result.setContent(RString.REGISTER_FAILED_USER_HAD);
                    }
                }else if(checkResult.equals(PhoneSMSContext.SmsCheckResult.OutDate)){
                    result.setResult("failure");
                    result.setContent(RString.MODIFY_PHONE_FAILED_CODE_OUT_DATE);
                }else if(checkResult.equals(PhoneSMSContext.SmsCheckResult.CodeError)){
                    result.setResult("failure");
                    result.setContent(RString.MODIFY_PHONE_FAILED_CODE_ERROR);
                }
            }
            else{
                result.setResult("failure");
                result.setContent(RString.MODIFY_PHONE_FAILED_PHONE);
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
    @ApiOperation(value = "基本信息修改", httpMethod = "PUT", response = BaseResult.class, notes = "基本信息修改")
    public IResult modifyBase(@ApiParam(required = true, name = "base", value = "用户基本信息请求-位置|名称|头像")@RequestBody UserBase base)
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
    @ApiOperation(value = "积分增加", httpMethod = "PUT", response = BaseResult.class, notes = "积分增加")
    public IResult addPoint(@ApiParam(required = true, name = "pointAdd", value = "用户积分增加请求")@RequestBody UserPointAdd pointAdd)
    {
        BaseResult result = new BaseResult();
        try {
            User currentUser = (User)session.getAttribute(SessionContext.CURRENT_USER);
            if(service.addPoint(currentUser,pointAdd.getAddNum())) {
                session.setAttribute(SessionContext.CURRENT_USER, currentUser);
                result.setResult("success");
            }else{
                result.setResult("failure");
                result.setContent(RString.ADD_POINT_FAILED);
            }
        }catch (Exception ex){
            result.setResult("error");
            result.setError(ex.getMessage());
        }
        return result;
    }

    /**
     * 用户提交反馈信息
     * @param feedbackResult
     * @return
     */
    @Auth(role = Auth.Role.USER)
    @ResponseBody
    @RequestMapping(value = "/feedback", method = RequestMethod.POST)
    @ApiOperation(value = "提交反馈", httpMethod = "POST", response = BaseResult.class, notes = "提交反馈")
    public IResult help(@ApiParam(name = "FeedbackResult", value = "帮助与反馈")@RequestBody FeedbackResult feedbackResult)
    {
        BaseResult result = new BaseResult();
        User user = (User) session.getAttribute(SessionContext.CURRENT_USER);
        _feedbackService.setUserFeedback(feedbackResult.getContent(),user.getId());
        result.setResult("success");
        return result;
    }


    @Auth(role = Auth.Role.USER)
    @ResponseBody
    @RequestMapping(value = "/certification", method = RequestMethod.POST)
    @ApiOperation(value = "实名认证", httpMethod = "POST", response = BaseResult.class, notes = "实名认证")

    public IResult certification(@ApiParam(name = "certificationResult", value = "实名认证")@RequestBody CertificationResult certificationResult){
        BaseResult result = new BaseResult();
        User user = (User) session.getAttribute(SessionContext.CURRENT_USER);
        if(service.userCertification(user,certificationResult.getRealName(),certificationResult.getIdCard()))
        {
            result.setResult("success");
        }else{
            result.setResult("failure");
        }
        return result;
    }





    @Auth(role = Auth.Role.USER)
    @ResponseBody
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    @ApiOperation(value = "修改头像", httpMethod = "POST", response = BaseResult.class, notes = "文件上传（文件查看路径为 your-website/upload/abc.png）")
    public IResult photo(@ApiParam(required = true, name = "file", value = "文件")@RequestParam("file") MultipartFile file) {
        BaseResult result = new BaseResult();
        BaseResult temp;
        temp = (BaseResult) fileUploadController.upload(file);
        User user = (User) session.getAttribute(SessionContext.CURRENT_USER);
        result.setResult("failed");
        result.setContent(RString.UPLOAD_PHOTO_FAILED);
        if(temp.getResult() == "success"){
            if(service.setPhoto(user,temp.getContent().toString())){
                result.setResult("success");
                result.setContent(temp.getContent());
            }
        }
        return result;
    }

    private PhoneSMSContext.SmsCheckResult checkCodeWithPhone(String phone,String code)
    {
        if(_smsDebug){
            //TempCode for sms debug
            if(code.equals(_smsDebugCode))
            {
                return PhoneSMSContext.SmsCheckResult.Success;
            }
        }

        return PhoneSMSContext.getInstance().checkPhonesSmsCode(phone,code);
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
        formData.add("message", "验证码："+code+"【追风巴士】");
        ClientResponse response =  webResource.type( MediaType.APPLICATION_FORM_URLENCODED).
                post(ClientResponse.class, formData);

        int status = response.getStatus();
        return (status==200);
    }
    //endregion


    //region 网页后台管理部分

    /**
     * 后台管理登录界面
     * @param model
     * @return
     */
    @RequestMapping(value="/login" , method = RequestMethod.GET)
    @ApiOperation(value = "登陆页面", httpMethod = "GET", response = ModelAndView.class, notes = "登陆页面")
    public ModelAndView index(Model model)
    {
        logger.info("url:/user");
        ModelAndView mv =new ModelAndView();
        mv.setViewName("user_login");
        return mv;
    }

    /**
     * 获取用户信息列表
     * @param page
     * @param limit
     * @param request
     * @param model
     * @return
     */
    @Auth(role = Auth.Role.USER)
    @RequestMapping(value="/list", method = RequestMethod.GET)
    @ApiOperation(value = "用户列表页面", httpMethod = "GET", response = ModelAndView.class, notes = "用户列表页面")
    public ModelAndView list(@ApiParam(required = true, name = "page", value = "页")@RequestParam(value = "page", required = true, defaultValue = "0")int page,
                             @ApiParam(required = true, name = "limit", value = "数量")@RequestParam(value = "limit", required = true, defaultValue = "10")int limit,
                             HttpServletRequest request,Model model)
    {
        logger.info("url:/user/list");
        HttpSession session = request.getSession();
        PagePojo pagePojo = new PagePojo(service.getAllCount(),limit,page);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("user_list");
        List<User> users= service.getAllUsers(page,limit);
        mv.addObject("userList",users);
        session.setAttribute("pagePojo",pagePojo);

        return mv;
    }

    @Auth(role = Auth.Role.USER)
    @ResponseBody
    @RequestMapping(value = "/recharge/point", method = RequestMethod.POST)
    @ApiOperation(value = "积分充值", httpMethod = "PUT", response = BaseResult.class, notes = "积分充值")
    public BaseResult rechargePoint(@ApiParam(required = true, name = "rechargePoint", value = "用户积分充值(管理员操作)")@RequestBody UserPointAdd pointAdd)
    {
        BaseResult result = new BaseResult();
        if(service.addPoint(service.getUser(pointAdd.getId()),pointAdd.getAddNum())){
            result.setResult("success");
            result.setContent("充值成功");
        }else{
            result.setResult("failure");
            result.setContent("充值失败");
        }
        return result;
        
    }

    @Auth(role = Auth.Role.NONE)
    @ResponseBody
    @ApiOperation(value = "笑傲江湖2016-11报名", httpMethod = "POST", response = BaseResult.class, notes = "笑傲江湖2016-11报名")
    @RequestMapping(value = "/sign",method = RequestMethod.POST)
    public IResult sign(@ApiParam(required = true, name = "sign", value = "报名请求")@RequestBody Register register)
    {
        BaseResult result = new BaseResult();
        User user = service.getUser(register.getPhone());
        if(user!=null){
            user.setSchool(register.getSchool());
            user.setInstitute(register.getInstitute());
            if (service.updateUser(user));{
                result.setResult("success");
                result.setContent("报名成功!");
                return result;
            }
        }else {
            if(!checkCodeWithPhone(register.getPhone(),register.getCode()).equals(PhoneSMSContext.SmsCheckResult.Success))
            {
                result.setResult("failure");
                result.setContent(RString.REGISTER_FAILED_SMS_CODE);
                return result;
            }
            try {
                if(service.registerCheck(register.getPhone())){
                    String password = getRandNum(6);
                    User user1 = service.registerByActive(register.getPhone(),password,
                            register.getName(),register.getSchool(),register.getInstitute(),RString.ACTIVE_COMMENT);
                    if (user1!=null&&smsCodeSend(register.getPhone(),"您的初始密码为:"+password)){
                        result.setResult("success");
                        result.setContent(password);
                    }else {
                        result.setResult("error");
                        result.setContent("报名失败,请重新报名!");
                    }
                }else {
                    result.setResult("failure");
                    result.setContent(RString.REGISTER_FAILED_USER_HAD);
                }
            }catch (Exception ex){
                result.setResult("error");
                result.setError(ex.getMessage());
            }

        }
        return result;
    }



}
