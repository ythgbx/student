package net.bus.web.controller;

import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import net.bus.web.aspect.Auth;
import net.bus.web.common.config.RString;
import net.bus.web.common.weixin.util.ImgUtil;
import net.bus.web.common.weixin.util.PayCommonUtil;
import net.bus.web.common.weixin.util.WeiXinCore;
import net.bus.web.common.weixin.util.XMLUtil;
import net.bus.web.context.SessionContext;
import net.bus.web.controller.dto.*;
import net.bus.web.enums.OrderTypeEnum;
import net.bus.web.enums.ProducedTypeEnum;
import net.bus.web.model.Pojo.Product;
import net.bus.web.model.Pojo.WxOrderCallBack;
import net.bus.web.model.User;
import net.bus.web.service.IOrderService;
import net.bus.web.service.IUserService;
import net.bus.web.service.IWxpayService;
import org.apache.commons.lang3.StringUtils;
import org.jdom.JDOMException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.URLDecoder;
import java.util.*;

/**
 * Created by Edifi_000 on 2016-10-07.
 */
@Controller
@RequestMapping("/weixin")
public class WeiXinController {

    @Autowired
    private IUserService _userService;
    @Autowired
    private HttpSession _session;
    @Autowired
    private HttpServletRequest _request;
    @Autowired
    private IWxpayService _wxpayService;
    @Autowired
    private IOrderService _orderService;

    @Auth(role = Auth.Role.NONE)
    @ResponseBody
    @RequestMapping(value = "/geInfo", method = RequestMethod.POST)
    @ApiOperation(value = "获取微信用户信息测试", httpMethod = "POST", response = BaseResult.class, notes = "获取微信用户信息测试")
    public IResult info(@ApiParam(required = true, name = "request", value = "微信用户信息请求")@RequestBody BaseRequest request)
    {
        BaseResult result = new BaseResult();
        WeiXinCore.getInfo("031u5AQ210MeZ12h8MP21wXCQ21u5AQb");
        result.setResult("success");
        return result;
    }

    @Auth(role = Auth.Role.NONE)
    @ResponseBody
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ApiOperation(value = "微信登录", httpMethod = "POST", response = LoginResult.class, notes = "微信登录")
    public IResult login(@ApiParam(required = true, name = "request", value = "微信用户信息请求")@RequestBody WeiXinLogin request)
    {
        LoginResult result = new LoginResult();
        if(StringUtils.isNoneBlank(request.getCode())){

            Map<String,String> info = WeiXinCore.getInfo(request.getCode());
            String unionId = (info!=null&&info.containsKey("unionid"))?info.get("unionid"):null;
            if(StringUtils.isNoneBlank(unionId)){
                User user = _userService.getUserByWx(unionId);
                if(user==null){
                    result.setSession_id(null);
                    result.setResult("failure");
                    return result;

//                    //取消自动注册逻辑
//                    String headUrl = info.get("headimgurl");
//                    try{
//                        String dir = _request.getSession().getServletContext().getRealPath("/resources/upload");//设定文件保存的目录
//                        String fileExt = ".jpg";
//                        String fileName = UUID.randomUUID().toString()+fileExt;
//                        ImgUtil.SaveUrlImg(info.get("headimgurl"), dir+"/"+fileName);
//                        headUrl = fileName;
//                    }catch (Exception e){
//                        //ignore
//                    }
//                    user = _userService.registerByWx(unionId,info.get("nickname"),headUrl);
                }

                _session.setAttribute(SessionContext.CURRENT_USER, user);
                _session.setAttribute(SessionContext.CURRENT_USER_ROLE, Auth.Role.USER);

                result.setSession_id(_session.getId());
                result.setResult("success");
                result.setContent(RString.LOGIN_SUCCESS);
            }else {
                //TODO code get info failure
                result.setSession_id(null);
                result.setResult("failure");
            }
        }else{
            //TODO code is null
            result.setSession_id(null);
            result.setResult("failure");
        }

        return result;
    }

