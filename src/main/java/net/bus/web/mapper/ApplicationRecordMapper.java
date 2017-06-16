package net.bus.web.mapper;

import java.util.List;
import net.bus.web.model.ApplicationRecord;
import net.bus.web.model.ApplicationRecordExample;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface ApplicationRecordMapper {
    int countByExample(ApplicationRecordExample example);

    int deleteByExample(ApplicationRecordExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ApplicationRecord record);

    int insertSelective(ApplicationRecord record);

    List<ApplicationRecord> selectByExampleWithRowbounds(ApplicationRecordExample example, RowBounds rowBounds);

    List<ApplicationRecord> selectByExample(ApplicationRecordExample example);

    ApplicationRecord selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ApplicationRecord record, @Param("example") ApplicationRecordExample example);

    int updateByExample(@Param("record") ApplicationRecord record, @Param("example") ApplicationRecordExample example);

    int updateByPrimaryKeySelective(ApplicationRecord record);

    int updateByPrimaryKey(ApplicationRecord record);
}