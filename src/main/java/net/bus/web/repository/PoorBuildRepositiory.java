package net.bus.web.repository;

import net.bus.web.model.DataStatistics;
import net.bus.web.mapper.PoorBuildMapper;
import net.bus.web.model.PoorBuild;
import net.bus.web.model.PoorBuildExample;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by sky on 16/12/6.
 */
@Repository
public class PoorBuildRepositiory {
    @Autowired
    private PoorBuildMapper poorBuildMapper;

    public List<PoorBuild> getAllUsers() {
        PoorBuildExample example = new PoorBuildExample();
        return poorBuildMapper.selectByExample(example);
    }

    public List<PoorBuild> getAllStudents(int page,int limit) {
        PoorBuildExample example = new PoorBuildExample();
        return poorBuildMapper.selectByExampleWithRowbounds(example, new RowBounds(page*limit, limit));
    }

    public List<PoorBuild> getAllStudentsByExample(ISpecification specification,int page,int limit) {
        return poorBuildMapper.selectByExampleWithRowbounds((PoorBuildExample)specification.createExample(), new RowBounds(page*limit, limit));
    }

    public List<PoorBuild> getItems(ISpecification specification) {
        PoorBuildExample example = (PoorBuildExample)specification.createExample();
        if(example==null)
            return new ArrayList<PoorBuild>();

        List<PoorBuild> list= poorBuildMapper.selectByExample(example);
        if(!list.isEmpty())
        {
            return list;
        }

        return new ArrayList<PoorBuild>();
    }


    public PoorBuild getPoorBuildByIdCard(ISpecification specification)
    {
        List<PoorBuild> list= poorBuildMapper.selectByExample((PoorBuildExample)specification.createExample());
        if(!list.isEmpty())
        {
            return list.get(0);
        }

        return null;
    }

    public PoorBuild getStudent(ISpecification specification) {
        List<PoorBuild> list =  poorBuildMapper.selectByExample((PoorBuildExample)specification.createExample());
        if(!list.isEmpty())
        {
            return list.get(0);
        }
        return null;
    }

    public int insertStudent(PoorBuild poorBuild)
    {
        return poorBuildMapper.insert(poorBuild);
    }

    public int updatePoorbuild(PoorBuild student)
    {
        return poorBuildMapper.updateByPrimaryKeySelective(student);
    }



    public int CountByExample(Map map){
        return poorBuildMapper.countByExample(map);
    }


    public int deleteByExample(ISpecification specification){
        return  poorBuildMapper.deleteByExample((PoorBuildExample) specification.createExample());
    }

    /**
     * 返回所有
     */
    public List getPoor(Map map){
        return poorBuildMapper.getAllPoorinfo(map);
    }

    public List<DataStatistics> getCountPoor(Integer year){
        return poorBuildMapper.getCountPoor(year);
    }
}
