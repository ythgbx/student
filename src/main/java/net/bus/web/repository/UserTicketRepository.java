package net.bus.web.repository;

import net.bus.web.mapper.UserTicketMapper;
import net.bus.web.model.UserTicket;
import net.bus.web.model.UserTicketExample;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * Created by Edifi_000 on 2016-07-04.
 */
@Repository
public class UserTicketRepository {

    @Autowired
    private UserTicketMapper _mapper;

    public List<UserTicket> getListByActiveTime(Long user_id,int page) {
        UserTicketExample example = new UserTicketExample();
        UserTicketExample.Criteria criteriaActiveTime = example.createCriteria();
        criteriaActiveTime.andActiveTimeIsNull();
        UserTicketExample.Criteria criteriaUser = example.createCriteria();
        criteriaUser.andUserIdEqualTo(user_id);
        return _mapper.selectByExampleWithRowbounds(example, new RowBounds(1, 2)); //分页
    }

    public List<UserTicket> getListByActiveTimeBeforeDate(Long user_id,Date active_time,int page) {
        UserTicketExample example = new UserTicketExample();
        UserTicketExample.Criteria criteriaActiveTime = example.createCriteria();
        criteriaActiveTime.andActiveTimeGreaterThanOrEqualTo(active_time);
        UserTicketExample.Criteria criteriaUser = example.createCriteria();
        criteriaUser.andUserIdEqualTo(user_id);
        return _mapper.selectByExampleWithRowbounds(example, new RowBounds(1, 2)); //分页
    }

    public List<UserTicket> getListByActiveTimeAfterDate(Long user_id,Date active_time,int page) {
        UserTicketExample example = new UserTicketExample();
        UserTicketExample.Criteria criteriaActiveTime = example.createCriteria();
        criteriaActiveTime.andActiveTimeLessThan(active_time);
        UserTicketExample.Criteria criteriaUser = example.createCriteria();
        criteriaUser.andUserIdEqualTo(user_id);
        return _mapper.selectByExampleWithRowbounds(example, new RowBounds(1, 2)); //分页
    }

    public UserTicket getItem(Long id) {
        return _mapper.selectByPrimaryKey(id);
    }
}
