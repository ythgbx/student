package net.bus.web.mapper;

import java.util.List;
import net.bus.web.model.Commodity;
import net.bus.web.model.CommodityExample;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface CommodityMapper {
    int countByExample(CommodityExample example);

    int deleteByExample(CommodityExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Commodity record);

    int insertSelective(Commodity record);

    List<Commodity> selectByExampleWithBLOBsWithRowbounds(CommodityExample example, RowBounds rowBounds);

    List<Commodity> selectByExampleWithBLOBs(CommodityExample example);

    List<Commodity> selectByExampleWithRowbounds(CommodityExample example, RowBounds rowBounds);

    List<Commodity> selectByExample(CommodityExample example);

    Commodity selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Commodity record, @Param("example") CommodityExample example);

    int updateByExampleWithBLOBs(@Param("record") Commodity record, @Param("example") CommodityExample example);

    int updateByExample(@Param("record") Commodity record, @Param("example") CommodityExample example);

    int updateByPrimaryKeySelective(Commodity record);

    int updateByPrimaryKeyWithBLOBs(Commodity record);

    int updateByPrimaryKey(Commodity record);
}