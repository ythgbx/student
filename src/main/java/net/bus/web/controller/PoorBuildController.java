package net.bus.web.controller;

import net.bus.web.aspect.Auth;
import net.bus.web.common.Util;
import net.bus.web.context.SessionContext;
import net.bus.web.controller.dto.BaseResult;
import net.bus.web.model.DataStatistics;
import net.bus.web.controller.dto.IResult;
import net.bus.web.controller.dto.PoorBuildDto;
import net.bus.web.model.PoorBuild;
import net.bus.web.model.User;
import net.bus.web.service.IPoorBuildService;
import net.bus.web.service.IStudentService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

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

    @RequestMapping(value="/data" , method = RequestMethod.GET)
    public ModelAndView data(Model model)
    {
        ModelAndView mv =new ModelAndView();
        mv.setViewName("/teacher/dataAnalysis");
        return mv;
    }



    /**
     * 贫困申请
     * @param poorBuildDto
     * @return
     */
    @Auth(role = Auth.Role.STUDENT)
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
                    result.setContent("本年度您已申请过!");
                }else {
                    return insert(poorBuildDto);
                }
           }else {
              return insert(poorBuildDto);
           }
        return result;

    }

    public BaseResult insert(PoorBuildDto poorBuildDto ){
        PoorBuild poorBuild = new PoorBuild();
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
        poorBuild.setM2wordpress(poorBuildDto.getM2workplace());
        poorBuild.setM2earning(poorBuildDto.getM2earning());
        poorBuild.setM3(poorBuildDto.getM3());
        poorBuild.setM3name(poorBuildDto.getM3name());
        poorBuild.setM3wordpress(poorBuildDto.getM3workplace());
        poorBuild.setM3earning(poorBuildDto.getM3earning());
        poorBuild.setCounselorreview(0);
        poorBuild.setAdmin(0);
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

    /**
     *
     * @param idcard 身份证号
     * @param result  通过或不通过的标志
     * @param remarks  不通过的备注信息
     * @param session   当前登录用户的session
     * @return 修改成功的数据条数
     */
    @RequestMapping(value = "/examine",method = RequestMethod.POST)
    public @ResponseBody int updateAdmin(String idcard, Integer result,
                                         @RequestParam(required = false) String remarks, HttpSession session){
        User user = (User) session.getAttribute(SessionContext.CURRENT_USER);
        PoorBuild poorBuild = new PoorBuild();
        poorBuild.setIdcard(idcard);
        switch (user.getRole()){
            case 2:
                poorBuild.setAdmin(result);
                poorBuild.setAdminremarks(remarks);
                break;
            case 1:
                poorBuild.setCounselorreview(result);
                poorBuild.setCounselorreviewremarks(remarks);
                break;
        }
        return service.update(poorBuild);
    }

    /**
     * 获取各学院助学金数量
     * @param year
     * @return
     */
    @Auth(role = Auth.Role.ADMIN)
    @RequestMapping(value = "/statistics",method = RequestMethod.GET)
    public @ResponseBody List<DataStatistics> statistics(@RequestParam(required = false) Integer year){
        logger.info("url:/poorBuild/statistics");
        List<DataStatistics> lists = service.getNumPoor(year);
        if (!lists.isEmpty()){
            return lists;
        }
        return null;
    }

}
