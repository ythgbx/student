package net.bus.web.mapper;

import java.util.List;
import net.bus.web.model.Xajh_2016_11;
import net.bus.web.model.Xajh_2016_11Example;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface Xajh_2016_11Mapper {
    int countByExample(Xajh_2016_11Example example);

    int deleteByExample(Xajh_2016_11Example example);

    int deleteByPrimaryKey(Long id);

    int insert(Xajh_2016_11 record);

    int insertSelective(Xajh_2016_11 record);

    List<Xajh_2016_11> selectByExampleWithRowbounds(Xajh_2016_11Example example, RowBounds rowBounds);

    List<Xajh_2016_11> selectByExample(Xajh_2016_11Example example);

    Xajh_2016_11 selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Xajh_2016_11 record, @Param("example") Xajh_2016_11Example example);

    int updateByExample(@Param("record") Xajh_2016_11 record, @Param("example") Xajh_2016_11Example example);

    int updateByPrimaryKeySelective(Xajh_2016_11 record);

    int updateByPrimaryKey(Xajh_2016_11 record);
}