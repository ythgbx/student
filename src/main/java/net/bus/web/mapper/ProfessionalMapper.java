package net.bus.web.mapper;

import java.util.List;
import net.bus.web.model.Professional;
import net.bus.web.model.ProfessionalExample;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface ProfessionalMapper {
    int countByExample(ProfessionalExample example);

    int deleteByExample(ProfessionalExample example);

    int deleteByPrimaryKey(String pcode);

    int insert(Professional record);

    int insertSelective(Professional record);

    List<Professional> selectByExampleWithRowbounds(ProfessionalExample example, RowBounds rowBounds);

    List<Professional> selectByExample(ProfessionalExample example);

    Professional selectByPrimaryKey(String pcode);

    int updateByExampleSelective(@Param("record") Professional record, @Param("example") ProfessionalExample example);

    int updateByExample(@Param("record") Professional record, @Param("example") ProfessionalExample example);

    int updateByPrimaryKeySelective(Professional record);

    int updateByPrimaryKey(Professional record);
}