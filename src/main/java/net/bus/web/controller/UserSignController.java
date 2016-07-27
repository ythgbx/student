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
    @Auth(role = Auth.Role.USER)
    @ResponseBody
    @RequestMapping(method = RequestMethod.POST)
    public IResult uncheckedList()
    {
        User user = (User) session.getAttribute(SessionContext.CURRENT_USER);
        BaseResult result = new BaseResult();
        if(_signService.sign(user,new Date())){
            result.setResult("sign success!");
        }else{
            result.setResult("repeat sign!");
        }
        return result;
    }



}
