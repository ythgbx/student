package net.bus.web.controller;

import net.bus.web.aspect.Auth;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by sky on 16/12/19.
 */
@Controller
@RequestMapping("/motivational")
public class Motivational {
    @Autowired
    private HttpSession session;
    @Autowired
    private HttpServletRequest _request;

    private Logger logger = Logger.getLogger(this.getClass().getName());

    @Auth (role = Auth.Role.USER)
    @RequestMapping(value="/page" , method = RequestMethod.GET)
    public ModelAndView motivational(){
        logger.info("url:/motivational/page");
        return new ModelAndView("motivational");
    }
}
