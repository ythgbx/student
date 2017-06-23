package net.bus.web.controller;

import net.bus.web.aspect.Auth;
import net.bus.web.common.Util;
import net.bus.web.controller.dto.BaseResult;
import net.bus.web.controller.dto.IResult;
import net.bus.web.controller.dto.StudentDetail;
import net.bus.web.model.DataStatistics;
import net.bus.web.model.Motivational;
import net.bus.web.service.IMotivationalService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

/**
 * Created by sky on 16/12/19.
 */
@Controller
@RequestMapping("/motivational")
public class MotivationalController {
    @Autowired
    private HttpSession session;
    @Autowired
    private HttpServletRequest _request;

    @Autowired
    private IMotivationalService service;

    private IMotivationalService iMotivationalService;

    private Logger logger = Logger.getLogger(this.getClass().getName());

    @Auth (role = Auth.Role.STUDENT)
    @RequestMapping(value="/page" , method = RequestMethod.GET)
    public ModelAndView motivational(){
        logger.info("url:/motivational/page");
        return new ModelAndView("motivational");
    }

    /**
     * 国家助学金申请
     * @param motivation
     * @return
     */
    @Auth(role = Auth.Role.STUDENT)
    @ResponseBody
    @RequestMapping(value = "/application", method = RequestMethod.POST)
    public IResult application(@RequestBody StudentDetail motivation){
        logger.info("url:/grant/application");
        BaseResult result = new BaseResult();
        Motivational motivational = service.getStudent(motivation.getIdcard());
        try {
            if (motivational!=null){
                Calendar a=Calendar.getInstance();
                if(Util.TimeToString(motivational.getApplicationtime()).substring(0,4).equals(String.valueOf(a.get(Calendar.YEAR)))){
                    result.setResult("error");
                    result.setContent("本年度已申请过！");
                }else {
                    service.insert(motivation);
                }

            }else {
                if (service.insert(motivation)){
                    result.setResult("success");
                    result.setContent("申请成功！");
                }else {
                    result.setResult("error");
                    result.setContent("申请失败！");
                }
            }
        } catch (Exception e) {
            result.setContent("申请失败！");
        }
        return result;
    }

    /**
     * 获取各学院助学金数量
     * @param year
     * @return
     */
    @Auth(role = Auth.Role.ADMIN)
    @RequestMapping(value = "/statistics",method = RequestMethod.GET)
    public @ResponseBody
    List<DataStatistics> statistics(@RequestParam(required = false) Integer year){
        logger.info("url:/poorBuild/statistics");
        List<DataStatistics> lists = service.getNumMotivational(year);
        if (!lists.isEmpty()){
            return lists;
        }
        return null;
    }



    @RequestMapping(value = "/getmovational",method = RequestMethod.POST)
    public @ResponseBody
    Map<String,Object> getMovational(int page, int rows,
                                     @RequestParam(required = false) String college,
                                     @RequestParam(required = false) String profession,
                                     @RequestParam(required = false) String classname,
                                     @RequestParam(required = false) String sno,
                                     @RequestParam(required = false) String sname,
                                     @RequestParam(defaultValue = "0") String admin){
        return iMotivationalService.getMotivation(page, rows, college, profession, classname, sno, sname, admin);
    }
}
