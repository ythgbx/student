package net.bus.web.mapper;

import java.util.List;
import net.bus.web.model.ActivityOrder;
import net.bus.web.model.ActivityOrderExample;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface ActivityOrderMapper {
    int countByExample(ActivityOrderExample example);

    int deleteByExample(ActivityOrderExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ActivityOrder record);

    int insertSelective(ActivityOrder record);

    List<ActivityOrder> selectByExampleWithRowbounds(ActivityOrderExample example, RowBounds rowBounds);

    List<ActivityOrder> selectByExample(ActivityOrderExample example);

    ActivityOrder selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ActivityOrder record, @Param("example") ActivityOrderExample example);

    int updateByExample(@Param("record") ActivityOrder record, @Param("example") ActivityOrderExample example);

    int updateByPrimaryKeySelective(ActivityOrder record);

    int updateByPrimaryKey(ActivityOrder record);
}