package net.bus.web.controller;

import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import net.bus.web.aspect.Auth;
import net.bus.web.common.weixin.util.PayCommonUtil;
import net.bus.web.context.SessionContext;
import net.bus.web.controller.dto.BaseResult;
import net.bus.web.controller.dto.BaseRequest;
import net.bus.web.controller.dto.IResult;
import net.bus.web.enums.OrderTypeEnum;
import net.bus.web.model.Pojo.AlipayAsyncCallBack;
import net.bus.web.model.User;
import net.bus.web.service.IAlipayService;
import net.bus.web.service.IOrderService;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by Edifi_000 on 2016-09-08.
 */
@Controller
@RequestMapping("/alipay")
public class AlipayController {

    @Autowired
    private IAlipayService _alipayService;
    @Autowired
    private HttpSession _session;
    @Autowired
    private IOrderService _orderService;

    private Logger logger = Logger.getLogger("CommonLogger");

    @Auth(role = Auth.Role.NONE)
    @ResponseBody
    @RequestMapping(value = "/sign", method = RequestMethod.POST)
    @ApiOperation(value = "支付签名测试", httpMethod = "POST", response = BaseResult.class, notes = "支付签名测试")
    public IResult sign(@ApiParam(required = true, name = "request", value = "支付签名测试请求")@RequestBody BaseRequest request)
    {
        BaseResult result = new BaseResult();
        result.setResult("success");
        result.setContent(_alipayService.sign("t123456789","测试商品1","商品介绍12345","0.01"));
        return result;
    }

    @Auth(role = Auth.Role.NONE)
    @ResponseBody
    @RequestMapping(value = "/async", method = RequestMethod.POST)
    @ApiOperation(value = "支付异步校验", httpMethod = "POST", response = String.class, notes = "支付异步校验")
    public String async(@ApiParam(required = true, name = "request", value = "支付异步校验请求") HttpServletRequest request)
    {
        Map params = new HashMap();
        Map requestParams = request.getParameterMap();
        for (Iterator iter = requestParams.keySet().iterator(); iter.hasNext();) {
            String name = (String) iter.next();
            String[] values = (String[]) requestParams.get(name);
            String valueStr = "";
            for (int i = 0; i < values.length; i++) {
                valueStr = (i == values.length - 1) ? valueStr + values[i]: valueStr + values[i] + ",";
            }
            try {
                valueStr=URLDecoder.decode(valueStr,"utf-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            params.put(name, valueStr);
        }

        if(_orderService.confirm(OrderTypeEnum.ALIPAY,params)){
            return "success";
        }else{
            return "failed";
        }
    }

    @Auth(role = Auth.Role.NONE)
    @ResponseBody
    @RequestMapping(value = "/ret", method = RequestMethod.POST)
    @ApiOperation(value = "支付同步校验测试", httpMethod = "POST",  response = BaseResult.class, notes = "支付同步校验测试")
    public IResult ret(@ApiParam(required = true, name = "request", value = "支付同步校验测试请求") HttpServletRequest request)
    {
        BaseResult result = new BaseResult();
        Map params = new HashMap();
        Map requestParams = request.getParameterMap();
        String prestr = "";
        for (Iterator iter = requestParams.keySet().iterator(); iter.hasNext();) {
            String name = (String) iter.next();
            String[] values = (String[]) requestParams.get(name);
            String valueStr = "";
            for (int i = 0; i < values.length; i++) {
                valueStr = (i == values.length - 1) ? valueStr + values[i]: valueStr + values[i] + ",";
            }

            try {
                valueStr=URLDecoder.decode(valueStr,"utf-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }

            params.put(name, valueStr);

            if(name.equals("sign") || name.equals("sign_type")){
                continue;
            }else{
                prestr = prestr + name + "=" + valueStr + "&";
            }
        }
        prestr=prestr.substring(0,prestr.length()-1);//去掉最后一个&符号。

        if(_alipayService.ret(prestr, params)){
            result.setResult("success");
        }else{
            result.setResult("failed");
        }
        return result;
    }

    @Auth(role = Auth.Role.USER)//TODO 测试完成需更改为ADMIN
    @ResponseBody
    @RequestMapping(value = "/refund", method = RequestMethod.POST)
    @ApiOperation(value = "退款", httpMethod = "POST", response = String.class, notes = "退款")
    public String refund(@ApiParam(required = true, name = "request", value = "退款请求") HttpServletRequest request)
    {
        User user = (User) _session.getAttribute(SessionContext.CURRENT_USER);
        _orderService.refund("AAoskmOqRXkeLj2RjgqJf",user.getId().toString());
        return PayCommonUtil.setXML("FAIL", "FAIL");
    }

    @Auth(role = Auth.Role.NONE)
    @ResponseBody
    @RequestMapping(value = "/refund/async", method = RequestMethod.POST)
    @ApiOperation(value = "支付异步校验", httpMethod = "POST", response = String.class, notes = "支付异步校验")
    public String refundAsync(@ApiParam(required = true, name = "request", value = "支付异步校验请求") HttpServletRequest request)
    {
        String logInfo = "";
        Map params = new HashMap();
        Map requestParams = request.getParameterMap();
        for (Iterator iter = requestParams.keySet().iterator(); iter.hasNext();) {
            String name = (String) iter.next();
            String[] values = (String[]) requestParams.get(name);
            String valueStr = "";
            for (int i = 0; i < values.length; i++) {
                valueStr = (i == values.length - 1) ? valueStr + values[i]: valueStr + values[i] + ",";
            }
            try {
                valueStr=URLDecoder.decode(valueStr,"utf-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            params.put(name, valueStr);
            //TODO temp record
            logInfo+=name+":"+valueStr;
        }
        logger.info("refundAsync:"+logInfo);

        return "success";
    }
}
