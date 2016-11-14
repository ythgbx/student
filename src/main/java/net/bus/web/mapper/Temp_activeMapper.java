package net.bus.web.mapper;

import java.util.List;
import net.bus.web.model.Temp_active;
import net.bus.web.model.Temp_activeExample;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface Temp_activeMapper {
    int countByExample(Temp_activeExample example);

    int deleteByExample(Temp_activeExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Temp_active record);

    int insertSelective(Temp_active record);

    List<Temp_active> selectByExampleWithRowbounds(Temp_activeExample example, RowBounds rowBounds);

    List<Temp_active> selectByExample(Temp_activeExample example);

    Temp_active selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Temp_active record, @Param("example") Temp_activeExample example);

    int updateByExample(@Param("record") Temp_active record, @Param("example") Temp_activeExample example);

    int updateByPrimaryKeySelective(Temp_active record);

    int updateByPrimaryKey(Temp_active record);
}