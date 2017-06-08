package net.bus.web.controller;

import net.bus.web.aspect.Auth;
import net.bus.web.context.SessionContext;
import net.bus.web.controller.dto.IResult;
import net.bus.web.controller.dto.StudentDetail;
import net.bus.web.model.Student;
import net.bus.web.model.User;
import net.bus.web.service.IStudentService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by sky on 16/12/1.
 */
@Controller
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private IStudentService service;
    @Autowired
    private HttpSession session;
    @Autowired
    private HttpServletRequest _request;


    private Logger logger = Logger.getLogger(this.getClass().getName());

    @Autowired
    private FileUploadController fileUploadController;

    /**
     * 进入用户信息修改界面
     * @param model
     * @return
     */
    @Auth(role = Auth.Role.USER)
    @RequestMapping(value = "/information",method = RequestMethod.GET)
    public ModelAndView information(Model model){
        logger.info("url:/information");
        return new ModelAndView("basic_Information");
    }

    /**
     * 获取用户信息
     * @return
     */
    @Auth(role = Auth.Role.USER)
    @ResponseBody
    @RequestMapping(value = "/getInfo",method = RequestMethod.GET)
    public IResult getInfo(){
        logger.info("url:/user/getInfo");
        StudentDetail studentDetail = new StudentDetail();
        User user = (User) session.getAttribute(SessionContext.CURRENT_USER);
        Student currentUser = service.getStudent(user.getUsername());
        studentDetail.setSno(currentUser.getSno());
        studentDetail.setSname(currentUser.getSname());
        studentDetail.setUsedname(currentUser.getUsedname());
        studentDetail.setSex(currentUser.getSex());
        studentDetail.setCollege(currentUser.getCollege());
        studentDetail.setIdcard(currentUser.getIdcard());
        studentDetail.setProfession(currentUser.getProfession());
        studentDetail.setClassName(currentUser.getClassname());
        studentDetail.setGrade(currentUser.getGrade());
        studentDetail.setLevel(currentUser.getLevel());
        studentDetail.setStudylength(currentUser.getStudylength());
        studentDetail.setNationality(currentUser.getNationality());
        studentDetail.setPolitical(currentUser.getPolitical());
        studentDetail.setSroom(currentUser.getSroom());
        studentDetail.setStel(currentUser.getStel());
        studentDetail.setSchoolcard(currentUser.getSchoolcard());
        studentDetail.setFname(currentUser.getFname());
        studentDetail.setFtel(currentUser.getFtel());
        studentDetail.setMname(currentUser.getMname());
        studentDetail.setMtel(currentUser.getMtel());
        studentDetail.setNativeplace(currentUser.getNativeplace());
        studentDetail.setImg(currentUser.getImg());
        return studentDetail;
    }
}
