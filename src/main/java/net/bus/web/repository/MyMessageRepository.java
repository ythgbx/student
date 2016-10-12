package net.bus.web.repository;

import net.bus.web.mapper.MyMessageMapper;
import net.bus.web.model.MyMessage;
import net.bus.web.model.MyMessageExample;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sky on 16/10/12.
 */

@Repository
public class MyMessageRepository {

    @Autowired
    private MyMessageMapper _mapper;

    public List<MyMessage> getAll() {
        MyMessageExample example = new MyMessageExample();
        return _mapper.selectByExample(example);
    }

    public List<MyMessage> getAll(int page,int limit) {
        MyMessageExample example = new MyMessageExample();
        if(example!=null) {
            return _mapper.selectByExampleWithRowbounds(example, new RowBounds(page*limit, limit)); //分页
        }
        return new ArrayList<MyMessage>();
    }

    public List<MyMessage> getList(ISpecification specification) {
        MyMessageExample example = (MyMessageExample)specification.createExample();
        if(example!=null) {
            return _mapper.selectByExample(example);
        }
        return new ArrayList<MyMessage>();
    }

    public List<MyMessage> getList(ISpecification specification,int page,int limit) {
        MyMessageExample example = (MyMessageExample)specification.createExample();
        if(example!=null) {
            return _mapper.selectByExampleWithRowbounds(example, new RowBounds(page*limit, limit)); //分页
        }
        return new ArrayList<MyMessage>();
    }

    public MyMessage getItem(ISpecification specification) {
        List<MyMessage> list= _mapper.selectByExample((MyMessageExample)specification.createExample());
        if(!list.isEmpty())
        {
            return list.get(0);
        }

        return null;
    }

    public MyMessage getItem(Long id) {
        return _mapper.selectByPrimaryKey(id);
    }

    public int insertItem(MyMessage myMessage)
    {
        return _mapper.insert(myMessage);
    }

    public int updateItem(MyMessage myMessage)
    {
        return _mapper.updateByPrimaryKey(myMessage);
    }

    public boolean existItem(ISpecification specification){
        int result = _mapper.countByExample((MyMessageExample)specification.createExample());
        if(result>0)
            return true;

        return  false;
    }

    public int count(ISpecification specification)
    {
        MyMessageExample example = (MyMessageExample)specification.createExample();
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
