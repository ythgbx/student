package net.bus.web.repository;

import net.bus.web.mapper.OrdersMapper;
import net.bus.web.model.Orders;
import net.bus.web.model.OrdersExample;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Edifi_000 on 2016-10-31.
 */
@Repository
public class OrdersRepository {

    @Autowired
    private OrdersMapper _mapper;

    public List<Orders> getAll() {
        OrdersExample example = new OrdersExample();
        return _mapper.selectByExample(example);
    }

    public List<Orders> getAll(int page,int limit) {
        OrdersExample example = new OrdersExample();
        if(example!=null) {
            return _mapper.selectByExampleWithRowbounds(example, new RowBounds(page*limit, limit)); //分页
        }
        return new ArrayList<Orders>();
    }

    public List<Orders> getList(ISpecification specification) {
        OrdersExample example = (OrdersExample)specification.createExample();
        if(example!=null) {
            return _mapper.selectByExample(example);
        }
        return new ArrayList<Orders>();
    }

    public List<Orders> getList(ISpecification specification,int page,int limit) {
        OrdersExample example = (OrdersExample)specification.createExample();
        if(example!=null) {
            return _mapper.selectByExampleWithRowbounds(example, new RowBounds(page*limit, limit)); //分页
        }
        return new ArrayList<Orders>();
    }

    public Orders getItem(ISpecification specification) {
        List<Orders> list= _mapper.selectByExample((OrdersExample)specification.createExample());
        if(!list.isEmpty())
        {
            return list.get(0);
        }

        return null;
    }

    public Orders getItem(Long id) {
        return _mapper.selectByPrimaryKey(id);
    }

    public int insertItem(Orders order)
    {
        return _mapper.insert(order);
    }

    public int updateItem(Orders order)
    {
        return _mapper.updateByPrimaryKey(order);
    }

    public boolean existItem(ISpecification specification){
        int result = _mapper.countByExample((OrdersExample)specification.createExample());
        if(result>0)
            return true;

        return  false;
    }

    public int count(ISpecification specification)
    {
        OrdersExample example = (OrdersExample)specification.createExample();
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
