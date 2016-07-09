package net.bus.web.service;

import net.bus.web.model.UserTicket;

import java.util.Date;
import java.util.List;

/**
 * Created by Edifi_000 on 2016-07-07.
 */
public interface IUserTicketService {

    List<UserTicket> getUncheckedTickets(long user_id,int page);

    List<UserTicket> getCheckedTickets(long user_id,int page);

    List<UserTicket> getDoneTickets(long user_id,int page);

    UserTicket getDetail(long id);

    Date checkTicket(long id);

    UserTicket getTicketByLineId(long line_id);

    UserTicket buyTicket(UserTicket ticket);
}
