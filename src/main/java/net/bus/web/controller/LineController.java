package net.bus.web.controller;

import net.bus.web.aspect.Auth;
import net.bus.web.controller.jsonobj.LineItem;
import net.bus.web.model.Line;
import net.bus.web.service.LineService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Edifi_000 on 2016-07-04.
 */

@Controller
@RequestMapping("/line")
public class LineController {

    @Autowired
    private LineService _lineService;
    @Autowired
    private HttpSession session;

    private Logger logger = Logger.getLogger(this.getClass().getName());

    @Auth(role = Auth.Role.NONE)
    @ResponseBody
    @RequestMapping(value = "/list/around", method = RequestMethod.POST)
    public List around(double lat,double lng,int page)
    {
        logger.info("line around query");
        List<Line> lineList = _lineService.getAroundLines(lat,lng,page);
        List<LineItem> displayList = new ArrayList<LineItem>();
        for (Line line : lineList) {
            LineItem disItem = new LineItem();
            displayList.add(disItem);
        }
        return displayList;
    }
}
