package net.bus.web.controller;

import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import net.bus.web.aspect.Auth;
import net.bus.web.context.AlipayCallBack;
import net.bus.web.controller.dto.BaseResult;
import net.bus.web.controller.dto.BaseRequest;
import net.bus.web.controller.dto.IResult;
import net.bus.web.service.IAlipayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
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

    @Auth(role = Auth.Role.NONE)
    @ResponseBody
    @RequestMapping(value = "/sign", method = RequestMethod.POST)
    @ApiOperation(value = "支付签名测试", httpMethod = "POST", response = BaseResult.class, notes = "支付签名测试")
    public IResult sign(@ApiParam(required = true, name = "request", value = "支付签名测试请求")@RequestBody BaseRequest request)
    {
        BaseResult result = new BaseResult();
        result.setResult("success");
        result.setContent(_alipayService.sign("测试商品1","商品介绍12345","0.01"));
        return result;
    }

    @Auth(role = Auth.Role.NONE)
    @ResponseBody
    @RequestMapping(value = "/async", method = RequestMethod.POST)
    @ApiOperation(value = "支付异步校验测试", httpMethod = "POST", response = String.class, notes = "支付异步校验测试")
    public String async(@ApiParam(required = true, name = "request", value = "支付异步校验测试请求") HttpServletRequest request)
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

        if(_alipayService.async(params)){
            return "success";
        }else{
            return "failed";
        }
    }

    @Auth(role = Auth.Role.NONE)
    @ResponseBody
    @RequestMapping(value = "/ret", method = RequestMethod.POST)
    @ApiOperation(value = "支付同步校验测试", httpMethod = "POST", response = String.class, notes = "支付同步校验测试")
    public String ret(@ApiParam(required = true, name = "request", value = "支付同步校验测试请求") HttpServletRequest request)
    {
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

        if(_alipayService.ret(prestr,params)){
            return "success";
        }else{
            return "failed";
        }
    }
}
