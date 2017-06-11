package net.bus.web.controller;

import net.bus.web.controller.dto.CollegeList;
import net.bus.web.controller.dto.IResult;
import net.bus.web.model.College;
import net.bus.web.service.IMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by yth on 2017/6/11.
 */
@Controller
@RequestMapping("/menu")
public class MenuController {
    @Autowired
    private IMenuService service;

    @RequestMapping(value="/getAllCollege" , method = RequestMethod.GET)
    public IResult getAll(){
        List<College> colleges = service.getAll();
        CollegeList collegeList = new CollegeList();
        collegeList.setColleges(colleges);
       return collegeList;
    }

}
