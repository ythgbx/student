package net.bus.web.teacher;

import net.bus.web.service.impl.PoorBuildService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * Created by lenovo on 2017/6/10.
 */
@Controller
@RequestMapping("/puton")
public class PutOnRecordController {

    @Autowired
    private PoorBuildService poorBuildService;

    /**
     * @param page
     * @param rows
     * @return
     * @test @test http://localhost:8080/puton/getinfo?page=1&rows=10
     * method = RequestMethod.GET
     */
    @RequestMapping(value = "/getinfo", method = RequestMethod.POST)
    public @ResponseBody
    Map<String, Object> getAll(int page, int rows,
                               @RequestParam(required = false) String college,
                               @RequestParam(required = false) String profession,
                               @RequestParam(required = false) String classname) {
        return poorBuildService.getAllPoor(page, rows, college, profession, classname);
    }


}
