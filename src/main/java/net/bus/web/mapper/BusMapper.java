package net.bus.web.mapper;

import java.util.List;
import net.bus.web.model.Bus;
import net.bus.web.model.BusExample;
import org.apache.ibatis.annotations.Param;

public interface BusMapper {
    int countByExample(BusExample example);

    int deleteByExample(BusExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Bus record);

    int insertSelective(Bus record);

    List<Bus> selectByExample(BusExample example);

    Bus selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Bus record, @Param("example") BusExample example);

    int updateByExample(@Param("record") Bus record, @Param("example") BusExample example);

    int updateByPrimaryKeySelective(Bus record);

    int updateByPrimaryKey(Bus record);
}