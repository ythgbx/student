package net.bus.web.controller;

import net.bus.web.aspect.Auth;
import net.bus.web.context.SessionContext;
import net.bus.web.controller.dto.*;
import net.bus.web.model.User;
import net.bus.web.service.ISignService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 * Created by sky on 16/7/26.
 */
@Controller
@RequestMapping("/sign")
public class UserSignController {
    @Autowired
    private ISignService _signService;
    @Autowired
    private HttpSession session;

    private Logger logger = Logger.getLogger(this.getClass().getName());

    /**
     * 每日签到
     * @return 返回当日签到所得的积分数
     */
    @Auth(role = Auth.Role.USER)
    @ResponseBody
    @RequestMapping(method = RequestMethod.POST)
    public IResult sign()
    {
        User user = (User) session.getAttribute(SessionContext.CURRENT_USER);
        SignResult result = new SignResult();
        int points = _signService.sign(user,new Date());
        if(points!=0){
            result.setPoints(points);
            result.setResult("success");
        }else{
            result.setResult("failure");
            result.setContent("今日已签到");
        }
        return result;
    }
}
