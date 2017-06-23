package net.bus.web.repository;

import net.bus.web.mapper.MotivationalMapper;
import net.bus.web.model.DataStatistics;
import net.bus.web.model.MotivationPovo;
import net.bus.web.model.Motivational;
import net.bus.web.model.MotivationalExample;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by yth on 2017/6/21.
 */
@Repository
public class MotivationRepository {
    @Autowired
    private MotivationalMapper mapper;

    public List<Motivational> getAllUsers() {
        MotivationalExample example = new MotivationalExample();
        return mapper.selectByExample(example);
    }

    public List<Motivational> getAllStudents(int page,int limit) {
        MotivationalExample example = new MotivationalExample();
        return mapper.selectByExampleWithRowbounds(example, new RowBounds(page*limit, limit));
    }

    public List<Motivational> getAllStudentsByExample(ISpecification specification,int page,int limit) {
        return mapper.selectByExampleWithRowbounds((MotivationalExample)specification.createExample(), new RowBounds(page*limit, limit));
    }

    public List<Motivational> getItems(ISpecification specification) {
        MotivationalExample example = (MotivationalExample)specification.createExample();
        if(example==null)
            return new ArrayList<Motivational>();

        List<Motivational> list= mapper.selectByExample(example);
        if(!list.isEmpty())
        {
            return list;
        }

        return new ArrayList<Motivational>();
    }


    public Motivational getPoorBuildByIdCard(ISpecification specification)
    {
        List<Motivational> list= mapper.selectByExample((MotivationalExample)specification.createExample());
        if(!list.isEmpty())
        {
            return list.get(0);
        }

        return null;
    }

    public Motivational getStudent(ISpecification specification) {
        List<Motivational> list =  mapper.selectByExample((MotivationalExample)specification.createExample());
        if(!list.isEmpty())
        {
            return list.get(0);
        }
        return null;
    }

    public int insertMotivation(Motivational motivational)
    {
        return mapper.insert(motivational);
    }

    public int updatePoorbuild(Motivational motivational)
    {
        return mapper.updateByPrimaryKeySelective(motivational);
    }

    public int Count(){
        return mapper.countByExample(null);
    }

    public int CountByExample(ISpecification specification){
        return mapper.countByExample((MotivationalExample)specification.createExample());
    }


    public int deleteByExample(ISpecification specification){
        return  mapper.deleteByExample((MotivationalExample) specification.createExample());
    }

    public List<MotivationPovo> getMotivation(Map map) {
        return mapper.selectMotivation(map);
    }

    public List<DataStatistics> getNumMotivational(Integer year){
        return mapper.getCountMotivational(year);
    }



}
