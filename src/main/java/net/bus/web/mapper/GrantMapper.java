package net.bus.web.mapper;

import net.bus.web.model.DataStatistics;
import net.bus.web.model.Grant;
import net.bus.web.model.GrantExample;
import net.bus.web.model.GrantPovo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;
import java.util.Map;

public interface GrantMapper {
    int countByExample(GrantExample example);

    int deleteByExample(GrantExample example);

    int deleteByPrimaryKey(Long no);

    int insert(Grant record);

    int insertSelective(Grant record);

    List<Grant> selectByExampleWithRowbounds(GrantExample example, RowBounds rowBounds);

    List<Grant> selectByExample(GrantExample example);

    Grant selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Grant record, @Param("example") GrantExample example);

    int updateByExample(@Param("record") Grant record, @Param("example") GrantExample example);

    int updateByPrimaryKeySelective(Grant record);

    int updateByPrimaryKey(Grant record);

//    查询贫困建档信息
    List<GrantPovo> selectGrant(Map map);

    List<DataStatistics> getNumPoor(Integer year);

}