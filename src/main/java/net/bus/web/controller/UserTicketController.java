package net.bus.web.controller;

import net.bus.web.aspect.Auth;
import net.bus.web.context.SessionContext;
import net.bus.web.controller.dto.TicketDetail;
import net.bus.web.controller.dto.TicketItem;
import net.bus.web.model.Line;
import net.bus.web.model.User;
import net.bus.web.model.UserTicket;
import net.bus.web.service.IUserTicketService;
import net.bus.web.service.ILineService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
    private HttpSession session;

    private Logger logger = Logger.getLogger(this.getClass().getName());

    @Auth(role = Auth.Role.USER)
    @ResponseBody
    @RequestMapping(value = "/list/unchecked", method = RequestMethod.GET)
    public List uncheckedList(int page,int limit)
    {
        logger.info("ticket unchecked query");
//        User currentUser = (User)session.getAttribute(SessionContext.CURRENT_USER);
//        List<UserTicket> ticketList = _userTicketService.getUncheckedTickets(currentUser.getId(),page);
//        List<TicketItem> displayList = getDisplayList(ticketList);

        //Mock data for test
        List<TicketItem> displayList = new ArrayList<TicketItem>();
        for (int i=0;i<5;i++)
        {
            TicketItem disItem = new TicketItem();
            disItem.setId(-1l);
            disItem.setHead("head/1.png");
            disItem.setStart_station("民族大道中南民族大学");
            disItem.setEnd_station("中北路地铁楚河汉界站");
            disItem.setBus_img("car/1.png");
            disItem.setTime(new Date().getTime());
            disItem.setActive_time(new Date().getTime());
            displayList.add(disItem);
        }
        return displayList;
    }

    @Auth(role = Auth.Role.USER)
    @ResponseBody
    @RequestMapping(value = "/list/checked", method = RequestMethod.GET)
    public List checkedList(int page,int limit)
    {
        logger.info("ticket check list query");
//        User currentUser = (User)session.getAttribute(SessionContext.CURRENT_USER);
//        List<UserTicket> ticketList = _userTicketService.getCheckedTickets(currentUser.getId(),page);
//        List<TicketItem> displayList = getDisplayList(ticketList);

        //Mock data for test
        List<TicketItem> displayList = new ArrayList<TicketItem>();
        for (int i=0;i<5;i++)
        {
            TicketItem disItem = new TicketItem();
            disItem.setId(-1l);
            disItem.setHead("head/1.png");
            disItem.setStart_station("民族大道中南民族大学");
            disItem.setEnd_station("中北路地铁楚河汉界站");
            disItem.setBus_img("car/2.png");
            disItem.setTime(new Date().getTime());
            disItem.setActive_time(new Date().getTime());
            displayList.add(disItem);
        }
        return displayList;
    }

    @Auth(role = Auth.Role.USER)
    @ResponseBody
    @RequestMapping(value = "/list/done", method = RequestMethod.GET)
    public List doneList(int page,int limit)
    {
        logger.info("ticket done list query");
//        User currentUser = (User)session.getAttribute(SessionContext.CURRENT_USER);
//        List<UserTicket> ticketList = _userTicketService.getCheckedTickets(currentUser.getId(),page);
//        List<TicketItem> displayList = getDisplayList(ticketList);

        //Mock data for test
        List<TicketItem> displayList = new ArrayList<TicketItem>();
        for (int i=0;i<5;i++)
        {
            TicketItem disItem = new TicketItem();
            disItem.setId(-1l);
            disItem.setHead("head/1.png");
            disItem.setStart_station("民族大道中南民族大学");
            disItem.setEnd_station("中北路地铁楚河汉界站");
            disItem.setBus_img("car/3.png");
            disItem.setTime(new Date().getTime());
            disItem.setActive_time(new Date().getTime());
            displayList.add(disItem);
        }
        return displayList;
    }

    @Auth(role = Auth.Role.USER)
    @ResponseBody
    @RequestMapping(value = "/detail", method = RequestMethod.GET)
    public TicketDetail detail(Long id)
    {
        logger.info("ticket detail query");
        //TODO 处理票据明细查询

        //Mock data for test
        TicketDetail detail = new TicketDetail();
        detail.setStart_station("民族大道纺织大学");
        detail.setEnd_station("珞瑜路武汉大学");
        detail.setPrice(4);
        detail.setTime(new Date().getTime());
        return detail;
    }

    @Auth(role = Auth.Role.USER)
    @ResponseBody
    @RequestMapping(value = "/checked", method = RequestMethod.POST)
    public String checked(Long id)
    {
        logger.info("ticket checked");
        //TODO 处理检票操作

        //Mock data for test
        String result = "success";
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
            disItem.setActive_time(ticket.getActiveTime().getTime());
            displayList.add(disItem);
        }
        return displayList;
    }
}
