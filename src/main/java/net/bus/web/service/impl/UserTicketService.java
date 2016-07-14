package net.bus.web.service.impl;

import net.bus.web.model.UserTicket;
import net.bus.web.repository.ISpecification;
import net.bus.web.repository.UserTicketRepository;
import net.bus.web.repository.specification.UserTickeActiveTimeUserIdSpecification;
import net.bus.web.repository.specification.UserTicketIdSpecification;
import net.bus.web.repository.specification.UserTicketLineIdSpecification;
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

    public List<UserTicket> getUncheckedTickets(long user_id,int page,int limit)
    {
        ISpecification specification = new UserTickeActiveTimeUserIdSpecification(
                user_id,null, UserTickeActiveTimeUserIdSpecification.ActiveTimeOp.IsNull);
        return _rootRepository.getList(specification,page,limit);
    }

    public List<UserTicket> getCheckedTickets(long user_id,int page,int limit)
    {
        Calendar checkRange = Calendar.getInstance();
        checkRange.setTime(new Date());
        checkRange.add(Calendar.MINUTE, -15);
        ISpecification specification = new UserTickeActiveTimeUserIdSpecification(
                user_id,checkRange.getTime(), UserTickeActiveTimeUserIdSpecification.ActiveTimeOp.After);
        return _rootRepository.getList(specification,page-1,limit);
    }

    public List<UserTicket> getDoneTickets(long user_id,int page,int limit)
    {
        Calendar checkRange = Calendar.getInstance();
        checkRange.setTime(new Date());
        checkRange.add(Calendar.MINUTE, -15);
        ISpecification specification = new UserTickeActiveTimeUserIdSpecification(
                user_id,checkRange.getTime(), UserTickeActiveTimeUserIdSpecification.ActiveTimeOp.Before);
        return _rootRepository.getList(specification,page-1,limit);
    }

    public UserTicket getDetail(long id)
    {
        return _rootRepository.getItem(new UserTicketIdSpecification(id));
    }

    public Date checkTicket(long id)
    {
        UserTicket ticket = _rootRepository.getItem(new UserTicketIdSpecification(id));
        ticket.setActiveTime(new Date());
        _rootRepository.updateItem(ticket);
        return ticket.getActiveTime();
    }

    public UserTicket getTicketByLineId(long line_id)
    {
        UserTicket ticket = _rootRepository.getItem(new UserTicketLineIdSpecification(line_id));
        return  ticket;
    }

    public UserTicket buyTicket(UserTicket ticket)
    {
        //TODO Buy ticket
        return  null;
    }
}
