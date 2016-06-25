package net.bus.web.controller;

import net.bus.web.model.User;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import net.bus.web.service.UserService;

import java.util.List;

@Controller
@RequestMapping("/")
public class HomeController {

    private Logger logger = Logger.getLogger(this.getClass().getName());

    @RequestMapping(value="/")
    public ModelAndView index(Model model)
    {
        logger.info("url:/");

        return new ModelAndView("redirect:/user/login");
    }
}
