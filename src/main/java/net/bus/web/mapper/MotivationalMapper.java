package net.bus.web.mapper;

import net.bus.web.model.MotivationPovo;
import net.bus.web.model.Motivational;
import net.bus.web.model.MotivationalExample;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;
import java.util.Map;

public interface MotivationalMapper {
    int countByExample(MotivationalExample example);

    int deleteByExample(MotivationalExample example);

    int deleteByPrimaryKey(String id);

    int insert(Motivational record);

    int insertSelective(Motivational record);

    List<Motivational> selectByExampleWithRowbounds(MotivationalExample example, RowBounds rowBounds);

    List<Motivational> selectByExample(MotivationalExample example);

    Motivational selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Motivational record, @Param("example") MotivationalExample example);

    int updateByExample(@Param("record") Motivational record, @Param("example") MotivationalExample example);

    int updateByPrimaryKeySelective(Motivational record);

    int updateByPrimaryKey(Motivational record);
    
//    查询励志奖学金
    List<MotivationPovo> selectMotivation(Map map);
}