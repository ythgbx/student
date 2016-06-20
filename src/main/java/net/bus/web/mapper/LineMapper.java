package net.bus.web.mapper;

import java.util.List;
import net.bus.web.model.Line;
import net.bus.web.model.LineExample;
import org.apache.ibatis.annotations.Param;

public interface LineMapper {
    int countByExample(LineExample example);

    int deleteByExample(LineExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Line record);

    int insertSelective(Line record);

    List<Line> selectByExample(LineExample example);

    Line selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Line record, @Param("example") LineExample example);

    int updateByExample(@Param("record") Line record, @Param("example") LineExample example);

    int updateByPrimaryKeySelective(Line record);

    int updateByPrimaryKey(Line record);
}