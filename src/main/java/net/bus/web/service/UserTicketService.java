package net.bus.web.service;

import net.bus.web.model.UserTicket;
import net.bus.web.repository.UserTicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by Edifi_000 on 2016-07-04.
 */
@Service
public class UserTicketService {

    @Autowired
    private UserTicketRepository _rootRepository;

    public List<UserTicket> getUncheckedTickets(Long user_id,int page)
    {
        //TODO Select Tickets Unchecked
        return _rootRepository.getListByActiveTime(user_id,page);
    }

    public List<UserTicket> getCheckedTickets(long user_id,int page)
    {
        //TODO Select Tickets Checked
        Calendar checkRange = Calendar.getInstance();
        checkRange.setTime(new Date());
        checkRange.add(Calendar.MINUTE, -15);
        return _rootRepository.getListByActiveTimeAfterDate(user_id, checkRange.getTime(), page);
    }

    public List<UserTicket> getDoneTickets(long user_id,int page)
    {
        //TODO Select Tickets Done
        Calendar doneRange = Calendar.getInstance();
        doneRange.setTime(new Date());
        doneRange.add(Calendar.MINUTE, -15);
        return _rootRepository.getListByActiveTimeBeforeDate(user_id,doneRange.getTime(),page);
    }
}
