package net.bus.web.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

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
