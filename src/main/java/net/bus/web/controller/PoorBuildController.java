package net.bus.web.controller;

import net.bus.web.aspect.Auth;
import net.bus.web.common.Util;
import net.bus.web.controller.dto.BaseResult;
import net.bus.web.controller.dto.IResult;
import net.bus.web.controller.dto.PoorBuildDto;
import net.bus.web.model.PoorBuild;
import net.bus.web.model.Student;
import net.bus.web.service.IPoorBuildService;
import net.bus.web.service.IStudentService;
import org.apache.log4j.Logger;

import java.util.Calendar;
import java.util.Date;

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
        BaseResult result = new BaseResult();
        PoorBuild poorBuild = service.getPoorBuildByIdCard(poorBuildDto.getIdcard());
           if (poorBuild!=null){
               Calendar a=Calendar.getInstance();
                if (Util.TimeToString(poorBuild.getApplicationtime()).substring(0,4).equals(String.valueOf(a.get(Calendar.YEAR)))){
                    result.setResult("failure");
                    result.setContent("您已申请!");
                }else {
                    insert(poorBuild,poorBuildDto);
                }
           }else {
               PoorBuild create = new PoorBuild();
               insert(create,poorBuildDto);
           }
        return result;

    }

    public BaseResult insert(PoorBuild poorBuild,PoorBuildDto poorBuildDto ){
        BaseResult result = new BaseResult();
        poorBuild.setIdcard(poorBuildDto.getIdcard());
        poorBuild.setInsurance(poorBuildDto.getInsurance());
        poorBuild.setCode(poorBuildDto.getCode());
        poorBuild.setEconomicsources(poorBuildDto.getEconomicsources());
        poorBuild.setFamilyincome(poorBuildDto.getFamilyincome());
        poorBuild.setIsloan(poorBuildDto.getIsloan());
        poorBuild.setFworkplace(poorBuildDto.getFworkplace());
        poorBuild.setFearning(poorBuildDto.getFearning());
        poorBuild.setMworkplace(poorBuildDto.getMworkplace());
        poorBuild.setMearning(poorBuildDto.getMearning());
        poorBuild.setPopulation(poorBuildDto.getPopulation());
        poorBuild.setApplication(poorBuildDto.getApplication());
        poorBuild.setPoorprove(poorBuildDto.getPoorprove());
        poorBuild.setRetireprove(poorBuildDto.getRetireprove());
        poorBuild.setDeformityprove(poorBuildDto.getDeformityprove());
        poorBuild.setEfficiencyprove(poorBuildDto.getEfficiencyprove());
        poorBuild.setConditionprove(poorBuildDto.getConditionprove());
        poorBuild.setAwardsprove(poorBuildDto.getAwardsprove());
        poorBuild.setM1(poorBuildDto.getM1());
        poorBuild.setM1name(poorBuildDto.getM1name());
        poorBuild.setM1workplace(poorBuildDto.getM1workplace());
        poorBuild.setM1earning(poorBuildDto.getM1earning());
        poorBuild.setM2(poorBuildDto.getM2());
        poorBuild.setM2name(poorBuildDto.getM2name());
        poorBuild.setM2wordpress(poorBuildDto.getM2wordpress());
        poorBuild.setM2earning(poorBuildDto.getM2earning());
        poorBuild.setM3(poorBuildDto.getM3());
        poorBuild.setM3name(poorBuildDto.getM3name());
        poorBuild.setM3wordpress(poorBuildDto.getM3wordpress());
        poorBuild.setM3earning(poorBuildDto.getM3earning());
        poorBuild.setApplicationtime(new Date());
        if (service.insert(poorBuild)){
            result.setResult("success");
            result.setContent("申请成功!");
        }else {
            result.setResult("error");
            result.setContent("申请失败!");
        }
        return result;
    }


}
