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
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

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
    @RequestMapping(value = "/checkLogin", method = RequestMethod.POST)
    @ApiOperation(value = "用户登录", httpMethod = "POST", response = LoginResult.class, notes = "用户登录")
    public IResult login(@ApiParam(name = "login", value = "登陆登录")@RequestBody Login login)
    {
        logger.info("url:/user/checkLogin");
        User user = service.loginCheck(login.getUserName(),login.getPassword(),login.getRole());
        LoginResult result = new LoginResult();
        if(user!=null) {
            session.setAttribute(SessionContext.CURRENT_USER, user);
            session.setAttribute(SessionContext.CURRENT_USER_ROLE, Auth.Role.getRole(user.getRole()));

            result.setSession_id(session.getId());
            result.setResult("success");
        }else{
            result.setResult("failure");
            result.setContent("用户名或密码错误！");
        }
        return result;
    }

    /**
     * 用户退出
     * @return
     */
    @Auth(role = Auth.Role.STUDENT)
    @ResponseBody
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public ModelAndView logout()
    {
        logger.info("url:/user/logout");
        session.removeAttribute(SessionContext.CURRENT_USER);
        session.removeAttribute(SessionContext.CURRENT_USER_ROLE);
        return new ModelAndView("redirect:/user/login");
    }

    /**
     * 根据用户角色进入不同界面
     * @param model
     * @return
     */
    @Auth(role = Auth.Role.STUDENT)
    @RequestMapping(value = "/main",method = RequestMethod.GET)
    public ModelAndView main(Model model){
        logger.info("url:/user");
        ModelAndView mv =new ModelAndView();
        User user = (User) session.getAttribute(SessionContext.CURRENT_USER);
        switch (user.getRole()){
            case 2:
                mv.setViewName("main_teacher");
                break;
            case 1:
                mv.setViewName("main_counselor");
                break;
            case 0:
                mv.setViewName("main_student");
                break;
        }
        return mv;
    }

    /**
     * 获取用户信息
     * @return
     */
    @Auth(role = Auth.Role.STUDENT)
    @ResponseBody
    @RequestMapping(value = "/getInfo",method = RequestMethod.GET)
    public IResult getInfo(){
        logger.info("url:/user/getInfo");
        BaseResult result = new BaseResult();
       return result;
    }
//
    /**
     * 进入用户信息修改界面
     * @param model
     * @return
     */
    @Auth(role = Auth.Role.STUDENT)
    @RequestMapping(value = "/information",method = RequestMethod.GET)
    public ModelAndView information(Model model){
        logger.info("url:/information");
        return new ModelAndView("basic_Information");
    }

    /**
     * 查询所有辅导员用户
     * @return
     */
    @Auth(role = Auth.Role.ADMIN)
    @RequestMapping(value = "/listCounselor",method = RequestMethod.GET)
    public @ResponseBody List<UserAccount> listCounselor(){
        logger.info("url:/listCounselor");
        BaseResult result = new BaseResult();
        List<User> users = service.getAll(1);
        List<UserAccount> accounts = new ArrayList<UserAccount>();
        for (User users1:users){
            UserAccount account = new UserAccount();
            account.setUsername(users1.getUsername());
            account.setPassword(users1.getPassword());
            account.setBindcourse(users1.getBindcourse());
            accounts.add(account);
        }
        return accounts;
    }

    /**
     * 管理员添加辅导员用户
     * @param account
     * @return
     */
    @Auth(role = Auth.Role.ADMIN)
    @RequestMapping(value = "/addCounselor",method = RequestMethod.POST)
    public IResult addCounselor(@RequestBody UserAccount account){
        logger.info("url:/user/addCounselor");
        BaseResult result = new BaseResult();

        User user =service.getUser(account.getUsername());
        if (user!=null){
            result.setContent("用户已存在！");
        }else {
            if (service.add(setUser(account))){
                result.setContent("添加成功！");
            }else {
                result.setContent("添加失败！");
            }
        }
        return result;
    }

    /**
     * 修改辅导员用户信息
     * @param account
     * @return
     */
    @Auth(role = Auth.Role.ADMIN)
    @RequestMapping(value = "/updateCounselor",method = RequestMethod.POST)
    public IResult updateCounselor(@RequestBody UserAccount account){
        logger.info("url:/updateCounselor");
        BaseResult result = new BaseResult();

        User user =service.getUser(account.getUsername());
        if (user!=null){
            if (service.update(setUser(account))){
                result.setContent("修改成功！");
            }else {
                result.setContent("修改失败！");
            }
        }else {
            result.setContent("修改失败！");
        }
        return result;

    }

    /**
     * 删除辅导员用户信息
     * @param account
     * @return
     */
    @Auth(role = Auth.Role.ADMIN)
    @RequestMapping(value = "/delCounselor",method = RequestMethod.POST)
    public IResult delCounselor(@RequestBody UserAccount account){
        logger.info("url:/delCounselor");
        BaseResult result = new BaseResult();
        if (service.del(account.getUsername())){
            result.setContent("删除成功！");
        }else {
            result.setContent("删除失败！");
        }
        return result;
    }



    public User setUser(UserAccount account){
        User current = new User();
        current.setUsername(account.getUsername());
        current.setPassword(account.getPassword());
        current.setName(account.getName());
        current.setRole(1);
        current.setBindcourse(account.getBindcourse());
        return current;
    }

