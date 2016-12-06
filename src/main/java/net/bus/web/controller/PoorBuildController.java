package net.bus.web.controller;

import com.wordnik.swagger.annotations.ApiParam;
import net.bus.web.aspect.Auth;
import net.bus.web.common.Util;
import net.bus.web.controller.dto.BaseResult;
import net.bus.web.controller.dto.IResult;
import net.bus.web.controller.dto.PoorBuildDto;
import net.bus.web.model.User;
import net.bus.web.service.IPoorBuildService;
import net.bus.web.service.IUserService;
import org.apache.log4j.Logger;
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
    private IUserService userService;

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
    public IResult application(@ApiParam(name = "application", value = "贫困生建档申请")@RequestBody PoorBuildDto poorBuildDto)
    {
        logger.info("url:/poorBuild/application");
        BaseResult result = new BaseResult();
        User user = userService.getUser(poorBuildDto.getId());
        user.setSchool(poorBuildDto.getSchool());
        user.setName(poorBuildDto.getName());
        user.setSex(poorBuildDto.getSex());
        user.setBirthdate(Util.StringToTime(poorBuildDto.getBirthDate()));
        user.setNation(poorBuildDto.getNation());
        user.setStudylength(poorBuildDto.getStudyLength());
        user.setDepth(poorBuildDto.getDepth());
        user.setGrade(poorBuildDto.getGrade());
        user.setClasses(poorBuildDto.getClasses());
        user.setPoliticalstatus(poorBuildDto.getPoliticalStatus());
        user.setSroom(poorBuildDto.getSroom());
        user.setTel(poorBuildDto.getTel());
        user.setIdcard(poorBuildDto.getIdCard());
        user.setBankcard(poorBuildDto.getBandCard());
        user.setAddress(poorBuildDto.getAddress());
        user.setFname(poorBuildDto.getFname());
        user.setMname(poorBuildDto.getMname());
        userService.update(user);
        if (service.insert(poorBuildDto)){
            result.setResult("success");
            result.setContent("申请成功!");
        }else {
            result.setResult("error");
            result.setContent("申请失败!");
        }
        return result;
    }


}
