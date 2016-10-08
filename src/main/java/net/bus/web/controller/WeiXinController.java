package net.bus.web.controller;

import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import net.bus.web.aspect.Auth;
import net.bus.web.common.config.RString;
import net.bus.web.common.weixin.util.WeiXinCore;
import net.bus.web.context.SessionContext;
import net.bus.web.controller.dto.*;
import net.bus.web.model.User;
import net.bus.web.service.IUserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Map;

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
                    user = _userService.registerByWx(unionId,info.get("nickname"),info.get("headimgurl"));
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
}
