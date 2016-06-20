package net.bus.web.mapper;

import java.util.List;
import net.bus.web.model.LineStation;
import net.bus.web.model.LineStationExample;
import org.apache.ibatis.annotations.Param;

public interface LineStationMapper {
    int countByExample(LineStationExample example);

    int deleteByExample(LineStationExample example);

    int deleteByPrimaryKey(Long id);

    int insert(LineStation record);

    int insertSelective(LineStation record);

    List<LineStation> selectByExample(LineStationExample example);

    LineStation selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") LineStation record, @Param("example") LineStationExample example);

    int updateByExample(@Param("record") LineStation record, @Param("example") LineStationExample example);

    int updateByPrimaryKeySelective(LineStation record);

    int updateByPrimaryKey(LineStation record);
}