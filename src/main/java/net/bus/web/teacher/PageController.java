package net.bus.web.teacher;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by lenovo on 2017/6/9.
 */
@Controller
@RequestMapping("/page")
public class PageController {

    @RequestMapping(value = "/stulist",method = RequestMethod.GET)
    public ModelAndView stulist(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/teacher/student_list");
        return modelAndView;
    }
}
