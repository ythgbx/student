package net.bus.web.controller;

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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
    public IResult list(int page,int limit)
    {
        logger.info("ticket done list query");
        User currentUser = (User)session.getAttribute(SessionContext.CURRENT_USER);
        List<UserTicket> ticketList = _userTicketService.getTickets(currentUser.getId(), page, limit);
        List<TicketItem> displayList = getDisplayList(ticketList);

        TicketList resultTicketList = new TicketList();
        resultTicketList.setTickets(displayList);
        resultTicketList.setPage(page);
        return resultTicketList;

        //Mock data for test
        //return MockDataContext.getInstance().getTicketItemList();
    }

    @Auth(role = Auth.Role.NONE)
    @ResponseBody
    @RequestMapping(value = "/detail", method = RequestMethod.GET)
    public IResult detail(Long id)
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


    @Auth(role = Auth.Role.BUS)
    @ResponseBody
    @RequestMapping(value = "/buy", method = RequestMethod.POST)
    public IResult buy(@RequestBody TicketBuy request)
    {
        logger.info("ticket buy");
        BaseResult result = new BaseResult();
        try {
            User user = _userService.getUser(request.getUser_id());
            if(_userTicketService.buyTicket(request.getLine_id(), user)){
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
