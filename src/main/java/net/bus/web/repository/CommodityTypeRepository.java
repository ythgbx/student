package net.bus.web.repository;

import net.bus.web.mapper.CommodityTypeMapper;
import net.bus.web.model.CommodityType;
import net.bus.web.model.CommodityTypeExample;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Edifi_000 on 2016-09-03.
 */
@Repository
public class CommodityTypeRepository {
    @Autowired
    private CommodityTypeMapper _mapper;

    public List<CommodityType> getAll() {
        CommodityTypeExample example = new CommodityTypeExample();
        return _mapper.selectByExample(example);
    }

    public List<CommodityType> getAll(int page,int limit) {
        CommodityTypeExample example = new CommodityTypeExample();
        if(example!=null) {
            return _mapper.selectByExampleWithRowbounds(example, new RowBounds(page*limit, limit)); //分页
        }
        return new ArrayList<CommodityType>();
    }

    public List<CommodityType> getList(ISpecification specification) {
        CommodityTypeExample example = (CommodityTypeExample)specification.createExample();
        if(example!=null) {
            return _mapper.selectByExample(example);
        }
        return new ArrayList<CommodityType>();
    }

    public List<CommodityType> getList(ISpecification specification,int page,int limit) {
        CommodityTypeExample example = (CommodityTypeExample)specification.createExample();
        if(example!=null) {
            return _mapper.selectByExampleWithRowbounds(example, new RowBounds(page*limit, limit)); //分页
        }
        return new ArrayList<CommodityType>();
    }

    public CommodityType getItem(ISpecification specification) {
        List<CommodityType> list= _mapper.selectByExample((CommodityTypeExample)specification.createExample());
        if(!list.isEmpty())
        {
            return list.get(0);
        }

        return null;
    }

    public CommodityType getItem(Long id) {
        return _mapper.selectByPrimaryKey(id);
    }

    public int insertItem(CommodityType commodityType)
    {
        return _mapper.insert(commodityType);
    }

    public int updateItem(CommodityType commodityType)
    {
        return _mapper.updateByPrimaryKey(commodityType);
    }

    public boolean existItem(ISpecification specification){
        int result = _mapper.countByExample((CommodityTypeExample)specification.createExample());
        if(result>0)
            return true;

        return  false;
    }

    public int count(ISpecification specification)
    {
        CommodityTypeExample example = (CommodityTypeExample)specification.createExample();
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