//
//    /**
//     * 修改用户信息
//     * @return
//     */
//    @Auth(role = Auth.Role.USER)
//    @ResponseBody
//    @RequestMapping(value = "/updateInfo",method = RequestMethod.POST)
//    public IResult updateInfo(@ApiParam(name = "updateInfo", value = "修改用户信息")@RequestBody StudentDetail userDetail){
//        logger.info("url:/user/updateInfo");
//        BaseResult result = new BaseResult();
//        User user = service.getUser(userDetail.getId());
//        if(user!=null){
//            user.setSchool(userDetail.getSchool());
//            user.setDepartment(userDetail.getDepartment());
//            user.setGrade(userDetail.getGrade());
//            user.setSpecialty(userDetail.getSpecialty());
//            user.setName(userDetail.getName());
//            user.setImg(userDetail.getImg());
//            user.setSex(userDetail.getSex());
//            user.setNation(userDetail.getNation());
//            user.setBirthdate(Util.StringToTime(userDetail.getBirthDate()));
//            user.setAdmissiondate(Util.StringToTime(userDetail.getAdmissionDate()));
//            user.setPoliticalstatus(userDetail.getPoliticalStatus());
//            user.setStudylength(userDetail.getStudyLength());
//            user.setNativeplace(userDetail.getNativePlace());
//            user.setClasses(userDetail.getClasses());
//            user.setBankcard(userDetail.getBandCard());
//            user.setIdcard(userDetail.getIdCard());
//            user.setResidence(userDetail.getResidence());
//            user.setTel(userDetail.getTel());
//            user.setQq(userDetail.getQq());
//            user.setSroom(userDetail.getSroom());
//            user.setFname(userDetail.getFname());
//            user.setFtel(userDetail.getFtel());
//            user.setMname(userDetail.getMname());
//            user.setMtel(userDetail.getMtel());
//            user.setAddress(userDetail.getAddress());
//            user.setRemarks(userDetail.getRemarks());
//            if (service.update(user)){
//                result.setResult("success");
//                result.setContent("修改成功!");
//            }else {
//                result.setResult("error");
//                result.setContent("修改失败!");
//            }
//        }
//        return result;
//    }
//
//
//
    /**
     * 修改密码
     * @param account
     * @return
     */
    @Auth(role = Auth.Role.NONE)
    @ResponseBody
    @RequestMapping(value = "/modify/password", method = RequestMethod.PUT)
    public IResult modifyPassword(@RequestBody UserAccount account)
    {
        BaseResult result = new BaseResult();
        try {
            User currentUser = (User)session.getAttribute(SessionContext.CURRENT_USER);
            if(currentUser.getUsername().equals(account.getId())&&account.getPassword()!=null&&currentUser.getPassword().equals(account.getPassword())){

                service.setAccount(currentUser, currentUser.getUsername(), account.getNew_password());

                session.setAttribute(SessionContext.CURRENT_USER, currentUser);

                result.setResult("success");
                result.setContent("密码修改成功!");
            }
            else{
                result.setResult("failure");
                result.setContent("密码修改失败！");
            }
        }catch (Exception ex){
            result.setResult("error");
            result.setError(ex.getMessage());
        }
        return result;
    }

    /**
     * 找回密码
     * @param account
     * @return
     */
    @Auth(role = Auth.Role.NONE)
    @ResponseBody
    @RequestMapping(value = "/retrieve/password", method = RequestMethod.PUT)
    public IResult retrievePassword(@RequestBody UserAccount account)
    {
        BaseResult result = new BaseResult();
        try {
            User retrieveUser = service.getUser(account.getId());
            if (retrieveUser!=null){
                if (retrieveUser.getUsername().equals(account.getIdCard())){
                    service.setAccount(retrieveUser,retrieveUser.getUsername(),account.getNew_password());
                    result.setResult("success");
                    result.setContent("密码修改成功请从新登录!");
                }else {
                    result.setResult("error");
                    result.setContent("身份证号不正确!");
                }
            }
            else{
                result.setResult("error");
                result.setContent("用户名不正确!");
            }
        }catch (Exception ex){
            result.setResult("error");
            result.setError(ex.getMessage());
        }
        return result;
    }


}
