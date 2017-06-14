package net.bus.web.controller;

import net.bus.web.aspect.Auth;
import net.bus.web.common.Util;
import net.bus.web.controller.dto.BaseResult;
import net.bus.web.controller.dto.GrantDto;
import net.bus.web.controller.dto.IResult;
import net.bus.web.model.Grant;
import net.bus.web.service.IGrantService;
import net.bus.web.service.IUserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.Calendar;

/**
 * Created by sky on 16/12/1.
 * 此controller助学金操作
 */
@Controller
@RequestMapping("/grant")
public class GrantController {

    @Autowired
    private IGrantService service;

    @Autowired
    private IUserService userService;

    private Logger logger = Logger.getLogger(this.getClass().getName());

    @Autowired
    private FileUploadController fileUploadController;


    /**
     * 后台管理登录界面
     * @param model
     * @return
     */
    @Auth(role = Auth.Role.USER)
    @RequestMapping(value="/page" , method = RequestMethod.GET)
    public ModelAndView index(Model model)
    {
        logger.info("url:/grant/page");
        ModelAndView mv =new ModelAndView();
        mv.setViewName("Grants");
        return mv;
    }

    /**
     * 国家助学金申请
     * @param grantDto
     * @return
     */
    @Auth(role = Auth.Role.USER)
    @ResponseBody
    @RequestMapping(value = "/application", method = RequestMethod.POST)
    public IResult application(@RequestBody GrantDto grantDto){
        logger.info("url:/grant/application");
        BaseResult result = new BaseResult();
        Grant grant = service.getStudent(grantDto.getIdcard());
        if (grant!=null){
            Calendar a=Calendar.getInstance();
            if(Util.TimeToString(grant.getApplicationtime()).substring(0,4).equals(String.valueOf(a.get(Calendar.YEAR)))){
                result.setResult("error");
                result.setContent("本年度已申请过！");
            }else {
                service.insert(grantDto);
            }

        }else {
            if (service.insert(grantDto)){
                result.setResult("success");
                result.setContent("申请成功！");
            }else {
                result.setResult("error");
                result.setContent("申请失败！");
            }
        }
        return result;
    }
//        if (grant!=null){
//            result.setResult("failure");
//            result.setContent("您已申请!");
//        }else {
//            User user = userService.getUser(grantDto.getId());
//            user.setSchool(grantDto.getSchool());
//            user.setDepartment(grantDto.getDepartment());
//            user.setClasses(grantDto.getClasses());
//            user.setId(grantDto.getId());
//            user.setName(grantDto.getName());
//            user.setSex(grantDto.getSex());
//            user.setBirthdate(Util.StringToTime(grantDto.getBirthDate()));
//            user.setImg(grantDto.getImg());
//            user.setNation(grantDto.getNation());
//            user.setPoliticalstatus(grantDto.getPoliticalStatus());
//            user.setAdmissiondate(grantDto.getDatetime());
//            user.setIdcard(grantDto.getIdCard());
//            user.setTel(grantDto.getTel());
//            user.setQq(grantDto.getQq());
//            user.setResidence(grantDto.getResidence());
//            user.setAddress(grantDto.getAddress());
//            if (service.insert(grantDto)){
//                result.setContent("申请成功!");
//            }else {
//                result.setContent("申请失败!");
//            }
//        }
//
//        return result;
//    }
}
