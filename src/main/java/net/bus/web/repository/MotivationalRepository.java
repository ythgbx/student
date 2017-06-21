package net.bus.web.repository;

import net.bus.web.mapper.MotivationalMapper;
import net.bus.web.model.Motivational;
import net.bus.web.model.MotivationalExample;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yth on 2017/6/20.
 */
@Repository
public class MotivationalRepository {
    @Autowired
    private MotivationalMapper motivationalMapper;

    public List<Motivational> getAllUsers() {
        MotivationalExample example = new MotivationalExample();
        return motivationalMapper.selectByExample(example);
    }

    public List<Motivational> getAllStudents(int page,int limit) {
        MotivationalExample example = new MotivationalExample();
        return motivationalMapper.selectByExampleWithRowbounds(example, new RowBounds(page*limit, limit));
    }

    public List<Motivational> getAllStudentsByExample(ISpecification specification,int page,int limit) {
        return motivationalMapper.selectByExampleWithRowbounds((MotivationalExample)specification.createExample(), new RowBounds(page*limit, limit));
    }

    public List<Motivational> getItems(ISpecification specification) {
        MotivationalExample example = (MotivationalExample)specification.createExample();
        if(example==null)
            return new ArrayList<Motivational>();

        List<Motivational> list= motivationalMapper.selectByExample(example);
        if(!list.isEmpty())
        {
            return list;
        }

        return new ArrayList<Motivational>();
    }


    public Motivational getStudent(ISpecification specification)
    {
        List<Motivational> list= motivationalMapper.selectByExample((MotivationalExample)specification.createExample());
        if(!list.isEmpty())
        {
            return list.get(0);
        }

        return null;
    }

    public Motivational getStudent(Long username) {
        return motivationalMapper.selectByPrimaryKey(username);
    }

    public int insertStudent(Motivational motivational)
    {
        return motivationalMapper.insert(motivational);
    }

    public int updateStudent(Motivational motivational)
    {
        return motivationalMapper.updateByPrimaryKey(motivational);
    }

    public int Count(){
        return motivationalMapper.countByExample(null);
    }

    public int CountByExample(ISpecification specification){
        return motivationalMapper.countByExample((MotivationalExample)specification.createExample());
    }

    public int deleteByPrimaryKey(Long sno){
        return  motivationalMapper.deleteByPrimaryKey(sno);
    }

    public int deleteByExample(ISpecification specification){
        return  motivationalMapper.deleteByExample((MotivationalExample) specification.createExample());
    }



}
