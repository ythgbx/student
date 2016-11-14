package net.bus.web.repository.Activity;

import net.bus.web.mapper.Temp_activeMapper;
import net.bus.web.model.Temp_active;
import net.bus.web.model.Temp_activeExample;
import net.bus.web.repository.ISpecification;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sky on 16/11/11.
 */
@Repository
public class XajhRepository {
    @Autowired
    Temp_activeMapper _mapper;


    public List<Temp_active> getAll() {
        Temp_activeExample example = new Temp_activeExample();
        return _mapper.selectByExample(example);
    }

    public List<Temp_active> getAll(int page,int limit) {
        Temp_activeExample example = new Temp_activeExample();
        if(example!=null) {
            return _mapper.selectByExampleWithRowbounds(example, new RowBounds(page*limit, limit)); //分页
        }
        return new ArrayList<Temp_active>();
    }

    public List<Temp_active> getList(ISpecification specification) {
        Temp_activeExample example = (Temp_activeExample)specification.createExample();
        if(example!=null) {
            return _mapper.selectByExample(example);
        }
        return new ArrayList<Temp_active>();
    }

    public List<Temp_active> getList(ISpecification specification, int page, int limit) {
        Temp_activeExample example = (Temp_activeExample)specification.createExample();
        if(example!=null) {
            return _mapper.selectByExampleWithRowbounds(example, new RowBounds(page*limit, limit)); //分页
        }
        return new ArrayList<Temp_active>();
    }

    public Temp_active getItem(ISpecification specification) {
        List<Temp_active> list= _mapper.selectByExample((Temp_activeExample)specification.createExample());
        if(!list.isEmpty())
        {
            return list.get(0);
        }

        return null;
    }

    public Temp_active getItem(Long id) {
        return _mapper.selectByPrimaryKey(id);
    }

    public int insertItem(Temp_active Xajh_2016_11)
    {
        return _mapper.insert(Xajh_2016_11);
    }

    public int updateItem(Temp_active Xajh_2016_11)
    {
        return _mapper.updateByPrimaryKey(Xajh_2016_11);
    }

    public boolean existItem(ISpecification specification){
        int result = _mapper.countByExample((Temp_activeExample)specification.createExample());
        if(result>0)
            return true;

        return  false;
    }

    public int count(ISpecification specification)
    {
        Temp_activeExample example = (Temp_activeExample)specification.createExample();
        if(example!=null){
            return _mapper.countByExample(example);
        }
        return 0;
    }

    public int count()
    {
        return _mapper.countByExample(null);
    }

    public int del(Long id){return _mapper.deleteByPrimaryKey(id);}

    public int del(ISpecification specification){
        return _mapper.deleteByExample((Temp_activeExample) specification.createExample());
    }
}
