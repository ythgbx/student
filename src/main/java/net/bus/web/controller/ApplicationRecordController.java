package net.bus.web.controller;

import net.bus.web.context.SessionContext;
import net.bus.web.controller.dto.BaseResult;
import net.bus.web.controller.dto.IResult;
import net.bus.web.controller.dto.RecordDto;
import net.bus.web.model.User;
import net.bus.web.service.IApplicationRecordService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by yth on 2017/6/16.
 */
@Controller
@RequestMapping("/record")
public class ApplicationRecordController {
    @Autowired
    private IApplicationRecordService applicationRecordService;
    @Autowired
    private HttpSession session;
    @Autowired
    private HttpServletRequest _request;


    private Logger logger = Logger.getLogger(this.getClass().getName());

    @RequestMapping(value = "/get",method = RequestMethod.GET)
    @ResponseBody
    public List<RecordDto> get(){
        logger.info("url:/record/get");
        User user = (User) session.getAttribute(SessionContext.CURRENT_USER);
       List<RecordDto> recordDtos= applicationRecordService.getall(user.getUsername());
        if (recordDtos.isEmpty()){
            return recordDtos;
        }
        return null;
    }


}
