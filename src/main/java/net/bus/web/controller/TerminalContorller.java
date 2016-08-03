package net.bus.web.controller;

import net.bus.web.aspect.Auth;
import net.bus.web.common.AES;
import net.bus.web.controller.dto.BaseResult;
import net.bus.web.controller.dto.IResult;
import net.bus.web.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

/**
 * Created by sky on 16/8/3.
 */

@Controller
@RequestMapping(value = "/terminal")
public class TerminalContorller {

    @Autowired
    private UserService userService;

    @Auth(role = Auth.Role.USER)
    @ResponseBody
    @RequestMapping(value = "/scanner", method = RequestMethod.POST)
    public IResult CheckQrcode(long code){
        BaseResult result = new BaseResult();
        result.setResult("success");
        result.setContent(code);
        return result;
    }

    @Auth(role = Auth.Role.NONE)
    @ResponseBody
    @RequestMapping(value = "/time", method = RequestMethod.GET)
    public IResult time(){
        Date  date = new Date();
        BaseResult result = new BaseResult();
        result.setResult("success");
        result.setContent(date.getTime());
        return result;
    }

    @Auth(role = Auth.Role.NONE)
    @ResponseBody
    @RequestMapping(value = "/check", method = RequestMethod.GET)
    public IResult check(String code){
        try {
            code = AES.getAesInstance().Decrypt(code);
            code.substring(code.length()-13);//13位UTF时间。毫秒数 e.g.1470209966047
            BaseResult result = new BaseResult();
            result.setResult("success");//暂时都成功逻辑以后再写
            result.setContent(code);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
