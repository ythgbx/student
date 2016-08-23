package net.bus.web.controller;

import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import net.bus.web.aspect.Auth;
import net.bus.web.controller.dto.BaseResult;
import net.bus.web.controller.dto.IResult;
import net.bus.web.controller.dto.LogRequest;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Edifi_000 on 2016-08-23.
 */
@Controller
@RequestMapping("/logger")
public class LoggerController {

    private Logger logger = Logger.getLogger(this.getClass().getName());

    @Auth(role = Auth.Role.NONE)
    @ResponseBody
    @RequestMapping(value = "/info", method = RequestMethod.POST)
    @ApiOperation(value = "日志记录", httpMethod = "POST", response = BaseResult.class, notes = "日志记录")
    public IResult logInfo(@ApiParam(required = true, name = "request", value = "日志请求")@RequestBody LogRequest request)
    {
        BaseResult result = new BaseResult();
        //TODO 根据device id划分日志
        logger.info(request.getContent());
        result.setResult("success");
        return result;
    }

    @Auth(role = Auth.Role.NONE)
    @ResponseBody
    @RequestMapping(value = "/debug", method = RequestMethod.POST)
    @ApiOperation(value = "调试记录", httpMethod = "POST", response = BaseResult.class, notes = "调试记录")
    public IResult logDebug(@ApiParam(required = true, name = "request", value = "日志请求")@RequestBody LogRequest request)
    {
        BaseResult result = new BaseResult();
        //TODO 根据device id划分日志
        logger.debug(request.getContent());
        result.setResult("success");
        return result;
    }


    @Auth(role = Auth.Role.NONE)
    @ResponseBody
    @RequestMapping(value = "/warn", method = RequestMethod.POST)
    @ApiOperation(value = "警告记录", httpMethod = "POST", response = BaseResult.class, notes = "警告记录")
    public IResult logWarn(@ApiParam(required = true, name = "request", value = "日志请求")@RequestBody LogRequest request)
    {
        BaseResult result = new BaseResult();
        //TODO 根据device id划分日志
        logger.warn(request.getContent());
        result.setResult("success");
        return result;
    }

    @Auth(role = Auth.Role.NONE)
    @ResponseBody
    @RequestMapping(value = "/error", method = RequestMethod.POST)
    @ApiOperation(value = "错误记录", httpMethod = "POST", response = BaseResult.class, notes = "错误记录")
    public IResult logError(@ApiParam(required = true, name = "request", value = "日志请求")@RequestBody LogRequest request)
    {
        BaseResult result = new BaseResult();
        //TODO 根据device id划分日志
        logger.error(request.getContent());
        result.setResult("success");
        return result;
    }
}
