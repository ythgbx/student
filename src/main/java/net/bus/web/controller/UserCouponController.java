package net.bus.web.controller;

import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import net.bus.web.aspect.Auth;
import net.bus.web.controller.dto.BaseResult;
import net.bus.web.controller.dto.CouponRequest;
import net.bus.web.controller.dto.IResult;
import net.bus.web.service.IUserCouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.logging.Logger;

/**
 * Created by Edifi_000 on 2016-08-22.
 */
@Controller
@RequestMapping("/coupon")
public class UserCouponController {

    @Autowired
    private IUserCouponService _userCouponService;

    private Logger logger = Logger.getLogger(this.getClass().getName());

    @Auth(role = Auth.Role.USER)
    @ResponseBody
    @RequestMapping(value = "/monthly", method = RequestMethod.POST)
    @ApiOperation(value = "月卡添加", httpMethod = "POST", response = BaseResult.class, notes = "月卡优惠添加")
    public IResult addMonthly(@ApiParam(required = true, name = "request", value = "优惠请求")@RequestBody CouponRequest request){
        logger.info("coupon add monthly");
        BaseResult result = new BaseResult();
        if(_userCouponService.addMonthlyTicket(request.getUser_id(), new Date(request.getStart()),"","")){
            result.setResult("success");
        }else{
            result.setResult("failed");
        }
        return result;
    }

    @Auth(role = Auth.Role.USER)
    @ResponseBody
    @RequestMapping(value = "/yearly", method = RequestMethod.POST)
    @ApiOperation(value = "年卡添加", httpMethod = "POST", response = BaseResult.class, notes = "年卡优惠添加")
    public IResult addYearly(@ApiParam(required = true, name = "request", value = "优惠请求")@RequestBody CouponRequest request){
        logger.info("coupon add yearly");
        BaseResult result = new BaseResult();
        if(_userCouponService.addYearlyTicketTicket(request.getUser_id(), new Date(request.getStart()),"","")){
            result.setResult("success");
        }else{
            result.setResult("failed");
        }
        return result;
    }
}
