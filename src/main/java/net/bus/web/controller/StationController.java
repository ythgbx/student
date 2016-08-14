package net.bus.web.controller;

import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import net.bus.web.aspect.Auth;
import net.bus.web.context.StationsLocationContext;
import net.bus.web.controller.dto.*;
import net.bus.web.model.Station;
import net.bus.web.service.IStationService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

    @Auth(role = Auth.Role.USER)
    @ResponseBody
    @RequestMapping(value = "/list/all", method = RequestMethod.GET)
    @ApiOperation(value = "获取全部站点", httpMethod = "GET", response = StationList.class, notes = "获取全部站点")
    public IResult all(@ApiParam(required = true, name = "page", value = "页")@RequestParam(value = "page", required = true, defaultValue = "1")int page,
                       @ApiParam(required = true, name = "limit", value = "数量")@RequestParam(value = "limit", required = true, defaultValue = "5")int limit)
    {
        logger.info("line all query");
        StationList stationList = new StationList();
        List<Station> lines = _stationService.getAllStations(page, limit);
        stationList.setStations(getDisplayList(lines));
        stationList.setPage(page);
        stationList.setTotal_count(_stationService.getAllStationsCount());
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
            station.setLat(request.getPos().getLat());
            station.setLng(request.getPos().getLng());
            station.setAnnotation(request.getAnnotation());
            if(_stationService.addStation(station)){
                result.setResult("success");
                result.setContent(station.getId());
            }else{
                result.setResult("failed");
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
            displayList.add(stationItem);
        }
        return displayList;
    }
}
