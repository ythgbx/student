package net.bus.web.teacher;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * 返回页
 * Created by lenovo on 2017/6/9.
 */
@Controller
@RequestMapping("/page")
public class PageController {
    /**
     *
     * @return 学生信息页
     */
    @RequestMapping(value = "/stulist",method = RequestMethod.GET)
    public ModelAndView stulist(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/teacher/student_list");
        return modelAndView;
    }

    /**
     *
     * @return 贫困建档页
     */
    @RequestMapping(value = "/poorlist",method = RequestMethod.GET)
    public ModelAndView poorlist(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/teacher/poorbuild_list");
        return modelAndView;
    }
}
