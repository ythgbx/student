package net.bus.web.mapper;

import net.bus.web.model.DataStatistics;
import net.bus.web.model.PoorBuild;
import net.bus.web.model.PoorBuildExample;
import net.bus.web.model.PoorPovo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;
import java.util.Map;

public interface PoorBuildMapper {
    int countByExample(Map map);

    int deleteByExample(PoorBuildExample example);

    int deleteByPrimaryKey(Long id);

    int insert(PoorBuild record);

    int insertSelective(PoorBuild record);

    List<PoorBuild> selectByExampleWithRowbounds(PoorBuildExample example, RowBounds rowBounds);

    List<PoorBuild> selectByExample(PoorBuildExample example);

    PoorBuild selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") PoorBuild record, @Param("example") PoorBuildExample example);

    int updateByExample(@Param("record") PoorBuild record, @Param("example") PoorBuildExample example);

    int updateByPrimaryKeySelective(PoorBuild record);

    int updateByPrimaryKey(PoorBuild record);

    //建档信息
    List<PoorPovo> getAllPoorinfo(Map map);

    //图表数据
    List<DataStatistics> getCountPoor(Integer year);
}