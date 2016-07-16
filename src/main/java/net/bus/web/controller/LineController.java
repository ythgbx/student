package net.bus.web.controller;

import net.bus.web.aspect.Auth;
import net.bus.web.context.MockDataContext;
import net.bus.web.context.SessionContext;
import net.bus.web.controller.dto.BaseRequest;
import net.bus.web.controller.dto.BaseResult;
import net.bus.web.controller.dto.LineDetail;
import net.bus.web.controller.dto.LineItem;
import net.bus.web.model.Line;
import net.bus.web.model.User;
import net.bus.web.service.ILineService;
import net.bus.web.service.IUserLineService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
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
    private ILineService _lineService;
    @Autowired
    private IUserLineService _userLineService;
    @Autowired
    private HttpSession session;

    private Logger logger = Logger.getLogger(this.getClass().getName());

    @Auth(role = Auth.Role.USER)
    @ResponseBody
    @RequestMapping(value = "/list/around", method = RequestMethod.GET)
    public List around(double lat,double lng,int page,int limit)
    {
        logger.info("line around query");
//        List<Line> lineList = _lineService.getAroundLines(lat,lng,page,limit);
//        List<LineItem> displayList = getDisplayList(lineList);
//        return displayList;

        //Mock data for test
        return MockDataContext.getInstance().getLineItemList();
    }

    @Auth(role = Auth.Role.USER)
    @ResponseBody
    @RequestMapping(value = "/list/user", method = RequestMethod.GET)
    public List user(int page,int limit)
    {
//        logger.info("line user query");
//        User currentUser = (User)session.getAttribute(SessionContext.CURRENT_USER);
//        List<Line> lineList = _lineService.getUserLines(currentUser.getId(), page, limit);
//        List<LineItem> displayList = getDisplayList(lineList);
//        return displayList;

        //Mock data for test
        return MockDataContext.getInstance().getLineItemList();
    }

    @Auth(role = Auth.Role.USER)
    @ResponseBody
    @RequestMapping(value = "/list/station", method = RequestMethod.GET)
    public List station(String station_name,int page,int limit)
    {
//        logger.info("line station query");
//        List<Line> lineList = _lineService.getStationLines(station_name, page, limit);
//        List<LineItem> displayList = getDisplayList(lineList);
//        return displayList;

        //Mock data for test
        return MockDataContext.getInstance().getLineItemList();
    }

    @Auth(role = Auth.Role.USER)
    @ResponseBody
    @RequestMapping(value = "/list/all", method = RequestMethod.GET)
    public List all(int page,int limit)
    {
//        logger.info("line all query");
//        List<Line> lineList = _lineService.getAllLines(page,limit);
//        List<LineItem> displayList = getDisplayList(lineList);
//        return displayList;

        //Mock data for test
        return MockDataContext.getInstance().getLineItemList();
    }

    @Auth(role = Auth.Role.USER)
    @ResponseBody
    @RequestMapping(value = "/detail", method = RequestMethod.GET)
    public LineDetail detail(long id)
    {
        logger.info("line detail");
//        //TODO Get line detail
//        Line line = _lineService.getLineDetails(id);
//        LineDetail lineDetail = new LineDetail();
//        return lineDetail;

        //Mock data for test
        return MockDataContext.getInstance().getLineDetail();
    }

    @Auth(role = Auth.Role.USER)
    @ResponseBody
    @RequestMapping(value = "/collection", method = RequestMethod.POST)
    public BaseResult collection(@RequestBody BaseRequest request)
    {
        logger.info("line collection");
        BaseResult result = new BaseResult();
        try {
            User currentUser = (User) session.getAttribute(SessionContext.CURRENT_USER);

            //TODO Check line id
            int re = _userLineService.collectionLine(currentUser.getId(), request.getId());

            if(re>0) {
                result.setResult("success");
            }else{
                result.setResult("failure");
            }
        }catch (Exception ex){
            result.setResult("error");
            result.setError(ex.getMessage());
        }
        return result;
    }

    private List<LineItem> getDisplayList(List<Line> lineList)
    {
        List<LineItem> displayList = new ArrayList<LineItem>();
        for (Line line : lineList) {
            LineItem disItem = new LineItem();
            disItem.setId(line.getId());
            disItem.setStart_time(line.getStartTime().getTime());
            disItem.setEnd_time(line.getEndTime().getTime());
            disItem.setStart_station(line.getStart());
            disItem.setEnd_station(line.getEnd());
            disItem.setBus_img("line/1.png");
            disItem.setPrice(line.getPrice().doubleValue());
            displayList.add(disItem);
        }
        return displayList;
    }
}
