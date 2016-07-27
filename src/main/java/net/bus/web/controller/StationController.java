package net.bus.web.controller;

import net.bus.web.aspect.Auth;
import net.bus.web.controller.dto.*;
import net.bus.web.model.Station;
import net.bus.web.service.IStationService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
    public IResult all(int page,int limit)
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
    public IResult add(@RequestBody StationRequest request)
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
            }else{
                result.setResult("failed");
            }
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
