package net.bus.web.controller.Activity;

import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import net.bus.web.aspect.Auth;
import net.bus.web.controller.Activity.dto.XajhSign;
import net.bus.web.controller.dto.BaseResult;
import net.bus.web.controller.dto.IResult;
import net.bus.web.service.Activity.IXajhService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by sky on 16/11/11.
 */
@Controller
@RequestMapping("/xajh")
public class TempActiveController {

    @Autowired
    IXajhService xajhService;

    @Auth(role = Auth.Role.NONE)
    @ApiOperation(value = "笑傲江湖2016-11报名", httpMethod = "POST", response = BaseResult.class, notes = "笑傲江湖2016-11报名")
    @RequestMapping(value = "/sign",method = RequestMethod.POST)
    @ResponseBody
    public IResult sign(@ApiParam(value = "sign",required = true,name = "报名信息")@RequestBody(required = true) XajhSign sign){
        BaseResult result = new BaseResult();
        if(xajhService.sign(sign.getName(),sign.getPhone(),sign.getSchool(),sign.getInstitute())){
            result.setResult("success");
        }else{
            result.setResult("failure");
        }
        return result;
    }
}
