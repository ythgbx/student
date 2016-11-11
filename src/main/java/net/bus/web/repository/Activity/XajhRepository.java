package net.bus.web.repository.Activity;

import net.bus.web.mapper.Xajh_2016_11Mapper;
import net.bus.web.model.Xajh_2016_11;
import net.bus.web.model.Xajh_2016_11Example;
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
    Xajh_2016_11Mapper _mapper;


    public List<Xajh_2016_11> getAll() {
        Xajh_2016_11Example example = new Xajh_2016_11Example();
        return _mapper.selectByExample(example);
    }

    public List<Xajh_2016_11> getAll(int page,int limit) {
        Xajh_2016_11Example example = new Xajh_2016_11Example();
        if(example!=null) {
            return _mapper.selectByExampleWithRowbounds(example, new RowBounds(page*limit, limit)); //分页
        }
        return new ArrayList<Xajh_2016_11>();
    }

    public List<Xajh_2016_11> getList(ISpecification specification) {
        Xajh_2016_11Example example = (Xajh_2016_11Example)specification.createExample();
        if(example!=null) {
            return _mapper.selectByExample(example);
        }
        return new ArrayList<Xajh_2016_11>();
    }

    public List<Xajh_2016_11> getList(ISpecification specification, int page, int limit) {
        Xajh_2016_11Example example = (Xajh_2016_11Example)specification.createExample();
        if(example!=null) {
            return _mapper.selectByExampleWithRowbounds(example, new RowBounds(page*limit, limit)); //分页
        }
        return new ArrayList<Xajh_2016_11>();
    }

    public Xajh_2016_11 getItem(ISpecification specification) {
        List<Xajh_2016_11> list= _mapper.selectByExample((Xajh_2016_11Example)specification.createExample());
        if(!list.isEmpty())
        {
            return list.get(0);
        }

        return null;
    }

    public Xajh_2016_11 getItem(Long id) {
        return _mapper.selectByPrimaryKey(id);
    }

    public int insertItem(Xajh_2016_11 Xajh_2016_11)
    {
        return _mapper.insert(Xajh_2016_11);
    }

    public int updateItem(Xajh_2016_11 Xajh_2016_11)
    {
        return _mapper.updateByPrimaryKey(Xajh_2016_11);
    }

    public boolean existItem(ISpecification specification){
        int result = _mapper.countByExample((Xajh_2016_11Example)specification.createExample());
        if(result>0)
            return true;

        return  false;
    }

    public int count(ISpecification specification)
    {
        Xajh_2016_11Example example = (Xajh_2016_11Example)specification.createExample();
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
        return _mapper.deleteByExample((Xajh_2016_11Example) specification.createExample());
    }
}
