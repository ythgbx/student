package net.bus.web.mapper;

import net.bus.web.model.PoorBuild;
import net.bus.web.model.PoorBuildExample;
import net.bus.web.model.PoorPovo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;
import java.util.Map;

public interface PoorBuildMapper {
    int countByExample(PoorBuildExample example);

    int deleteByExample(PoorBuildExample example);

    int deleteByPrimaryKey(String idcard);

    int insert(PoorBuild record);

    int insertSelective(PoorBuild record);

    List<PoorBuild> selectByExampleWithRowbounds(PoorBuildExample example, RowBounds rowBounds);

    List<PoorBuild> selectByExample(PoorBuildExample example);

    PoorBuild selectByPrimaryKey(String idcard);

    int updateByExampleSelective(@Param("record") PoorBuild record, @Param("example") PoorBuildExample example);

    int updateByExample(@Param("record") PoorBuild record, @Param("example") PoorBuildExample example);

    int updateByPrimaryKeySelective(PoorBuild record);

    int updateByPrimaryKey(PoorBuild record);

    List<PoorPovo> getAllPoorinfo(Map map);
}