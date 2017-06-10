package net.bus.web.teacher;

import net.bus.web.service.impl.PoorBuildService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by lenovo on 2017/6/10.
 */
@Controller
@RequestMapping("/puton")
public class PutOnRecordController {

    @Autowired
    private PoorBuildService poorBuildService;




}
