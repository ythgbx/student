package net.bus.web.controller;

import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import net.bus.web.aspect.Auth;
import net.bus.web.common.BaiduMap;
import net.bus.web.context.Position;
import net.bus.web.controller.dto.*;
import net.bus.web.model.Bus;
import net.bus.web.model.Station;
import net.bus.web.service.ILocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by sky on 16/7/30.
 */
@Controller
@RequestMapping("/location")
public class LocationController {

    @Autowired
    private ILocationService _locationService;

    @Value("#{sysProperties['baidukey']}")
    public String BAIDU_KEY;

    @Auth(role = Auth.Role.NONE)
    @ResponseBody
    @RequestMapping(value = "/around/stations", method = RequestMethod.GET)
    @ApiOperation(value = "附近站点", httpMethod = "GET", response = StationList.class, notes = "附近站点")
    public IResult aroundStations(@ApiParam(required = false, name = "lat", value = "纬度")@RequestParam(value = "lat", required = false, defaultValue = "0") double lat,
                                  @ApiParam(required = false, name = "lng", value = "经度")@RequestParam(value = "lng", required = false, defaultValue = "0")double lng,
                                  @ApiParam(required = false, name = "degree", value = "范围")@RequestParam(value = "degree", required = false, defaultValue = "8")int degree)
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
            item.setPrice(station.getPrice());
            stationItems.add(item);
        }

        result.setStations(stationItems);

        return result;
    }

    @Auth(role = Auth.Role.NONE)
    @ResponseBody
    @RequestMapping(value = "/around/buses", method = RequestMethod.GET)
    @ApiOperation(value = "附近车辆", httpMethod = "GET", response = StationList.class, notes = "附近车辆")
    public IResult aroundBuses(@ApiParam(required = false, name = "lat", value = "纬度")@RequestParam(value = "lat", required = false, defaultValue = "0") double lat,
                               @ApiParam(required = false, name = "lng", value = "经度")@RequestParam(value = "lng", required = false, defaultValue = "0")double lng,
                               @ApiParam(required = false, name = "degree", value = "范围")@RequestParam(value = "degree", required = false, defaultValue = "8")int degree)
    {
        BusList result = new BusList();
        List<BusItem> busItems = new ArrayList<BusItem>();
        List<Bus> buses = _locationService.getAroundBuses(new Position(lat, lng), degree);
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

    @Auth(role = Auth.Role.NONE)
    @ResponseBody
    @RequestMapping(value = "/city", method = RequestMethod.GET)
    @ApiOperation(value = "所在城市", httpMethod = "GET", response = StationList.class, notes = "所在城市")
    public IResult city(@ApiParam(required = false, name = "lat", value = "纬度")@RequestParam(value = "lat", required = false, defaultValue = "0") double lat,
                               @ApiParam(required = false, name = "lng", value = "经度")@RequestParam(value = "lng", required = false, defaultValue = "0")double lng)
    {
        LocationCity result = new LocationCity();
        if(lat==0||lng==0){
            result.setResult("error");
            result.setContent(new IllegalArgumentException("lat or lng").getMessage());
            return result;
        }

        Map<String,String> cityInfo = BaiduMap.getCityInfo(lat, lng,BAIDU_KEY);
        if(result!=null){
            result.setResult("success");
            result.setProvince(cityInfo.get("province"));
            result.setCity(cityInfo.get("city"));
        }else{
            result.setResult("failed");
        }
        return result;
    }
}
