package net.bus.web.controller;

import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import net.bus.web.aspect.Auth;
import net.bus.web.common.config.RString;
import net.bus.web.common.weixin.util.ImgUtil;
import net.bus.web.common.weixin.util.WeiXinCore;
import net.bus.web.context.SessionContext;
import net.bus.web.controller.dto.*;
import net.bus.web.model.User;
import net.bus.web.service.IUserService;
import net.bus.web.service.IWxpayService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;
import java.util.UUID;

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
                    String headUrl = info.get("headimgurl");
                    try{
                        String dir = _request.getSession().getServletContext().getRealPath("/resources/upload");//设定文件保存的目录
                        String fileExt = ".jpg";
                        String fileName = UUID.randomUUID().toString()+fileExt;
                        ImgUtil.SaveUrlImg(info.get("headimgurl"), dir+"/"+fileName);
                        headUrl = fileName;
                    }catch (Exception e){
                        //ignore
                    }
                    user = _userService.registerByWx(unionId,info.get("nickname"),headUrl);
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
        BaseResult result = new BaseResult();
        result.setResult("success");
        Map<String,String> re = _wxpayService.prepay(1L);
        return result;
    }
}
