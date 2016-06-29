package net.bus.web.mapper;

import java.util.List;
import net.bus.web.model.UserLog;
import net.bus.web.model.UserLogExample;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface UserLogMapper {
    int countByExample(UserLogExample example);

    int deleteByExample(UserLogExample example);

    int deleteByPrimaryKey(Long id);

    int insert(UserLog record);

    int insertSelective(UserLog record);

    List<UserLog> selectByExampleWithRowbounds(UserLogExample example, RowBounds rowBounds);

    List<UserLog> selectByExample(UserLogExample example);

    UserLog selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") UserLog record, @Param("example") UserLogExample example);

    int updateByExample(@Param("record") UserLog record, @Param("example") UserLogExample example);

    int updateByPrimaryKeySelective(UserLog record);

    int updateByPrimaryKey(UserLog record);
}