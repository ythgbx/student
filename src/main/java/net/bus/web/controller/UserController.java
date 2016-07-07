package net.bus.web.controller;

import net.bus.web.aspect.Auth;
import net.bus.web.context.SessionContext;
import net.bus.web.model.User;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import net.bus.web.service.impl.UserService;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService service;
    @Autowired
    private HttpSession session;

    private Logger logger = Logger.getLogger(this.getClass().getName());

    @RequestMapping(value="/login")
    public ModelAndView index(Model model)
    {
        logger.info("url:/user");

        ModelAndView mv =new ModelAndView();
        mv.setViewName("user_login");

        return mv;
    }

    @Auth(role = Auth.Role.NONE)
    @ResponseBody
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView login()
    {
        session.setAttribute(SessionContext.CURRENT_USER,new Object());//TODO Object is temp use for test,then need add User replace Object
        session.setAttribute(SessionContext.CURRENT_USER_ROLE, Auth.Role.USER);

        ModelAndView mv =new ModelAndView();
        mv.setViewName("redirect:list");
        return mv;
    }

    @Auth(role = Auth.Role.USER)
    @RequestMapping(value="/list")
    public ModelAndView list(Model model)
    {
        logger.info("url:/user/list");

        ModelAndView mv = new ModelAndView();
        mv.setViewName("user_list");

        List<User> users= service.getAllUsers();
        mv.addObject("userList",users);

        return mv;
    }
}
