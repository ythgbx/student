package net.bus.web.mapper;

import java.util.List;
import java.util.Map;

import net.bus.web.model.Grant;
import net.bus.web.model.GrantExample;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface GrantMapper {
    int countByExample(GrantExample example);

    int deleteByExample(GrantExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Grant record);

    int insertSelective(Grant record);

    List<Grant> selectByExampleWithRowbounds(GrantExample example, RowBounds rowBounds);

    List<Grant> selectByExample(GrantExample example);

    Grant selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Grant record, @Param("example") GrantExample example);

    int updateByExample(@Param("record") Grant record, @Param("example") GrantExample example);

    int updateByPrimaryKeySelective(Grant record);

    int updateByPrimaryKey(Grant record);

    List<Grant> selectGrant(Map map);
}