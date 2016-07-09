package net.bus.web.controller;

import net.bus.web.aspect.Auth;
import net.bus.web.context.SessionContext;
import net.bus.web.controller.dto.Login;
import net.bus.web.model.User;
import net.bus.web.repository.specification.UserPhonePasswordSpecification;
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
import java.util.UUID;

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
    public Login login(String phone, String password)
    {
        User user = service.loginCheck(phone,password);
        Login loginResult = new Login();

        if(user!=null) {
            session.setAttribute(SessionContext.CURRENT_USER, user);
            session.setAttribute(SessionContext.CURRENT_USER_ROLE, Auth.Role.USER);

            loginResult.setSession_id(session.getId());
            loginResult.setResult("success");
        }else{
            loginResult.setSession_id(null);
            loginResult.setResult("error");
        }

        return loginResult;
    }

    @Auth(role = Auth.Role.USER)
    @RequestMapping(value="/list")
    public ModelAndView list(Model model)
    {
        logger.info("url:/user/list");

        ModelAndView mv = new ModelAndView();
        mv.setViewName("user_list");

        List<User> users= service.getAllUsers(1,10);
        mv.addObject("userList",users);

        return mv;
    }
}
