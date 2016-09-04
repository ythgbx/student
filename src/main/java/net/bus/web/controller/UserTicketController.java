package net.bus.web.controller;

import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import net.bus.web.aspect.Auth;
import net.bus.web.context.MockDataContext;
import net.bus.web.context.SessionContext;
import net.bus.web.controller.dto.*;
import net.bus.web.model.Line;
import net.bus.web.model.User;
import net.bus.web.model.UserTicket;
import net.bus.web.service.IUserService;
import net.bus.web.service.IUserTicketService;
import net.bus.web.service.ILineService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Edifi_000 on 2016-07-05.
 */

@Controller
@RequestMapping("/ticket")
public class UserTicketController {

    @Autowired
    private IUserTicketService _userTicketService;
    @Autowired
    private ILineService _lineService;
    @Autowired
    private IUserService _userService;
    @Autowired
    private HttpSession session;

    private Logger logger = Logger.getLogger(this.getClass().getName());

    @Auth(role = Auth.Role.USER)
    @ResponseBody
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ApiOperation(value = "获取当前用户车票", httpMethod = "GET", response = TicketList.class, notes = "获取用户车票")
    public IResult list(@ApiParam(required = true, name = "page", value = "页")@RequestParam(value = "page", required = true, defaultValue = "1")int page,
                        @ApiParam(required = true, name = "limit", value = "数量")@RequestParam(value = "limit", required = true, defaultValue = "5")int limit)
    {
        logger.info("ticket done list query");
        User currentUser = (User)session.getAttribute(SessionContext.CURRENT_USER);
        List<UserTicket> ticketList = _userTicketService.getTickets(currentUser.getId(), page, limit);
        List<TicketItem> displayList = getDisplayList(ticketList);

        TicketList resultTicketList = new TicketList();
        resultTicketList.setTickets(displayList);
        resultTicketList.setPage(page);
        resultTicketList.setTotal_count(_userTicketService.getTicketsCount(currentUser.getId()));
        return resultTicketList;

        //Mock data for test
        //return MockDataContext.getInstance().getTicketItemList();
    }

    @Auth(role = Auth.Role.NONE)
    @ResponseBody
    @RequestMapping(value = "/detail", method = RequestMethod.GET)
    @ApiOperation(value = "获取车票详细", httpMethod = "GET", response = TicketList.class, notes = "获取车票详细")
    public IResult detail(@ApiParam(required = true, name = "id", value = "id")@RequestParam(value = "id", required = true)Long id)
    {
        logger.info("ticket detail query");
        UserTicket userTicket =_userTicketService.getDetail(id);
        Line userLine = _lineService.getLineDetails(userTicket.getLineId());
        TicketDetail ticketDetail = new TicketDetail();
        ticketDetail.setId(userTicket.getId());
        ticketDetail.setStart_station(userLine.getStart());
        ticketDetail.setEnd_station(userLine.getEnd());
        ticketDetail.setPrice(userTicket.getPrice());
        ticketDetail.setTime(userTicket.getTime());
        return ticketDetail;

        //Mock data for test
        //return MockDataContext.getInstance().getTicketDetail();
    }


    @Auth(role = Auth.Role.NONE)
    @ResponseBody
    @RequestMapping(value = "/buy", method = RequestMethod.POST)
    @ApiOperation(value = "购票", httpMethod = "POST", response = BaseResult.class, notes = "购票")
    public IResult buy(@ApiParam(required = true, name = "request", value = "购票请求")@RequestBody TicketBuy request)
    {
        logger.info("ticket buy");
        BaseResult result = new BaseResult();
        try {
            if(_userTicketService.buyTickets(request.getDevice(), request.getTicket_buy_items())){
                result.setResult("success");
            }else {
                result.setResult("failure");
            }
        }catch (Exception ex){
            result.setResult("error");
            result.setError(ex.getMessage());
        }
        return result;
    }

    private List<TicketItem> getDisplayList(List<UserTicket> ticketList)
    {
        //TODO 处理获取line信息,现在为每次取存在性能问题
        if(ticketList==null)
            return null;

        List<TicketItem> displayList = new ArrayList<TicketItem>();
        for (UserTicket ticket : ticketList) {
            TicketItem disItem = new TicketItem();
            Line line = _lineService.getLineDetails(ticket.getLineId());//TempCode 性能问题
            disItem.setId(ticket.getId());
            disItem.setHead("head/1.png");//TempCode 暂无该内容
            disItem.setStart_station(line.getStart());
            disItem.setEnd_station(line.getEnd());
            disItem.setBus_img("car/1.png");//TempCode 暂无该内容
            disItem.setTime(ticket.getTime().getTime());
            displayList.add(disItem);
        }
        return displayList;
    }
}
