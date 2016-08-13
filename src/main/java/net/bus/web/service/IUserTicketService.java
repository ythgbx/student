package net.bus.web.service;

import net.bus.web.model.User;
import net.bus.web.model.UserTicket;

import java.util.Date;
import java.util.List;

/**
 * Created by Edifi_000 on 2016-07-07.
 */
public interface IUserTicketService {

    List<UserTicket> getTickets(long user_id,int page,int limit);

    UserTicket getDetail(long id);

    UserTicket getTicketByLineId(long line_id);

    boolean buyTicket(long line_id,User user);

    int getTicketsCount(long user_id);
}
