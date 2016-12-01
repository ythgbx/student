package net.bus.web.controller;

import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import net.bus.web.aspect.Auth;
import net.bus.web.common.config.RString;
import net.bus.web.context.SessionContext;
import net.bus.web.controller.dto.*;
import net.bus.web.model.User;
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
        User user = service.loginCheck(login.getUserName(),login.getPassword(),login.getRole());
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

    /**
     * 用户退出
     * @return
     */
    @Auth(role = Auth.Role.USER)
    @ResponseBody
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public ModelAndView logout()
    {
        logger.info("url:/user/logout");
        session.removeAttribute(SessionContext.CURRENT_USER);
        session.removeAttribute(SessionContext.CURRENT_USER_ROLE);
        return new ModelAndView("redirect:/user/login");
    }

    @Auth(role = Auth.Role.USER)
    @RequestMapping(value = "/main",method = RequestMethod.GET)
    public ModelAndView main(Model model){
        logger.info("url:/user");
        ModelAndView mv =new ModelAndView();
        User user = (User) session.getAttribute(SessionContext.CURRENT_USER);
        switch (Integer.parseInt(user.getRole())){
            case 1:
                mv.setViewName("main_counselor");
                break;
            case 2:
                mv.setViewName("main_teacher");
                break;
            case 3:
                mv.setViewName("main_student");
                break;
        }
        return mv;
    }

    @Auth(role = Auth.Role.USER)
    @RequestMapping(value = "/getinfo",method = RequestMethod.GET)
    public IResult getInfo(){
        logger.info("user getinfo");
        BaseResult result = new BaseResult();
        UserDetail userDetail = new UserDetail();
        User user = (User) session.getAttribute(SessionContext.CURRENT_USER);
        User currentUser = service.getUser(user.getId());
        userDetail.setId(currentUser.getId());
        userDetail.setSchool(currentUser.getSchool());
        userDetail.setDepartment(currentUser.getDepartment());
        userDetail.setGrade(currentUser.getGrade());
        userDetail.setClasses(currentUser.getClasses());
        userDetail.setName(currentUser.getName());
        userDetail.setSex(currentUser.getSex());
        userDetail.setBirthdata(currentUser.getBirthdata());
        userDetail.setAdmissiondate(currentUser.getAdmissiondate());
        userDetail.setPoliticalstatus(currentUser.getPoliticalstatus());
        userDetail.setNation(currentUser.getNation());
        userDetail.setSpecialty(currentUser.getSpecialty());
        userDetail.setStudylength(currentUser.getStudylength());
        userDetail.setIdcard(currentUser.getIdcard());
        userDetail.setNativeplace(currentUser.getNativeplace());
        userDetail.setDepth(currentUser.getDepth());
        userDetail.setTel(currentUser.getTel());
        userDetail.setImg(currentUser.getImg());
        return userDetail;
    }

}
