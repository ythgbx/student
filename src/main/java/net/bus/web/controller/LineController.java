package net.bus.web.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import net.bus.web.aspect.Auth;
import net.bus.web.context.BusTracks;
import net.bus.web.context.MockDataContext;
import net.bus.web.context.Position;
import net.bus.web.context.SessionContext;
import net.bus.web.controller.dto.*;
import net.bus.web.controller.dto.LineStation;
import net.bus.web.model.*;
import net.bus.web.model.Pojo.PagePojo;
import net.bus.web.service.IBusService;
import net.bus.web.service.ILineService;
import net.bus.web.service.ILocationService;
import net.bus.web.service.IUserLineService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
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
    private IBusService _busService;
    @Autowired
    private HttpSession session;

    private Logger logger = Logger.getLogger(this.getClass().getName());

    @Auth(role = Auth.Role.NONE)
    @ResponseBody
    @RequestMapping(value = "/list/around", method = RequestMethod.GET)
    @ApiOperation(value = "根据用户位置获取用户附近线路", httpMethod = "GET", response = LineList.class, notes = "根据用户位置获取用户附近线路")
    public IResult around(@ApiParam(required = true, name = "lat", value = "纬度")@RequestParam(value = "lat", required = true, defaultValue = "0")double lat,
                          @ApiParam(required = true, name = "lng", value = "经度")@RequestParam(value = "lng", required = true, defaultValue = "0")double lng,
                          @ApiParam(required = true, name = "page", value = "页")@RequestParam(value = "page", required = true, defaultValue = "1")int page,
                          @ApiParam(required = true, name = "limit", value = "数量")@RequestParam(value = "limit", required = true, defaultValue = "5")int limit)
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
    @ApiOperation(value = "根据用户获取用户收藏线路", httpMethod = "GET", response = LineList.class, notes = "根据用户获取用户收藏线路")
    public IResult user(@ApiParam(required = false, name = "city_name", value = "城市名称")@RequestParam(value = "city_name", required = false,defaultValue = "")String city_name,
                        @ApiParam(required = true, name = "page", value = "页")@RequestParam(value = "page", required = true, defaultValue = "1")int page,
                        @ApiParam(required = true, name = "limit", value = "数量")@RequestParam(value = "limit", required = true, defaultValue = "5")int limit)
    {
        logger.info("line user query");
        LineList lineList = new LineList();
        User currentUser = (User)session.getAttribute(SessionContext.CURRENT_USER);
        if(city_name.equals("")){
            List<Line> lines = _lineService.getUserLines(currentUser.getId(), page, limit);
            lineList.setLines(getDisplayList(lines));
            lineList.setPage(page);
            lineList.setTotal_count(_lineService.getUserLinesCount(currentUser.getId()));
        }else{
            List<Line> lines = _lineService.getUserLines(currentUser.getId(),city_name, page, limit);
            lineList.setLines(getDisplayList(lines));
            lineList.setPage(page);
            lineList.setTotal_count(_lineService.getUserLinesCount(currentUser.getId(),city_name));
        }
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
    @ApiOperation(value = "根据站点名称获取线路", httpMethod = "GET", response = LineList.class, notes = "根据用户获取用户收藏线路")
    public IResult station(@ApiParam(required = true, name = "station_name", value = "站点名称")String station_name,
                           @ApiParam(required = true, name = "page", value = "页")@RequestParam(value = "page", required = true, defaultValue = "1")int page,
                           @ApiParam(required = true, name = "limit", value = "数量")@RequestParam(value = "limit", required = true, defaultValue = "5")int limit)
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
    @ApiOperation(value = "获取全部线路", httpMethod = "GET", response = LineList.class, notes = "获取全部线路")
    public IResult all(@ApiParam(required = true, name = "page", value = "页")@RequestParam(value = "page", required = true, defaultValue = "1")int page,
                       @ApiParam(required = true, name = "limit", value = "数量")@RequestParam(value = "limit", required = true, defaultValue = "5")int limit)
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

    @Auth(role = Auth.Role.NONE)
    @ResponseBody
    @RequestMapping(value = "/list/city", method = RequestMethod.GET)
    @ApiOperation(value = "获取城市全部线路", httpMethod = "GET", response = LineList.class, notes = "获取城市全部线路")
    public IResult city(@ApiParam(required = true, name = "city_name", value = "城市名称")@RequestParam(value = "city_name", required = true)String city_name,
                        @ApiParam(required = true, name = "page", value = "页")@RequestParam(value = "page", required = true, defaultValue = "1")int page,
                        @ApiParam(required = true, name = "limit", value = "数量")@RequestParam(value = "limit", required = true, defaultValue = "5")int limit)
    {
        logger.info("line city query");
        LineList lineList = new LineList();
        List<Line> lines = _lineService.getCityLines(city_name, page, limit);
        lineList.setLines(getDisplayList(lines));
        lineList.setPage(page);
        lineList.setTotal_count(_lineService.getCityLinesCount(city_name));
        return lineList;

//        //Mock data for test
//        LineList lineList = new LineList();
//        lineList.setLines(MockDataContext.getInstance().getLineItemList());
//        lineList.setPage(page);
//        return lineList;
    }

    @Auth(role = Auth.Role.NONE)
    @ResponseBody
    @RequestMapping(value = "/list/prop", method = RequestMethod.GET)
    @ApiOperation(value = "获取属性全部线路", httpMethod = "GET", response = LineList.class, notes = "获取属性全部线路")
    public IResult prop(@ApiParam(required = true, name = "prop_name", value = "属性名称")@RequestParam(value = "prop_name", required = true)String prop_name,
                        @ApiParam(required = true, name = "page", value = "页")@RequestParam(value = "page", required = true, defaultValue = "1")int page,
                        @ApiParam(required = true, name = "limit", value = "数量")@RequestParam(value = "limit", required = true, defaultValue = "5")int limit)
    {
        logger.info("line prop query");
        LineList lineList = new LineList();
        List<Line> lines = _lineService.getPropLines(prop_name, page, limit);
        lineList.setLines(getDisplayList(lines));
        lineList.setPage(page);
        lineList.setTotal_count(_lineService.getPropLinesCount(prop_name));
        return lineList;

//        //Mock data for test
//        LineList lineList = new LineList();
//        lineList.setLines(MockDataContext.getInstance().getLineItemList());
//        lineList.setPage(page);
//        return lineList;
    }

    @Auth(role = Auth.Role.NONE)
    @ResponseBody
    @RequestMapping(value = "/detail", method = RequestMethod.GET)
    @ApiOperation(value = "获取线路详细", httpMethod = "GET", response = LineDetail.class, notes = "获取线路详细")
    public IResult detail(@ApiParam(required = true, name = "id", value = "id")@RequestParam(value = "id", required = true, defaultValue = "0")long id,
                          @ApiParam(required = true, name = "forward", value = "正向")@RequestParam(value = "forward", required = true, defaultValue = "true")boolean forward,
                          @ApiParam(required = false, name = "lat", value = "纬度")@RequestParam(value = "lat", required = false, defaultValue = "0") double lat,
                          @ApiParam(required = false, name = "lng", value = "经度")@RequestParam(value = "lng", required = false, defaultValue = "0")double lng)
    {
        logger.info("line detail");
        //TODO Get line detail
        Line line = _lineService.getLineDetails(id);
        if(line==null){
            BaseResult errResult = new BaseResult();
            errResult.setResult("failure");
            return errResult;
        }

        LineDetail lineDetail = new LineDetail();
        lineDetail.setId(line.getId());
        lineDetail.setStart_station(line.getStart());
        lineDetail.setEnd_station(line.getEnd());
        lineDetail.setStart_time(line.getStartTime().getTime());
        lineDetail.setEnd_time(line.getEndTime().getTime());
        lineDetail.setPrice(line.getPrice().doubleValue());

        List<Station> lineStations = _lineService.getStationList(line.getId());
        List<LineStation> lineStationList = new ArrayList<LineStation>();
        if(lineStations!=null){
            int stationIndex = 0;
            for(Station station:lineStations){
                LineStation lineStation = new LineStation();
                lineStation.setId(station.getId());
                lineStation.setName(station.getName());
                lineStation.setAnnotation(station.getAnnotation());
                lineStation.setPos(new net.bus.web.controller.dto.Position(station.getLat(), station.getLng()));
                lineStation.setIndex(stationIndex);

                lineStationList.add(lineStation);
                stationIndex++;
            }
        }
        lineDetail.setList_stations(lineStationList);


        if(lat!=0&&lng!=0){
            List<Station> stations = _locationService.getAroundStation(new Position(lat, lng));
            if(stations.size()>0){
                Station station = stations.get(0);
                lineDetail.setCurrent_station_id(station.getId());
            }
        }

        //TODO Use IBusService to get bus's tracks in line with direction??
        BusTracks.Direction direction = forward?BusTracks.Direction.Forward:BusTracks.Direction.Reverse;
        HashMap<Long,Integer> busesPosInLine = _busService.getBusesCurrentTrack(line.getId(), direction);
        Iterator it = busesPosInLine.keySet().iterator();
        List<LineBus> lineBuses = new ArrayList<LineBus>();
        while(it.hasNext()) {
            LineBus lineBus = new LineBus();
            Long key = (Long)it.next();
            lineBus.setId(key);
            lineBus.setPos(null);//暂时无用
            lineBus.setImg("car/1.png");
            lineBus.setPos_in_line(busesPosInLine.get(key));
            lineBuses.add(lineBus);
        }
        lineDetail.setList_buses(lineBuses);

        return lineDetail;

        ////Mock data for test
        //return MockDataContext.getInstance().getLineDetail();
    }

    @Auth(role = Auth.Role.NONE)
    @ResponseBody
    @RequestMapping(value = "/bus", method = RequestMethod.GET)
    @ApiOperation(value = "根据设备mac地址或车牌号获得线路", httpMethod = "GET", response = LineDetail.class, notes = "根据设备mac地址或车牌号获得线路")
    public IResult bus(@ApiParam(required = false, name = "name", value = "name",defaultValue = "鄂A12345")
                           @RequestParam(value = "name",required = false,defaultValue = "")String name,
                       @ApiParam(required = false, name = "device", value = "device",defaultValue = "b8:27:eb:6e:c5:84")
                       @RequestParam(value = "device",required = false,defaultValue = "")String device
                       )
    {
        IResult result = new BaseResult();
        Bus bus = _busService.getBus(name,device);
        if(bus!= null){
            result = this.detail(bus.getLineId(),true,0,0);
        }else{
            ((BaseResult)result).setResult("failure");
            ((BaseResult)result).setContent("bus is not bind");

        }
        return result;
    }

    @Auth(role = Auth.Role.USER)
    @ResponseBody
    @RequestMapping(value = "/collection", method = RequestMethod.PUT)
    @ApiOperation(value = "用户线路收藏", httpMethod = "PUT", response = BaseResult.class, notes = "用户线路收藏")
    public IResult collection(@ApiParam(required = true, name = "request", value = "基本请求")@RequestBody BaseRequest request)
    {
        logger.info("line collection");
        BaseResult result = new BaseResult();
        try {
            //Check line id
            if(request.getId()==null){
                result.setResult("failure");
                result.setContent("request no line id");
                return result;
            }

            if(!_lineService.checkLineExist(request.getId())){
                result.setResult("failure");
                result.setContent("no line id exist");
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
    @ApiOperation(value = "线路添加", httpMethod = "POST", response = BaseResult.class, notes = "线路添加")
    public IResult add(@ApiParam(required = true, name = "request", value = "线路请求")@RequestBody LineRequest request)
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
            line.setStart(request.getStart());
            line.setEnd(request.getEnd());
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(request.getStart_time());
            line.setStartTime(calendar.getTime());
            calendar.setTimeInMillis(request.getEnd_time());
            line.setEndTime(calendar.getTime());
            line.setPrice(request.getPrice().intValue());
            line.setAnnotation(request.getAnnotation());
            line.setCityName(request.getCity_name());
            line.setLatlng("");

            boolean re =  _lineService.addLine(line,lineStationIds);
            if(re) {
                result.setResult("success");
                result.setContent(line.getId());
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
            disItem.setName(line.getName());
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


    @Auth(role = Auth.Role.USER)
    @RequestMapping(value="/list", method = RequestMethod.GET)
    @ApiOperation(value = "线路列表页面", httpMethod = "GET", response = ModelAndView.class, notes = "线路列表页面")
    @ResponseBody
    public ModelAndView list(@ApiParam(required = true, name = "page", value = "页")@RequestParam(value = "page", required = true, defaultValue = "0")int page,
                             @ApiParam(required = true, name = "limit", value = "数量")@RequestParam(value = "limit", required = true, defaultValue = "10")int limit,
                             HttpServletRequest request, Model model)
    {
        logger.info("url:/line/list");
        HttpSession session=request.getSession();
        ModelAndView mv = new ModelAndView();
        mv.setViewName("line_list");
        List<Line> lines = _lineService.getAllLines(page,limit);
        PagePojo pagePojo = new PagePojo(_lineService.getAllLinesCount(),limit,page);
        mv.addObject("lineList",lines);
        session.setAttribute("pagePojo",pagePojo);
        return mv;
    }

    @Auth(role=Auth.Role.USER)
    @RequestMapping(value = "/addline",method = RequestMethod.POST)
    @ApiOperation(value = "添加线路",httpMethod = "POST",response = BaseResult.class,notes = "添加线路")
    @ResponseBody
    public  BaseResult AddActivity(@ApiParam(required = true, name = "addline", value = "添加线路请求")
                                   @RequestBody   Line line

    )  {
        logger.info("url:/line/addline");
        BaseResult result=new BaseResult();


        return result;


    }
}
