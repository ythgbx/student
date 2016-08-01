package net.bus.web.controller;

import net.bus.web.aspect.Auth;
import net.bus.web.context.Position;
import net.bus.web.controller.dto.*;
import net.bus.web.model.Bus;
import net.bus.web.model.Station;
import net.bus.web.service.ILocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sky on 16/7/30.
 */
@Controller
@RequestMapping("/location")
public class LocationController {

    @Autowired
    private ILocationService _locationService;

    @Auth(role = Auth.Role.NONE)
    @ResponseBody
    @RequestMapping(value = "/around/stations", method = RequestMethod.GET)
    public IResult aroundStations(double lat,double lng,@RequestParam(value = "degree", required = false, defaultValue = "8")int degree)
    {
        StationList result = new StationList();
        List<StationItem> stationItems = new ArrayList<StationItem>();
        List<Station> stations = _locationService.getAroundStation(new Position(lat,lng),degree);
        for(Station station:stations){
            StationItem item = new StationItem();
            item.setId(station.getId());
            item.setName(station.getName());
            item.setAnnotation(station.getAnnotation());
            item.setPos(new net.bus.web.controller.dto.Position(station.getLat(),station.getLng()));
            stationItems.add(item);
        }

        result.setStations(stationItems);

        return result;
    }

    @Auth(role = Auth.Role.NONE)
    @ResponseBody
    @RequestMapping(value = "/around/buses", method = RequestMethod.GET)
    public IResult aroundBuses(double lat,double lng,@RequestParam(value = "degree", required = false, defaultValue = "8")int degree)
    {
        BusList result = new BusList();
        List<BusItem> busItems = new ArrayList<BusItem>();
        List<Bus> buses = _locationService.getAroundBuses(new Position(lat,lng),degree);
        for(Bus bus:buses){
            BusItem item = new BusItem();
            item.setId(bus.getId());
            item.setName(bus.getName());
            item.setPos(new net.bus.web.controller.dto.Position(bus.getLat(),bus.getLng()));
            item.setAngle(0.0d);//TODO 计算车辆获取角度
        }
        result.setBuses(busItems);
        return result;
    }
}
