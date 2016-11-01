package net.bus.web.repository;

import net.bus.web.mapper.ActivityOrderMapper;
import net.bus.web.model.Activity;
import net.bus.web.model.ActivityOrder;
import net.bus.web.model.ActivityOrderExample;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sky on 16/10/25.
 */
@Repository
public class ActivityOrderRepository {
    @Autowired
    private ActivityOrderMapper _mapper;

    public List<ActivityOrder> getAll() {
        ActivityOrderExample example = new ActivityOrderExample();
        return _mapper.selectByExample(example);
    }

    public List<ActivityOrder> getAll(int page,int limit) {
        ActivityOrderExample example = new ActivityOrderExample();
        if(example!=null) {
            return _mapper.selectByExampleWithRowbounds(example, new RowBounds(page*limit,limit)); //分页
        }
        return new ArrayList<ActivityOrder>();
    }

    public List<ActivityOrder> getList(ISpecification specification) {
        ActivityOrderExample example = (ActivityOrderExample)specification.createExample();
        if(example!=null) {
            return _mapper.selectByExample(example);
        }
        return new ArrayList<ActivityOrder>();
    }

    public ActivityOrder getItem(ISpecification specification){
        ActivityOrderExample example = (ActivityOrderExample)specification.createExample();
        if(example!=null) {
            return _mapper.selectByExample(example).get(0);
        }
        return null;
    }

    public List<ActivityOrder> getList(ISpecification specification,int page,int limit) {
        ActivityOrderExample example = (ActivityOrderExample)specification.createExample();
        if(example!=null) {
            return _mapper.selectByExampleWithRowbounds(example, new RowBounds(page*limit, limit)); //分页
        }
        return new ArrayList<ActivityOrder>();
    }
    public int insertItem(ActivityOrder activityOrder){
        return _mapper.insert(activityOrder);
    }

    public int updateItem(ActivityOrder activityOrder){
        return _mapper.updateByPrimaryKey(activityOrder);
    }

    public boolean existItem(ISpecification specification){
        int result = _mapper.countByExample((ActivityOrderExample)specification.createExample());
        if(result>0)
            return true;
        return  false;
    }

    public int count(ISpecification specification){
        ActivityOrderExample example = (ActivityOrderExample)specification.createExample();
        if(example!=null){
            return _mapper.countByExample(example);
        }
        return 0;
    }

    public int count(){
        return _mapper.countByExample(null);
    }

}
