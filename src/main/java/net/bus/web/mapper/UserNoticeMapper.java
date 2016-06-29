package net.bus.web.mapper;

import java.util.List;
import net.bus.web.model.UserNotice;
import net.bus.web.model.UserNoticeExample;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface UserNoticeMapper {
    int countByExample(UserNoticeExample example);

    int deleteByExample(UserNoticeExample example);

    int deleteByPrimaryKey(Long id);

    int insert(UserNotice record);

    int insertSelective(UserNotice record);

    List<UserNotice> selectByExampleWithRowbounds(UserNoticeExample example, RowBounds rowBounds);

    List<UserNotice> selectByExample(UserNoticeExample example);

    UserNotice selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") UserNotice record, @Param("example") UserNoticeExample example);

    int updateByExample(@Param("record") UserNotice record, @Param("example") UserNoticeExample example);

    int updateByPrimaryKeySelective(UserNotice record);

    int updateByPrimaryKey(UserNotice record);
}