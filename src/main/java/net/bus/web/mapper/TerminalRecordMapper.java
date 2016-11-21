package net.bus.web.mapper;

import java.util.List;
import net.bus.web.model.TerminalRecord;
import net.bus.web.model.TerminalRecordExample;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface TerminalRecordMapper {
    int countByExample(TerminalRecordExample example);

    int deleteByExample(TerminalRecordExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TerminalRecord record);

    int insertSelective(TerminalRecord record);

    List<TerminalRecord> selectByExampleWithRowbounds(TerminalRecordExample example, RowBounds rowBounds);

    List<TerminalRecord> selectByExample(TerminalRecordExample example);

    TerminalRecord selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TerminalRecord record, @Param("example") TerminalRecordExample example);

    int updateByExample(@Param("record") TerminalRecord record, @Param("example") TerminalRecordExample example);

    int updateByPrimaryKeySelective(TerminalRecord record);

    int updateByPrimaryKey(TerminalRecord record);
}