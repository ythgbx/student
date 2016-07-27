package net.bus.web.repository;

import net.bus.web.mapper.SignMapper;
import net.bus.web.model.Sign;
import net.bus.web.model.SignExample;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by sky on 16/7/26.
 */
@Repository
public class SignRespository {
    @Autowired
    private SignMapper _mapper;
    public List<Sign> getAll() {
        SignExample example = new SignExample();
        return _mapper.selectByExample(example);
    }

    public List<Sign> getAll(int page,int limit) {
        SignExample example = new SignExample();
        return _mapper.selectByExampleWithRowbounds(example, new RowBounds(page, limit)); //分页
    }

    public List<Sign> getList(ISpecification specification) {
        SignExample example = (SignExample)specification.createExample();
        return _mapper.selectByExample(example);
    }

    public List<Sign> getList(ISpecification specification,int page,int limit) {
        SignExample example = (SignExample)specification.createExample();
        return _mapper.selectByExampleWithRowbounds(example, new RowBounds(page, limit)); //分页
    }

    public Sign getItem(ISpecification specification) {
        List<Sign> list= _mapper.selectByExample((SignExample) specification.createExample());
        if(!list.isEmpty())
        {
            return list.get(0);
        }

        return null;
    }


    public int insertItem(Sign sign)
    {
        return _mapper.insert(sign);
    }
}
