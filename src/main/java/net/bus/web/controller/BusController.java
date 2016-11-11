package net.bus.web.controller;

import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import net.bus.web.aspect.Auth;
import net.bus.web.controller.dto.*;
import net.bus.web.model.Bus;
import net.bus.web.model.Pojo.PagePojo;
import net.bus.web.service.IBusService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by Edifi_000 on 2016-08-28.
 */
@Controller
@RequestMapping("/bus")
public class BusController {

    @Autowired
    private IBusService _busService;

    private Logger logger = Logger.getLogger(this.getClass().getName());

    @Auth(role = Auth.Role.NONE)
    @ResponseBody
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ApiOperation(value = "车辆添加", httpMethod = "POST", response = BaseResult.class, notes = "车辆添加")
    public IResult add(@ApiParam(required = true, name = "request", value = "车辆请求")@RequestBody BusRequest request)
    {
        logger.info("bus add");
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

        logger.info("bus bing");
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
        logger.info("bus getBusId");
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

    @Auth(role = Auth.Role.NONE)
    @ResponseBody
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ApiOperation(value = "获取车辆信息", httpMethod = "GET", response = LineDetail.class, notes = "获取车辆信息")
    public ModelAndView list(@ApiParam(required = true, name = "page", value = "页")@RequestParam(value = "page", required = true, defaultValue = "0")int page,
                             @ApiParam(required = true, name = "limit", value = "数量")@RequestParam(value = "limit", required = true, defaultValue = "10")int limit,
                             HttpServletRequest request, Model model)
    {
        logger.info("get BusListAll");
        ModelAndView mv = new ModelAndView();
        HttpSession session = request.getSession();
        PagePojo pagePojo = new PagePojo(_busService.getAllCount(),limit,page);
        List<Bus> busList = _busService.getAllBus();
        if(busList!=null){
            model.addAttribute("success","获取成功!");
            session.setAttribute("busList",busList);
            session.setAttribute("pagePojo",pagePojo);
            mv.setViewName("bus_list");
        }else{
            model.addAttribute("error","获取失败!");
        }
        return mv;
    }
}
