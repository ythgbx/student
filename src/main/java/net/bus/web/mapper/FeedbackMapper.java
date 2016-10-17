package net.bus.web.mapper;

import java.util.List;
import net.bus.web.model.Feedback;
import net.bus.web.model.FeedbackExample;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface FeedbackMapper {
    int countByExample(FeedbackExample example);

    int deleteByExample(FeedbackExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Feedback record);

    int insertSelective(Feedback record);

    List<Feedback> selectByExampleWithRowbounds(FeedbackExample example, RowBounds rowBounds);

    List<Feedback> selectByExample(FeedbackExample example);

    Feedback selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Feedback record, @Param("example") FeedbackExample example);

    int updateByExample(@Param("record") Feedback record, @Param("example") FeedbackExample example);

    int updateByPrimaryKeySelective(Feedback record);

    int updateByPrimaryKey(Feedback record);
}