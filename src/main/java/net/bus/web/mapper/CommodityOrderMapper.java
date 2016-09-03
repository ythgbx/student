package net.bus.web.mapper;

import java.util.List;
import net.bus.web.model.CommodityOrder;
import net.bus.web.model.CommodityOrderExample;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface CommodityOrderMapper {
    int countByExample(CommodityOrderExample example);

    int deleteByExample(CommodityOrderExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CommodityOrder record);

    int insertSelective(CommodityOrder record);

    List<CommodityOrder> selectByExampleWithRowbounds(CommodityOrderExample example, RowBounds rowBounds);

    List<CommodityOrder> selectByExample(CommodityOrderExample example);

    CommodityOrder selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CommodityOrder record, @Param("example") CommodityOrderExample example);

    int updateByExample(@Param("record") CommodityOrder record, @Param("example") CommodityOrderExample example);

    int updateByPrimaryKeySelective(CommodityOrder record);

    int updateByPrimaryKey(CommodityOrder record);
}