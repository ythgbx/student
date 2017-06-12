package net.bus.web.controller;

import net.bus.web.model.Classname;
import net.bus.web.model.College;
import net.bus.web.model.Professional;
import net.bus.web.service.IMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by yth on 2017/6/11.
 */
@Controller
@RequestMapping("/menu")
public class MenuController {
    @Autowired
    private IMenuService service;

    @RequestMapping(value="/getAllCollege" , method = RequestMethod.POST)
    public @ResponseBody List<College> getAll(){
       return service.getAll();
    }

    @RequestMapping(value="/getProfessional" , method = RequestMethod.POST)
    public @ResponseBody List<Professional> getProfessional(String  code){
        return service.getProfessional(code);
    }

    @RequestMapping(value="/getClassName" , method = RequestMethod.POST)
    public @ResponseBody List<Classname> getClassname(String  pcode){
        return service.getClassname(pcode);
    }


}
