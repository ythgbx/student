package net.bus.web.mapper;

import java.util.List;
import net.bus.web.model.College;
import net.bus.web.model.CollegeExample;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface CollegeMapper {
    int countByExample(CollegeExample example);

    int deleteByExample(CollegeExample example);

    int deleteByPrimaryKey(String code);

    int insert(College record);

    int insertSelective(College record);

    List<College> selectByExampleWithRowbounds(CollegeExample example, RowBounds rowBounds);

    List<College> selectByExample(CollegeExample example);

    College selectByPrimaryKey(String code);

    int updateByExampleSelective(@Param("record") College record, @Param("example") CollegeExample example);

    int updateByExample(@Param("record") College record, @Param("example") CollegeExample example);

    int updateByPrimaryKeySelective(College record);

    int updateByPrimaryKey(College record);
}