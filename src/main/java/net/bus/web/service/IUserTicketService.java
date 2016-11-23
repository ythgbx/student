package net.bus.web.service;

import net.bus.web.controller.dto.TicketBuyItem;
import net.bus.web.model.User;
import net.bus.web.model.UserTicket;

import java.util.List;

/**
 * Created by Edifi_000 on 2016-07-07.
 */
public interface IUserTicketService {

    List<UserTicket> getTickets(long user_id,int page,int limit);

    UserTicket getDetail(long id);

    UserTicket getTicketByLineId(long line_id);

    boolean buyTicket(long line_id,User user);

    boolean buyTicket(long line_id,long user_id);

    boolean buyTicket(long line_id,long user_id,long start_station_id,long end_station_id);

    boolean buyTickets(String device,List<TicketBuyItem> userTickets) throws Exception;

    int getTicketsCount(long user_id);
}
