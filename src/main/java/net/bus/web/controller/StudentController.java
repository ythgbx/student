package net.bus.web.controller;

import net.bus.web.aspect.Auth;
import net.bus.web.common.Util;
import net.bus.web.context.SessionContext;
import net.bus.web.controller.dto.BaseResult;
import net.bus.web.controller.dto.IResult;
import net.bus.web.controller.dto.StudentDetail;
import net.bus.web.model.Student;
import net.bus.web.model.User;
import net.bus.web.service.IStudentService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
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
    @Auth(role = Auth.Role.STUDENT)
    @RequestMapping(value = "/information",method = RequestMethod.GET)
    public ModelAndView information(Model model){
        logger.info("url:/information");
        return new ModelAndView("basic_Information");
    }

    /**
     * 获取用户信息
     * @return
     */
    @Auth(role = Auth.Role.STUDENT)
    @ResponseBody
    @RequestMapping(value = "/getInfo",method = RequestMethod.GET)
    public IResult getInfo(){
        logger.info("url:/student/getInfo");
        BaseResult result = new BaseResult();
        StudentDetail studentDetail = new StudentDetail();
        User user = (User) session.getAttribute(SessionContext.CURRENT_USER);
        Student currentUser = service.getStudent(user.getUsername());
        try {
            if(currentUser!=null){
                studentDetail.setSno(currentUser.getSno());
                studentDetail.setSname(currentUser.getSname());
                studentDetail.setUsedname(currentUser.getUsedname());
                studentDetail.setSex(currentUser.getSex());
                studentDetail.setCollege(currentUser.getCollege());
                studentDetail.setIdcard(currentUser.getIdcard());
                studentDetail.setProfession(currentUser.getProfession());
                studentDetail.setClassname(currentUser.getClassname());
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
                if (currentUser.getBirthday()!=null){
                    studentDetail.setBirthday(Util.TimeToString(currentUser.getBirthday()));
                }
                studentDetail.setAddress(currentUser.getAddress());
                if (currentUser.getAdmissiontime()!=null){
                    studentDetail.setAdmissiontime(Util.TimeToString(currentUser.getAdmissiontime()));
                }
                studentDetail.setQq(currentUser.getQq());
                studentDetail.setFamilyaccount(currentUser.getFamilyaccount());
                result.setContent("数据获取成功");
                result.setResult("success");
                return studentDetail;
            }
            result.setContent("数据获取失败");
            result.setError("error");
        } catch (Exception e) {
            result.setResult("error");
            result.setContent("数据获取失败");
            result.setError(e.getMessage());
        }
        return result;
    }

    /**
     * 修改基本信息
     * @param studentDetail
     * @return
     */
    @Auth(role = Auth.Role.STUDENT)
    @ResponseBody
    @RequestMapping(value = "/updateInfo",method = RequestMethod.POST)
    public IResult perfectInfo(@RequestBody StudentDetail studentDetail){
        logger.info("/student/perfectInfor");
        BaseResult result = new BaseResult();
        Student student = service.getStudent(studentDetail.getIdcard());
        if (student!=null){
            student.setSno(studentDetail.getSno());
            student.setSname(studentDetail.getSname());
            student.setUsedname(studentDetail.getUsedname());
            student.setSex(studentDetail.getSex());
            student.setCollege(studentDetail.getCollege());
            student.setIdcard(studentDetail.getIdcard());
            student.setProfession(studentDetail.getProfession());
            student.setClassname(studentDetail.getClassname());
            student.setGrade(studentDetail.getGrade());
            student.setLevel(studentDetail.getLevel());
            student.setStudylength(studentDetail.getStudylength());
            student.setNationality(studentDetail.getNationality());
            student.setPolitical(studentDetail.getPolitical());
            student.setSroom(studentDetail.getSroom());
            student.setStel(studentDetail.getStel());
            student.setSchoolcard(studentDetail.getSchoolcard());
            student.setFname(studentDetail.getFname());
            student.setFtel(studentDetail.getFtel());
            student.setMname(studentDetail.getMname());
            student.setMtel(studentDetail.getMtel());
            student.setNativeplace(studentDetail.getNativeplace());
            student.setImg(studentDetail.getImg());
            student.setBirthday(Util.StringToTime(studentDetail.getBirthday()));
            student.setAddress(studentDetail.getAddress());
            student.setAdmissiontime(Util.StringToTime(studentDetail.getAdmissiontime()));
            student.setQq(studentDetail.getQq());
            student.setFamilyaccount(studentDetail.getFamilyaccount());
            if (service.update(student)){
                result.setContent("信息修改成功！");
                result.setResult("success");
            }
        }else {
            result.setResult("error");
            result.setContent("信息修改失败！");
        }
        return result;
    }

}
