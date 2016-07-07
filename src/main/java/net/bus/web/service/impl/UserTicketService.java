package net.bus.web.service.impl;

import net.bus.web.model.UserTicket;
import net.bus.web.repository.UserTicketRepository;
import net.bus.web.service.IUserTicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by Edifi_000 on 2016-07-04.
 */
@Service
public class UserTicketService implements IUserTicketService {

    @Autowired
    private UserTicketRepository _rootRepository;

    public List<UserTicket> getUncheckedTickets(Long user_id,int page)
    {
        return _rootRepository.getListByActiveTime(user_id,page);
    }

    public List<UserTicket> getCheckedTickets(long user_id,int page)
    {
        Calendar checkRange = Calendar.getInstance();
        checkRange.setTime(new Date());
        checkRange.add(Calendar.MINUTE, -15);
        return _rootRepository.getListByActiveTimeAfterDate(user_id, checkRange.getTime(), page);
    }

    public List<UserTicket> getDoneTickets(long user_id,int page)
    {
        Calendar doneRange = Calendar.getInstance();
        doneRange.setTime(new Date());
        doneRange.add(Calendar.MINUTE, -15);
        return _rootRepository.getListByActiveTimeBeforeDate(user_id, doneRange.getTime(), page);
    }

    public UserTicket getDetail(long id)
    {
        return _rootRepository.getItem(id);
    }

    public Date checkTicket(long id)
    {
        UserTicket ticket = _rootRepository.getItem(id);
        ticket.setActiveTime(new Date());
        _rootRepository.updateItem(ticket);
        return ticket.getActiveTime();
    }

    public UserTicket getTicketByLineId(long line_id)
    {
        //TODO Get ticket info for buy by line info
        return  null;
    }

    public UserTicket buyTicket(UserTicket ticket)
    {
        //TODO Buy ticket
        return  null;
    }
}
