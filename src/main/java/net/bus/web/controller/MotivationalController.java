package net.bus.web.controller;

import net.bus.web.aspect.Auth;
import net.bus.web.service.IMotivationalService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * Created by sky on 16/12/19.
 */
@Controller
@RequestMapping("/motivational")
public class MotivationalController {
    @Autowired
    private HttpSession session;
    @Autowired
    private HttpServletRequest _request;

    @Autowired
    private IMotivationalService iMotivationalService;

    private Logger logger = Logger.getLogger(this.getClass().getName());

    @Auth (role = Auth.Role.USER)
    @RequestMapping(value="/page" , method = RequestMethod.GET)
    public ModelAndView motivational(){
        logger.info("url:/motivational/page");
        return new ModelAndView("motivational");
    }


    @RequestMapping(value = "/getmovational",method = RequestMethod.POST)
    public @ResponseBody
    Map<String,Object> getMovational(int page, int rows,
                                     @RequestParam(required = false) String college,
                                     @RequestParam(required = false) String profession,
                                     @RequestParam(required = false) String classname,
                                     @RequestParam(required = false) String sno,
                                     @RequestParam(required = false) String sname,
                                     @RequestParam(defaultValue = "0") String admin){
        return iMotivationalService.getMotivation(page, rows, college, profession, classname, sno, sname, admin);
    }
}
