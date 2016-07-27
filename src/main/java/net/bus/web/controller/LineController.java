package net.bus.web.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import net.bus.web.aspect.Auth;
import net.bus.web.context.MockDataContext;
import net.bus.web.context.Position;
import net.bus.web.context.SessionContext;
import net.bus.web.controller.dto.*;
import net.bus.web.model.Line;
import net.bus.web.model.Station;
import net.bus.web.model.User;
import net.bus.web.service.ILineService;
import net.bus.web.service.ILocationService;
import net.bus.web.service.IUserLineService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.*;

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
    private ILocationService _locationService;
    @Autowired
    private HttpSession session;

    private Logger logger = Logger.getLogger(this.getClass().getName());

    @Auth(role = Auth.Role.NONE)
    @ResponseBody
    @RequestMapping(value = "/list/around", method = RequestMethod.GET)
    public IResult around(double lat,double lng,int page,int limit)
    {
        logger.info("line around query");
        LineList lineList = new LineList();
        List<Line> lines = _lineService.getAroundLines(lat, lng, page, limit);
        lineList.setLines(getDisplayList(lines));
        lineList.setPage(page);
        lineList.setTotal_count(_lineService.getAroundLinesCount(lat,lng));
        return lineList;

//        //Mock data for test
//        LineList lineList = new LineList();
//        lineList.setLines(MockDataContext.getInstance().getLineItemList());
//        lineList.setPage(page);
//        return lineList;
    }

    @Auth(role = Auth.Role.USER)
    @ResponseBody
    @RequestMapping(value = "/list/user", method = RequestMethod.GET)
    public IResult user(int page,int limit)
    {
        logger.info("line user query");
        LineList lineList = new LineList();
        User currentUser = (User)session.getAttribute(SessionContext.CURRENT_USER);
        List<Line> lines = _lineService.getUserLines(currentUser.getId(), page, limit);
        lineList.setLines(getDisplayList(lines));
        lineList.setPage(page);
        lineList.setTotal_count(_lineService.getUserLinesCount(currentUser.getId()));
        return lineList;

//        //Mock data for test
//        LineList lineList = new LineList();
//        lineList.setLines(MockDataContext.getInstance().getLineItemList());
//        lineList.setPage(page);
//        return lineList;
    }

    @Auth(role = Auth.Role.NONE)
    @ResponseBody
    @RequestMapping(value = "/list/station", method = RequestMethod.GET)
    public IResult station(String station_name,int page,int limit)
    {
        logger.info("line station query");
        LineList lineList = new LineList();
        List<Line> lines = _lineService.getStationLines(station_name, page, limit);
        lineList.setLines(getDisplayList(lines));
        lineList.setPage(page);
        lineList.setTotal_count(_lineService.getStationLinesCount(station_name));
        return lineList;

//        //Mock data for test
//        LineList lineList = new LineList();
//        lineList.setLines(MockDataContext.getInstance().getLineItemList());
//        lineList.setPage(page);
//        return lineList;
    }

    @Auth(role = Auth.Role.NONE)
    @ResponseBody
    @RequestMapping(value = "/list/all", method = RequestMethod.GET)
    public IResult all(int page,int limit)
    {
        logger.info("line all query");
        LineList lineList = new LineList();
        List<Line> lines = _lineService.getAllLines(page, limit);
        lineList.setLines(getDisplayList(lines));
        lineList.setPage(page);
        lineList.setTotal_count(_lineService.getAllLinesCount());
        return lineList;

//        //Mock data for test
//        LineList lineList = new LineList();
//        lineList.setLines(MockDataContext.getInstance().getLineItemList());
//        lineList.setPage(page);
//        return lineList;
    }

    @Auth(role = Auth.Role.USER)
    @ResponseBody
    @RequestMapping(value = "/detail", method = RequestMethod.GET)
    public IResult detail(long id, @RequestParam(value = "lat", required = false, defaultValue = "0") double lat, @RequestParam(value = "lng", required = false, defaultValue = "0")double lng)
    {
        logger.info("line detail");
        //TODO Get line detail
        Line line = _lineService.getLineDetails(id);
        LineDetail lineDetail = new LineDetail();
        lineDetail.setId(line.getId());
        lineDetail.setStart_station(line.getStart());
        lineDetail.setEnd_station(line.getEnd());
        lineDetail.setStart_time(line.getStartTime().getTime());
        lineDetail.setEnd_time(line.getEndTime().getTime());
        lineDetail.setList_stations(line.getLatlng());
        lineDetail.setPrice(line.getPrice().doubleValue());

        if(lat!=0&&lng!=0){
            List<Station> stations = _locationService.getAroundStation(new Position(lat, lng));
            if(stations.size()>0){
                Station station = stations.get(0);
                lineDetail.setCurrent_station_id(station.getId());
            }
        }

        //TODO Use IBusService to get bus's tracks in line with direction??

        return lineDetail;

        ////Mock data for test
        //return MockDataContext.getInstance().getLineDetail();
    }

    @Auth(role = Auth.Role.USER)
    @ResponseBody
    @RequestMapping(value = "/collection", method = RequestMethod.PUT)
    public IResult collection(@RequestBody BaseRequest request)
    {
        logger.info("line collection");
        BaseResult result = new BaseResult();
        try {
            //Check line id
            if(request.getId()==null){
                result.setResult("failure request no line id");
                return result;
            }

            if(!_lineService.checkLineExist(request.getId())){
                result.setResult("failure no line id exist");
                return result;
            }

            User currentUser = (User) session.getAttribute(SessionContext.CURRENT_USER);

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

    @Auth(role = Auth.Role.USER)
    @ResponseBody
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public IResult add(@RequestBody LineRequest request)
    {
        logger.info("line add");
        BaseResult result = new BaseResult();
        try {
            Line line = new Line();
            List<LineStation> stations =  request.getList_stations();
            Collections.sort(stations, new Comparator<LineStation>() {
                //@Override
                public int compare(LineStation s1, LineStation s2) {
                    Integer s1Index = s1.getIndex();
                    Integer s2Index = s2.getIndex();
                    return s1Index.compareTo(s2Index);
                }

            });

            //TODO For check station ids
            List<Long> lineStationIds = new ArrayList<Long>();
            for(int i = 0;i<stations.size();i++){
                lineStationIds.add(stations.get(i).getId());
            }

            line.setName(request.getName());
            line.setStart(stations.get(0).getName());
            line.setEnd(stations.get(stations.size() - 1).getName());
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(request.getStart_time());
            line.setStartTime(calendar.getTime());
            calendar.setTimeInMillis(request.getEnd_time());
            line.setEndTime(calendar.getTime());
            line.setPrice(request.getPrice().intValue());
            line.setAnnotation(request.getAnnotation());

            ObjectMapper mapper = new ObjectMapper();
            line.setLatlng(mapper.writeValueAsString(stations));

            boolean re =  _lineService.addLine(line,lineStationIds);
            if(re) {
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
