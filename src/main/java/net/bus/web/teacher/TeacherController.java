package net.bus.web.teacher;

import net.bus.web.mapper.StudentMapper;
import net.bus.web.model.Student;
import net.bus.web.model.StudentExample;
import net.bus.web.repository.specification.StudentSnoSpecification;
import net.bus.web.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.net.URLDecoder;
import java.util.List;
import java.util.Map;

/**
 * Created by lenovo on 2017/6/8.
 */
@Controller
@RequestMapping("/tea")
public class TeacherController {

    @Autowired
    private IStudentService iStudentService;



    /**
     * 分页查询所有学生的信息
     * @param page  页数默认1
     * @param rows  每页的数量，默认10
     * @return
     */

    @RequestMapping(value = "/query",method = RequestMethod.POST)
    public @ResponseBody Map reQuePage(int page, int rows){
        List<Student> list =  iStudentService.getAllStudents(page, rows);
        int total = iStudentService.getCount();
        return PageUtil.returnMap(list,total);
    }

    @RequestMapping(value = "")
    public List<String> select_options(){
        return null;
    }

    @RequestMapping(value = "queryBy",method = RequestMethod.POST)
    public ModelAndView queryBy(String college,String profession,String classname,String name){

        StudentSnoSpecification stusno = new StudentSnoSpecification(college, profession, classname,name );
        StudentExample studentExample = stusno.createExample();
        List<Student> list = iStudentService.getAllStudentsByExample(stusno,1,10);
        ModelAndView mv = new ModelAndView();
        mv.addObject("list",list);
        mv.setViewName("/teacher/content");
        return mv;
    }


}
