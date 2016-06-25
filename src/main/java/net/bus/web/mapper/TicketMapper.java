package net.bus.web.mapper;

import java.util.List;
import net.bus.web.model.Ticket;
import net.bus.web.model.TicketExample;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface TicketMapper {
    int countByExample(TicketExample example);

    int deleteByExample(TicketExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Ticket record);

    int insertSelective(Ticket record);

    List<Ticket> selectByExampleWithRowbounds(TicketExample example, RowBounds rowBounds);

    List<Ticket> selectByExample(TicketExample example);

    Ticket selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Ticket record, @Param("example") TicketExample example);

    int updateByExample(@Param("record") Ticket record, @Param("example") TicketExample example);

    int updateByPrimaryKeySelective(Ticket record);

    int updateByPrimaryKey(Ticket record);
}