package net.bus.web.mapper;

import java.util.List;
import net.bus.web.model.CommodityType;
import net.bus.web.model.CommodityTypeExample;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface CommodityTypeMapper {
    int countByExample(CommodityTypeExample example);

    int deleteByExample(CommodityTypeExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CommodityType record);

    int insertSelective(CommodityType record);

    List<CommodityType> selectByExampleWithRowbounds(CommodityTypeExample example, RowBounds rowBounds);

    List<CommodityType> selectByExample(CommodityTypeExample example);

    CommodityType selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CommodityType record, @Param("example") CommodityTypeExample example);

    int updateByExample(@Param("record") CommodityType record, @Param("example") CommodityTypeExample example);

    int updateByPrimaryKeySelective(CommodityType record);

    int updateByPrimaryKey(CommodityType record);
}