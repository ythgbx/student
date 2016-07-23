package net.bus.web.service;

import net.bus.web.model.User;
import net.bus.web.model.UserTicket;

import java.util.Date;
import java.util.List;

/**
 * Created by Edifi_000 on 2016-07-07.
 */
public interface IUserTicketService {

    List<UserTicket> getUncheckedTickets(long user_id,int page,int limit);

    List<UserTicket> getCheckedTickets(long user_id,int page,int limit);

    List<UserTicket> getDoneTickets(long user_id,int page,int limit);

    UserTicket getDetail(long id);

    boolean checkTicket(long id);

    UserTicket getTicketByLineId(long line_id);

    boolean buyTicket(long line_id,User user);
}
