package net.bus.web.controller;

import com.wordnik.swagger.annotations.ApiOperation;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by sky on 16/12/1.
 * 此controller助学金操作
 */
@Controller
@RequestMapping("/fellowship")
public class FellowshipController {


    private Logger logger = Logger.getLogger(this.getClass().getName());

    @Autowired
    private FileUploadController fileUploadController;


    /**
     * 后台管理登录界面
     * @param model
     * @return
     */
    @RequestMapping(value="/page" , method = RequestMethod.GET)
    public ModelAndView index(Model model)
    {
        logger.info("url:/fellowship/page");
        ModelAndView mv =new ModelAndView();
        mv.setViewName("Fellowship");
        return mv;
    }
}
