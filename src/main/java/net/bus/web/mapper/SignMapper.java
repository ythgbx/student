package net.bus.web.mapper;

import java.util.List;

import net.bus.web.model.Pojo.SignRecordPojo;
import net.bus.web.model.Sign;
import net.bus.web.model.SignExample;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface SignMapper {
    int countByExample(SignExample example);

    int deleteByExample(SignExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Sign record);

    int insertSelective(Sign record);

    List<Sign> selectByExampleWithRowbounds(SignExample example, RowBounds rowBounds);

    List<Sign> selectByExample(SignExample example);

    Sign selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Sign record, @Param("example") SignExample example);

    int updateByExample(@Param("record") Sign record, @Param("example") SignExample example);

    int updateByPrimaryKeySelective(Sign record);

    int updateByPrimaryKey(Sign record);
    /*2016年10月19日13:56:15 author: sakura*/
    List<SignRecordPojo> selectSignRecordByUserId(long userId, RowBounds rowBounds);

    List<SignRecordPojo> selectSignRecordByUserId(long userId);
}