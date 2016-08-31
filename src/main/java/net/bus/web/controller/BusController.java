package net.bus.web.controller;

import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import net.bus.web.aspect.Auth;
import net.bus.web.controller.dto.*;
import net.bus.web.model.Bus;
import net.bus.web.service.IBusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Edifi_000 on 2016-08-28.
 */
@Controller
@RequestMapping("/bus")
public class BusController {

    @Autowired
    private IBusService _busService;

    @Auth(role = Auth.Role.NONE)
    @ResponseBody
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ApiOperation(value = "车辆添加", httpMethod = "POST", response = BaseResult.class, notes = "车辆添加")
    public IResult add(@ApiParam(required = true, name = "request", value = "车辆请求")@RequestBody BusRequest request)
    {
        BaseResult result = new BaseResult();
        Bus bus = new Bus();
        bus.setName(request.getName());
        bus.setDevice(request.getDevice() == null ? "" : request.getDevice());
        bus.setLineId(request.getLine_id() == null ? -1 : request.getLine_id());
        bus.setUserId(request.getUser_id() == null ? -1 : request.getUser_id());
        bus.setLng(-1d);
        bus.setLat(-1d);
        if(_busService.addBus(bus)){
            result.setResult("success");
        }else{
            result.setResult("failed");
        }
        return result;
    }

    @Auth(role = Auth.Role.NONE)
    @ResponseBody
    @RequestMapping(value = "/bind", method = RequestMethod.PUT)
    @ApiOperation(value = "车辆信息绑定", httpMethod = "PUT", response = BaseResult.class, notes = "车辆信息绑定")
    public IResult bind(@ApiParam(required = true, name = "request", value = "车辆绑定请求")@RequestBody BusBindRequest request)
    {
        BaseResult result = new BaseResult();
        if(_busService.bindBus(request.getId(), request.getName(), request.getUser_id(), request.getLine_id(), request.getDevice())){
            result.setResult("success");
        }else{
            result.setResult("failed");
        }
        return result;
    }

    @Auth(role = Auth.Role.NONE)
    @ResponseBody
    @RequestMapping(value = "/id", method = RequestMethod.GET)
    @ApiOperation(value = "获取车辆id", httpMethod = "GET", response = LineDetail.class, notes = "获取车辆id")
    public IResult id(@ApiParam(required = false, name = "name", value = "车牌")@RequestParam(value = "name", required = false)String name,
                      @ApiParam(required = false, name = "device", value = "设备标识")@RequestParam(value = "device", required = false)String device)
    {
        BaseResult result = new BaseResult();
        Bus bus = _busService.getBus(name,device);
        if(bus!=null){
            result.setResult("success");
            result.setContent(bus.getId());
        }else{
            result.setResult("failed");
        }
        return result;
    }
}
