package net.bus.web.controller;

import net.bus.web.aspect.Auth;
import net.bus.web.controller.dto.BaseResult;
import net.bus.web.controller.dto.IResult;
import net.bus.web.controller.dto.PoorBuildDto;
import net.bus.web.model.PoorBuild;
import net.bus.web.model.Student;
import net.bus.web.service.IPoorBuildService;
import net.bus.web.service.IStudentService;
import net.bus.web.service.IUserService;
import org.apache.log4j.Logger;
import java.util.Calendar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by sky on 16/12/6.
 * 贫困建档操作
 */
@Controller
@RequestMapping("/poorBuild")
public class PoorBuildController {
    @Autowired
    private IStudentService studentService;

    @Autowired
    private IPoorBuildService service;

    private Logger logger = Logger.getLogger(this.getClass().getName());

    /**
     * 进入贫困建档申请界面
     * @param model
     * @return
     */
    @RequestMapping(value="/page" , method = RequestMethod.GET)
    public ModelAndView index(Model model)
    {
        logger.info("url:/poorBuild/page");
        ModelAndView mv =new ModelAndView();
        mv.setViewName("PoorBuild");
        return mv;
    }

    /**
     * 贫困申请
     * @param poorBuildDto
     * @return
     */
    @Auth(role = Auth.Role.USER)
    @ResponseBody
    @RequestMapping(value = "/application",method = RequestMethod.POST)
    public IResult application(@RequestBody PoorBuildDto poorBuildDto)
    {
        logger.info("url:/poorBuild/application");
        Calendar a=Calendar.getInstance();
        BaseResult result = new BaseResult();
        PoorBuild poorBuild = service.getPoorBuild(poorBuildDto.getIdcard());
        Student student = studentService.getStudent(poorBuildDto.getIdcard());
        if (poorBuild.getApplicationtime().getYear()==a.get(Calendar.YEAR)){
            result.setResult("failure");
            result.setContent("您已申请!");
        }else {
//            student.setCollege(poorBuildDto);

            if (service.insert(poorBuildDto)){
                result.setResult("success");
                result.setContent("申请成功!");
            }else {
                result.setResult("error");
                result.setContent("申请失败!");
            }
        }
        return result;
    }


}
