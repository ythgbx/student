package net.bus.web.controller;

import com.wordnik.swagger.annotations.ApiParam;
import net.bus.web.aspect.Auth;
import net.bus.web.common.AES;
import net.bus.web.controller.dto.BaseResult;
import net.bus.web.controller.dto.CheckData;
import net.bus.web.controller.dto.IResult;
import net.bus.web.controller.dto.TerminalRecords;
import net.bus.web.service.ITerminalRecordService;
import net.bus.web.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

/**
 * Created by sky on 16/8/3.
 */

@Controller
@RequestMapping(value = "/terminal")
public class TerminalController {

    @Autowired
    private UserService userService;
    @Autowired
    private ITerminalRecordService _terminalRecordService;

    @Auth(role = Auth.Role.USER)
    @ResponseBody
    @RequestMapping(value = "/scanner", method = RequestMethod.POST)
    public IResult checkQrcode(long code){
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
    @RequestMapping(value = "/check", method = RequestMethod.POST)
    public IResult check(@RequestBody CheckData data){
        BaseResult result = new BaseResult();
        try {
            String temp = "";
            for (String code : data.getCode()){
                code = AES.getAesInstance().Decrypt(code);
                code = code.substring(0,code.length()-13);//13位UTF时间。毫秒数 e.g.1470209966047 去掉时间剩下的就是用户
                temp+=code+";";
            }
            temp = temp.substring(0,temp.length()-1);
            result.setResult("success");//暂时都成功逻辑以后再写
            result.setContent(temp);
        } catch (Exception e) {
            e.printStackTrace();
            result.setResult("error");
            result.setError(e.getMessage());
        }
        return result;
    }

    @Auth(role = Auth.Role.NONE)
    @ResponseBody
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public IResult upload(@ApiParam(required = true, name = "request", value = "上传数据")@RequestBody TerminalRecords request){
        BaseResult result = new BaseResult();
        try {
            _terminalRecordService.upload(request.getDevice(),request.getData());
            result.setResult("success");
        } catch (Exception e) {
            e.printStackTrace();
            result.setResult("error");
            result.setError(e.getMessage());
        }
        return result;
    }

}
