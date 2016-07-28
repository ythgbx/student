package net.bus.web.repository;

import net.bus.web.mapper.BusMapper;
import net.bus.web.model.Bus;
import net.bus.web.model.BusExample;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Edifi_000 on 2016-07-28.
 */
@Repository
public class BusRepository {

    @Autowired
    private BusMapper _mapper;

    public List<Bus> getAll() {
        BusExample example = new BusExample();
        return _mapper.selectByExample(example);
    }

    public List<Bus> getAll(int page,int limit) {
        BusExample example = new BusExample();
        if(example!=null) {
            return _mapper.selectByExampleWithRowbounds(example, new RowBounds(page, limit)); //分页
        }
        return new ArrayList<Bus>();
    }

    public List<Bus> getList(ISpecification specification) {
        BusExample example = (BusExample)specification.createExample();
        if(example!=null) {
            return _mapper.selectByExample(example);
        }
        return new ArrayList<Bus>();
    }

    public List<Bus> getList(ISpecification specification,int page,int limit) {
        BusExample example = (BusExample)specification.createExample();
        if(example!=null) {
            return _mapper.selectByExampleWithRowbounds(example, new RowBounds(page, limit)); //分页
        }
        return new ArrayList<Bus>();
    }

    public Bus getItem(ISpecification specification) {
        List<Bus> list= _mapper.selectByExample((BusExample)specification.createExample());
        if(!list.isEmpty())
        {
            return list.get(0);
        }

        return null;
    }

    public Bus getItem(Long id) {
        return _mapper.selectByPrimaryKey(id);
    }

    public int insertItem(Bus bus)
    {
        return _mapper.insert(bus);
    }

    public int updateItem(Bus bus)
    {
        return _mapper.updateByPrimaryKey(bus);
    }

    public boolean existItem(ISpecification specification){
        int result = _mapper.countByExample((BusExample)specification.createExample());
        if(result>0)
            return true;

        return  false;
    }

    public int count(ISpecification specification)
    {
        BusExample example = (BusExample)specification.createExample();
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
