package net.bus.web.controller;

import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import net.bus.web.aspect.Auth;
import net.bus.web.context.StationsLocationContext;
import net.bus.web.controller.dto.*;
import net.bus.web.model.Pojo.PagePojo;
import net.bus.web.model.Station;
import net.bus.web.service.ILineService;
import net.bus.web.service.IStationService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Edifi_000 on 2016-07-27.
 */
@Controller
@RequestMapping("/station")
public class StationController {

    @Autowired
    private IStationService _stationService;

    private Logger logger = Logger.getLogger(this.getClass().getName());

    @Auth(role = Auth.Role.NONE)
    @ResponseBody
    @RequestMapping(value = "/list/all", method = RequestMethod.GET)
    @ApiOperation(value = "获取全部站点", httpMethod = "GET", response = StationList.class, notes = "获取全部站点")
    public IResult all(@ApiParam(required = true, name = "page", value = "页")@RequestParam(value = "page", required = true, defaultValue = "1")int page,
                       @ApiParam(required = true, name = "limit", value = "数量")@RequestParam(value = "limit", required = true, defaultValue = "5")int limit)
    {
        logger.info("station all query");
        StationList stationList = new StationList();
        List<Station> lines = _stationService.getAllStations(page, limit);
        stationList.setStations(getDisplayList(lines));
        stationList.setPage(page);
        stationList.setTotal_count(_stationService.getAllStationsCount());
        return stationList;
    }

    @Auth(role = Auth.Role.NONE)
    @ResponseBody
    @RequestMapping(value = "/list/prop", method = RequestMethod.GET)
    @ApiOperation(value = "获取属性的全部站点", httpMethod = "GET", response = StationList.class, notes = "获取属性的全部站点")
    public IResult prop(@ApiParam(required = true, name = "prop_name", value = "属性名称")@RequestParam(value = "prop_name", required = true)String prop_name)
    {
        logger.info("station prop query");
        StationList stationList = new StationList();
        List<Station> stations = _stationService.getPropStations(prop_name);
        stationList.setStations(getDisplayList(stations));
        stationList.setTotal_count(stations.size());
        return stationList;
    }

    @Auth(role = Auth.Role.USER)
    @ResponseBody
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ApiOperation(value = "站点添加", httpMethod = "POST", response = BaseResult.class, notes = "站点添加")
    public IResult add(@ApiParam(required = true, name = "request", value = "站点请求")@RequestBody StationRequest request)
    {
        logger.info("station add");
        BaseResult result = new BaseResult();
        try{
            Station station = new Station();
            station.setName(request.getName());
//            station.setLat(request.getPos().getLat());
//            station.setLng(request.getPos().getLng());
            station.setLng(request.getLng());
            station.setLat(request.getLat());
            station.setAnnotation(request.getAnnotation());
            station.setPrice(request.getPrice());
            if(_stationService.addStation(station)){
                result.setResult("success");
                result.setContent("添加成功!");
            }else{
                result.setResult("failed");
                result.setContent("添加失败!");
            }
        }catch (Exception ex){
            result.setResult("error");
            result.setError(ex.getMessage());
        }
        return result;
    }

    @Auth(role = Auth.Role.NONE)//TODO 待完成admin用户登录后,切换到admin用户
    @ResponseBody
    @RequestMapping(value = "/cache/all", method = RequestMethod.POST)
    @ApiOperation(value = "缓存全量刷新", httpMethod = "POST", response = BaseResult.class, notes = "缓存全量刷新")
    public IResult cacheAllRefresh(@ApiParam(required = true, name = "request", value = "全量刷新请求")@RequestBody BaseRequest request)
    {
        logger.info("station cache refresh all");
        BaseResult result = new BaseResult();
        try{
            StationsLocationContext.getInstance(_stationService).refreshAll();
            result.setResult("success");

        }catch (Exception ex){
            result.setResult("error");
            result.setError(ex.getMessage());
        }
        return result;
    }

