package net.bus.web.mapper;

import java.util.List;
import net.bus.web.model.UserLine;
import net.bus.web.model.UserLineExample;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface UserLineMapper {
    int countByExample(UserLineExample example);

    int deleteByExample(UserLineExample example);

    int deleteByPrimaryKey(Long id);

    int insert(UserLine record);

    int insertSelective(UserLine record);

    List<UserLine> selectByExampleWithRowbounds(UserLineExample example, RowBounds rowBounds);

    List<UserLine> selectByExample(UserLineExample example);

    UserLine selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") UserLine record, @Param("example") UserLineExample example);

    int updateByExample(@Param("record") UserLine record, @Param("example") UserLineExample example);

    int updateByPrimaryKeySelective(UserLine record);

    int updateByPrimaryKey(UserLine record);
}