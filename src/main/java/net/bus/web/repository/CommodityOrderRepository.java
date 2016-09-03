package net.bus.web.repository;

import net.bus.web.mapper.CommodityOrderMapper;
import net.bus.web.model.CommodityOrder;
import net.bus.web.model.CommodityOrderExample;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Edifi_000 on 2016-09-03.
 */
public class CommodityOrderRepository {
    @Autowired
    private CommodityOrderMapper _mapper;

    public List<CommodityOrder> getAll() {
        CommodityOrderExample example = new CommodityOrderExample();
        return _mapper.selectByExample(example);
    }

    public List<CommodityOrder> getAll(int page,int limit) {
        CommodityOrderExample example = new CommodityOrderExample();
        if(example!=null) {
            return _mapper.selectByExampleWithRowbounds(example, new RowBounds(page*limit, limit)); //分页
        }
        return new ArrayList<CommodityOrder>();
    }

    public List<CommodityOrder> getList(ISpecification specification) {
        CommodityOrderExample example = (CommodityOrderExample)specification.createExample();
        if(example!=null) {
            return _mapper.selectByExample(example);
        }
        return new ArrayList<CommodityOrder>();
    }

    public List<CommodityOrder> getList(ISpecification specification,int page,int limit) {
        CommodityOrderExample example = (CommodityOrderExample)specification.createExample();
        if(example!=null) {
            return _mapper.selectByExampleWithRowbounds(example, new RowBounds(page*limit, limit)); //分页
        }
        return new ArrayList<CommodityOrder>();
    }

    public CommodityOrder getItem(ISpecification specification) {
        List<CommodityOrder> list= _mapper.selectByExample((CommodityOrderExample)specification.createExample());
        if(!list.isEmpty())
        {
            return list.get(0);
        }

        return null;
    }

    public CommodityOrder getItem(Long id) {
        return _mapper.selectByPrimaryKey(id);
    }

    public int insertItem(CommodityOrder commodityOrder)
    {
        return _mapper.insert(commodityOrder);
    }

    public int updateItem(CommodityOrder commodityOrder)
    {
        return _mapper.updateByPrimaryKey(commodityOrder);
    }

    public boolean existItem(ISpecification specification){
        int result = _mapper.countByExample((CommodityOrderExample)specification.createExample());
        if(result>0)
            return true;

        return  false;
    }

    public int count(ISpecification specification)
    {
        CommodityOrderExample example = (CommodityOrderExample)specification.createExample();
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