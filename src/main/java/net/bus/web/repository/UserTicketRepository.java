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

    public List<UserTicket> getList(ISpecification specification)
    {
        return _mapper.selectByExample((UserTicketExample)specification.createExample());
    }

    public List<UserTicket> getList(ISpecification specification,int page,int limit)
    {
        return _mapper.selectByExampleWithRowbounds((UserTicketExample) specification.createExample(), new RowBounds(page*limit, limit)); //分页
    }

    public UserTicket getItem(ISpecification specification)
    {
        List<UserTicket> list= _mapper.selectByExample((UserTicketExample)specification.createExample());
        if(!list.isEmpty())
        {
            return list.get(0);
        }
        return null;
    }

    public int updateItem(UserTicket ticket)
    {
        return  _mapper.updateByPrimaryKey(ticket);
    }

    public int insertItem(UserTicket ticket)
    {
        return  _mapper.insert(ticket);
    }


    public int count(ISpecification specification)
    {
        UserTicketExample example = (UserTicketExample)specification.createExample();
        if(example!=null){
            return _mapper.countByExample(example);
        }
        return 0;
    }
}
