package net.bus.web.mapper;

import java.util.List;
import net.bus.web.model.Station;
import net.bus.web.model.StationExample;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface StationMapper {
    int countByExample(StationExample example);

    int deleteByExample(StationExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Station record);

    int insertSelective(Station record);

    List<Station> selectByExampleWithRowbounds(StationExample example, RowBounds rowBounds);

    List<Station> selectByExample(StationExample example);

    Station selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Station record, @Param("example") StationExample example);

    int updateByExample(@Param("record") Station record, @Param("example") StationExample example);

    int updateByPrimaryKeySelective(Station record);

    int updateByPrimaryKey(Station record);
}