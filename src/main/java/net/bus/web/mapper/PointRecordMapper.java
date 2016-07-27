package net.bus.web.mapper;

import java.util.List;
import net.bus.web.model.PointRecord;
import net.bus.web.model.PointRecordExample;
import net.bus.web.model.PointRecordKey;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface PointRecordMapper {
    int countByExample(PointRecordExample example);

    int deleteByExample(PointRecordExample example);

    int deleteByPrimaryKey(PointRecordKey key);

    int insert(PointRecord record);

    int insertSelective(PointRecord record);

    List<PointRecord> selectByExampleWithRowbounds(PointRecordExample example, RowBounds rowBounds);

    List<PointRecord> selectByExample(PointRecordExample example);

    PointRecord selectByPrimaryKey(PointRecordKey key);

    int updateByExampleSelective(@Param("record") PointRecord record, @Param("example") PointRecordExample example);

    int updateByExample(@Param("record") PointRecord record, @Param("example") PointRecordExample example);

    int updateByPrimaryKeySelective(PointRecord record);

    int updateByPrimaryKey(PointRecord record);
}