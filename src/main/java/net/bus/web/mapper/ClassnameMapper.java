package net.bus.web.mapper;

import java.util.List;
import net.bus.web.model.Classname;
import net.bus.web.model.ClassnameExample;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface ClassnameMapper {
    int countByExample(ClassnameExample example);

    int deleteByExample(ClassnameExample example);

    int insert(Classname record);

    int insertSelective(Classname record);

    List<Classname> selectByExampleWithRowbounds(ClassnameExample example, RowBounds rowBounds);

    List<Classname> selectByExample(ClassnameExample example);

    int updateByExampleSelective(@Param("record") Classname record, @Param("example") ClassnameExample example);

    int updateByExample(@Param("record") Classname record, @Param("example") ClassnameExample example);
}