    @Auth(role = Auth.Role.USER)
    @ResponseBody
    @RequestMapping(value = "/bind", method = RequestMethod.POST)
    @ApiOperation(value = "微信绑定", httpMethod = "POST", response = LoginResult.class, notes = "微信绑定")
    public IResult bind(@ApiParam(required = true, name = "request", value = "微信绑定请求")@RequestBody WeiXinLogin request)
    {
        BaseResult result = new BaseResult();
        if(StringUtils.isNoneBlank(request.getCode())){

            Map<String,String> info = WeiXinCore.getInfo(request.getCode());
            String unionId = (info!=null&&info.containsKey("unionid"))?info.get("unionid"):null;
            if(StringUtils.isNoneBlank(unionId)){
                User user = (User) _session.getAttribute(SessionContext.CURRENT_USER);
                String headUrl = user.getPhoto();

                try{
                    String dir = _request.getSession().getServletContext().getRealPath("/resources/upload");//设定文件保存的目录
                    String fileExt = ".jpg";
                    String fileName = UUID.randomUUID().toString()+fileExt;
                    ImgUtil.SaveUrlImg(info.get("headimgurl"), dir+"/"+fileName);
                    headUrl = fileName;
                }catch (Exception e){
                    //ignore
                }

                user = _userService.bindWx(user,unionId, info.get("nickname"), headUrl);

                _session.setAttribute(SessionContext.CURRENT_USER, user);
                _session.setAttribute(SessionContext.CURRENT_USER_ROLE, Auth.Role.USER);

                result.setResult("success");
            }else {
                result.setResult("failure");
            }
        }else{
            result.setResult("failure");
        }

        return result;
    }

    @Auth(role = Auth.Role.NONE)
    @ResponseBody
    @RequestMapping(value = "/headsavetest", method = RequestMethod.GET)
    @ApiOperation(value = "微信用户头像保存测试", httpMethod = "GET", response = BaseResult.class, notes = "微信用户头像保存测试")
    public IResult headSaveTest()
    {
        BaseResult result = new BaseResult();
        String dir = _request.getSession().getServletContext().getRealPath("/resources/upload");//设定文件保存的目录
        String fileName = UUID.randomUUID().toString();
        try{
            ImgUtil.SaveUrlImg("http://wx.qlogo.cn/mmopen/DJIYS2iaJCw3bM1oXIPcwiaIPUXWnicThAia1fsOEM29lJfBakwtJsaCKpKX2KcrjSHHlMPo8TzvaDkO8u8ar4vvf6gBAX4rbXC0/0",
                    dir+"/"+fileName+".jpg");
            result.setResult("success");
        }catch (Exception e){
            result.setResult("failed");
        }
        return result;
    }

    @Auth(role = Auth.Role.NONE)
    @ResponseBody
    @RequestMapping(value = "/paytest", method = RequestMethod.POST)
    @ApiOperation(value = "支付测试", httpMethod = "POST", response = LoginResult.class, notes = "支付测试")
    public IResult paytest(@ApiParam(required = true, name = "request", value = "支付测试请求")@RequestBody BaseRequest request)
    {
        WeiXinPrepay result = new WeiXinPrepay();
        try{
            Product product = new Product();
            product.setId(1L);
            product.setSubject("测试商品");
            product.setBody("测试商品描述");
            product.setPrice(BigDecimal.valueOf(0.01));
            product.setType(ProducedTypeEnum.COMMODITY);

//            String tradeNo = UUID.randomUUID().toString().replace("-", "");


            WxOrderCallBack orderCallBack = (WxOrderCallBack)_orderService.submit(8L, OrderTypeEnum.WXPAY,product,1);

            if(orderCallBack!=null&&StringUtils.isBlank(orderCallBack.getFailed())){
                result.setPartnerId(orderCallBack.getPartnerId());
                result.setPrepayId(orderCallBack.getPrepayId());
                result.setNonceStr(orderCallBack.getNonceStr());
                result.setTimeStamp(orderCallBack.getTimeStamp());
                result.setWxPackage(orderCallBack.getWxPackage());
                result.setSign(orderCallBack.getSign());
                result.setResult("success");
            }else{
                result.setResult("failed");
                result.setContent(orderCallBack.getFailed());
            }
        }catch (Exception e){
            result.setResult("error");
            result.setContent(e.getMessage());
        }


        return result;
    }

    @Auth(role = Auth.Role.NONE)
    @ResponseBody
    @RequestMapping(value = "/async", method = RequestMethod.POST)
    @ApiOperation(value = "支付异步校验测试", httpMethod = "POST", response = String.class, notes = "支付异步校验测试")
    public String async(@ApiParam(required = true, name = "request", value = "支付异步校验测试请求") HttpServletRequest request)
    {
        try{
            InputStream in=request.getInputStream();
            ByteArrayOutputStream out=new ByteArrayOutputStream();
            byte[] buffer =new byte[1024];
            int len;
            while((len=in.read(buffer))!=-1){
                out.write(buffer, 0, len);
            }
            out.close();
            in.close();
            String msgXml=new String(out.toByteArray(),"utf-8");//xml数据
            Map params = XMLUtil.doXMLParse(msgXml);
            if(_wxpayService.async(params)){
                return PayCommonUtil.setXML("SUCCESS", "OK");
            } else{
                return PayCommonUtil.setXML("FAIL", "FAIL");
            }
        }catch (Exception e){
            return PayCommonUtil.setXML("FAIL", "ERROR");
        }
    }
}
