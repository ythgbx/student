package net.bus.web.controller;

import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import net.bus.web.aspect.Auth;
import net.bus.web.common.config.RString;
import net.bus.web.context.SessionContext;
import net.bus.web.controller.dto.*;
import net.bus.web.model.User;
import net.bus.web.service.IStudentService;
import net.bus.web.service.IUserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private IUserService service;
    @Autowired
    private HttpSession session;
    @Autowired
    private HttpServletRequest _request;


    private Logger logger = Logger.getLogger(this.getClass().getName());

    @Value("#{sysProperties['smsDebug']}")
    private boolean _smsDebug;
    @Value("#{sysProperties['smsDebugCode']}")
    private String _smsDebugCode;
    @Autowired
    private FileUploadController fileUploadController;



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
        mv.setViewName("login");
        return mv;
    }

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
        logger.info("url:/user/login");
        User user = service.loginCheck(login.getUserName(),login.getPassword());
        LoginResult result = new LoginResult();
        if(user!=null) {
            session.setAttribute(SessionContext.CURRENT_USER, user);
            session.setAttribute(SessionContext.CURRENT_USER_ROLE, Auth.Role.USER);

            result.setSession_id(session.getId());
            result.setResult("success");
            result.setContent(RString.LOGIN_SUCCESS);
        }else{
            result.setResult("failure");
            result.setContent(RString.LOGIN_FAILED);
        }
        return result;
    }

    @Auth(role = Auth.Role.USER)
    @RequestMapping(value = "/main",method = RequestMethod.GET)
    public ModelAndView main(Model model){
        logger.info("url:/user");
        ModelAndView mv =new ModelAndView();
        mv.setViewName("index");
        return mv;
    }

}
