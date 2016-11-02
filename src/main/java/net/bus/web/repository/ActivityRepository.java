package net.bus.web.repository;

import net.bus.web.mapper.ActivityMapper;
import net.bus.web.model.Activity;
import net.bus.web.model.ActivityExample;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sky on 16/10/13.
 */

@Repository
public class ActivityRepository {

    @Autowired
    private ActivityMapper _mapper;

    public List<Activity> getAll() {
        ActivityExample example = new ActivityExample();
        return _mapper.selectByExample(example);
    }

    public List<Activity> getAll(int page,int limit) {
        ActivityExample example = new ActivityExample();
        if(example!=null) {
            return _mapper.selectByExampleWithRowbounds(example, new RowBounds(page*limit,limit)); //分页
        }
        return new ArrayList<Activity>();
    }

    public List<Activity> getList(ISpecification specification) {
        ActivityExample example = (ActivityExample)specification.createExample();
        if(example!=null) {
            return _mapper.selectByExample(example);
        }
        return new ArrayList<Activity>();
    }

    public List<Activity> getList(ISpecification specification,int page,int limit) {
        ActivityExample example = (ActivityExample)specification.createExample();
        if(example!=null) {
            return _mapper.selectByExampleWithRowbounds(example, new RowBounds(page*limit, limit)); //分页
        }
        return new ArrayList<Activity>();
    }

    public Activity getItem(ISpecification specification) {
        List<Activity> list= _mapper.selectByExample((ActivityExample)specification.createExample());
        if(!list.isEmpty())
        {
            return list.get(0);
        }

        return null;
    }

    public Activity getItem(Long id) {
        return _mapper.selectByPrimaryKey(id);
    }

    public int insertItem(Activity line)
    {
        return _mapper.insert(line);
    }
    public int deleteByPrimaryKey(Long id){ return _mapper.deleteByPrimaryKey(id);}

    public int updateItem(Activity line)
    {
        return _mapper.updateByPrimaryKey(line);
    }

    public boolean existItem(ISpecification specification){
        int result = _mapper.countByExample((ActivityExample)specification.createExample());
        if(result>0)
            return true;

        return  false;
    }

    public int count(ISpecification specification)
    {
        ActivityExample example = (ActivityExample)specification.createExample();
        if(example!=null){
            return _mapper.countByExample(example);
        }
        return 0;
    }

    public int count()
    {
        return _mapper.countByExample(null);
    }

}

