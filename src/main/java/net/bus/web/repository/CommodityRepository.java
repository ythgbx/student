package net.bus.web.repository;

import net.bus.web.model.Commodity;
import net.bus.web.mapper.CommodityMapper;
import net.bus.web.model.CommodityExample;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Edifi_000 on 2016-09-03.
 */
@Repository
public class CommodityRepository {

    @Autowired
    private CommodityMapper _mapper;

    public List<Commodity> getAll() {
        CommodityExample example = new CommodityExample();
        return _mapper.selectByExample(example);
    }

    public List<Commodity> getAll(int page,int limit) {
        CommodityExample example = new CommodityExample();
        if(example!=null) {
            return _mapper.selectByExampleWithRowbounds(example, new RowBounds(page*limit, limit)); //分页
        }
        return new ArrayList<Commodity>();
    }

    public List<Commodity> getList(ISpecification specification) {
        CommodityExample example = (CommodityExample)specification.createExample();
        if(example!=null) {
            return _mapper.selectByExample(example);
        }
        return new ArrayList<Commodity>();
    }

    public List<Commodity> getList(ISpecification specification,int page,int limit) {
        CommodityExample example = (CommodityExample)specification.createExample();
        if(example!=null) {
            return _mapper.selectByExampleWithRowbounds(example, new RowBounds(page*limit, limit)); //分页
        }
        return new ArrayList<Commodity>();
    }

    public Commodity getItem(ISpecification specification) {
        List<Commodity> list= _mapper.selectByExample((CommodityExample)specification.createExample());
        if(!list.isEmpty())
        {
            return list.get(0);
        }

        return null;
    }

    public Commodity getItem(Long id) {
        return _mapper.selectByPrimaryKey(id);
    }

    public int insertItem(Commodity commodity)
    {
        return _mapper.insert(commodity);
    }

    public int updateItem(Commodity commodity)
    {
        return _mapper.updateByPrimaryKey(commodity);
    }

    public boolean existItem(ISpecification specification){
        int result = _mapper.countByExample((CommodityExample)specification.createExample());
        if(result>0)
            return true;

        return  false;
    }

    public int delete(ISpecification Specification) {
        return _mapper.deleteByExample((CommodityExample)Specification.createExample());
    }
    public int delete(Long id) {
        return _mapper.deleteByPrimaryKey(id);
    }

    public int count(ISpecification specification)
    {
        CommodityExample example = (CommodityExample)specification.createExample();
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
