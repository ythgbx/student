package net.bus.web.mapper;

import java.util.List;
import net.bus.web.model.UserTicket;
import net.bus.web.model.UserTicketExample;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface UserTicketMapper {
    int countByExample(UserTicketExample example);

    int deleteByExample(UserTicketExample example);

    int deleteByPrimaryKey(Long id);

    int insert(UserTicket record);

    int insertSelective(UserTicket record);

    List<UserTicket> selectByExampleWithRowbounds(UserTicketExample example, RowBounds rowBounds);

    List<UserTicket> selectByExample(UserTicketExample example);

    UserTicket selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") UserTicket record, @Param("example") UserTicketExample example);

    int updateByExample(@Param("record") UserTicket record, @Param("example") UserTicketExample example);

    int updateByPrimaryKeySelective(UserTicket record);

    int updateByPrimaryKey(UserTicket record);
}