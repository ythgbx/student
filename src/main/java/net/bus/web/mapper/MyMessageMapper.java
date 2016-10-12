package net.bus.web.mapper;

import java.util.List;
import net.bus.web.model.MyMessage;
import net.bus.web.model.MyMessageExample;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface MyMessageMapper {
    int countByExample(MyMessageExample example);

    int deleteByExample(MyMessageExample example);

    int deleteByPrimaryKey(Long id);

    int insert(MyMessage record);

    int insertSelective(MyMessage record);

    List<MyMessage> selectByExampleWithRowbounds(MyMessageExample example, RowBounds rowBounds);

    List<MyMessage> selectByExample(MyMessageExample example);

    MyMessage selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") MyMessage record, @Param("example") MyMessageExample example);

    int updateByExample(@Param("record") MyMessage record, @Param("example") MyMessageExample example);

    int updateByPrimaryKeySelective(MyMessage record);

    int updateByPrimaryKey(MyMessage record);
}