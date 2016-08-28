package net.bus.web.controller;

import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import net.bus.web.aspect.Auth;
import net.bus.web.controller.dto.BaseResult;
import net.bus.web.controller.dto.BusBindRequest;
import net.bus.web.controller.dto.IResult;
import net.bus.web.controller.dto.BusRequest;
import net.bus.web.model.Bus;
import net.bus.web.service.IBusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Edifi_000 on 2016-08-28.
 */
@Controller
@RequestMapping("/bus")
public class BusController {

    @Autowired
    private IBusService _busService;

    @Auth(role = Auth.Role.USER)
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

    @Auth(role = Auth.Role.USER)
    @ResponseBody
    @RequestMapping(value = "/bind", method = RequestMethod.PUT)
    @ApiOperation(value = "车辆信息绑定", httpMethod = "PUT", response = BaseResult.class, notes = "车辆信息绑定")
    public IResult bind(@ApiParam(required = true, name = "request", value = "车辆绑定请求")@RequestBody BusBindRequest request)
    {
        BaseResult result = new BaseResult();
        if(_busService.bindBus(request.getId(),request.getName(),request.getUser_id(),request.getLine_id(),request.getDevice())){
            result.setResult("success");
        }else{
            result.setResult("failed");
        }
        return result;
    }
}