    private List<StationItem> getDisplayList(List<Station> stationList)
    {
        List<StationItem> displayList = new ArrayList<StationItem>();
        for (Station station : stationList) {
            StationItem stationItem = new StationItem();
            stationItem.setId(station.getId());
            stationItem.setName(station.getName());
            stationItem.setPos(new Position(station.getLat(), station.getLng()));
            stationItem.setAnnotation(station.getAnnotation());
            stationItem.setPrice(station.getPrice());
            displayList.add(stationItem);
        }
        return displayList;
    }


    @Auth(role = Auth.Role.NONE)
    @ResponseBody
    @RequestMapping(value = "/listAll", method = RequestMethod.GET)
    @ApiOperation(value = "获取全部站点", httpMethod = "GET", response = StationList.class, notes = "获取全部站点")
    public ModelAndView all(@ApiParam(required = true, name = "page", value = "页")@RequestParam(value = "page", required = true, defaultValue = "0")int page,
                            @ApiParam(required = true, name = "limit", value = "数量")@RequestParam(value = "limit", required = true, defaultValue = "10")int limit,
                            HttpServletRequest request)
    {
        logger.info("station all query");
        ModelAndView mv = new ModelAndView();
        HttpSession session = request.getSession();
        StationList stationList = new StationList();
        PagePojo pagePojo = new PagePojo(_stationService.getAllStationsCount(),limit,page);
        List<Station> lines = _stationService.getAllStations(page, limit);
        stationList.setStations(getDisplayList(lines));
        session.setAttribute("pagePojo",pagePojo);
        session.setAttribute("stationList",stationList);
        mv.setViewName("station_list");
        return mv;
    }


    /**
     * 站点操作(支持批量删除)
     * @param request
     * @return
     */
    @RequestMapping(value="/del", method = RequestMethod.DELETE)
    @ApiOperation(value = "批量删除站点", httpMethod = "POST", response = BaseResult.class, notes = "批量删除站点")
    @ResponseBody
    public BaseResult del(@ApiParam(required = true, name = "request", value = "站点编号列表")
                                   @RequestBody BaseRequest request)
    {
        logger.info("station del");
        BaseResult result = new BaseResult();
        List<Long> ids = request.getIds();
        if(_stationService.del(ids)){
            result.setResult("success");
            result.setContent("删除成功");
        }else{
            result.setResult("failure");
            result.setContent("删除失败");
        }
        return result;
    }

    /**
     * 根据Id获取站点详情
     * @param id
     * @return
     */
    @Auth(role = Auth.Role.NONE)
    @ResponseBody
    @RequestMapping(value = "/detail", method = RequestMethod.GET)
    @ApiOperation(value = "获取商品详细", httpMethod = "GET", response = CommodityDetail.class, notes = "获取站点详情")
    public IResult detail(@ApiParam(required = true, name = "id", value = "id")@RequestParam(value = "id", required = true, defaultValue = "0")long id)
    {
        StationItem stationItem = new StationItem();
        Station station = _stationService.getDetails(id);
        stationItem.setId(station.getId());
        stationItem.setName(station.getName());
        stationItem.setPos(new Position(station.getLat(),station.getLng()));
        stationItem.setAnnotation(station.getAnnotation());
        stationItem.setPrice(station.getPrice());
        return stationItem;
    }

    /**
     * 站点修改
     * @param request
     * @return
     */
    @Auth(role = Auth.Role.USER)
    @ResponseBody
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ApiOperation(value = "站点修改", httpMethod = "POST", response = BaseResult.class, notes = "站点修改")
    public IResult update(@ApiParam(required = true, name = "request", value = "站点请求")@RequestBody StationRequest request)
    {
        logger.info("station update");
        BaseResult result = new BaseResult();
        Station station = new Station();
        station.setId(request.getId());
        station.setName(request.getName());
        station.setLng(request.getLng());
        station.setLat(request.getLat());
        station.setAnnotation(request.getAnnotation());
        station.setPrice(request.getPrice());

        if(_stationService.updateStation(station)){
            result.setResult("success");
            result.setContent("修改成功!");
        }else {
            result.setResult("failure");
            result.setContent("修改失败!");
        }
        return result;
    }

}
