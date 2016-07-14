package net.bus.web.repository;

import net.bus.web.mapper.UserLineMapper;
import net.bus.web.model.UserLine;
import net.bus.web.model.UserLineExample;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Edifi_000 on 2016-07-14.
 */
@Repository
public class UserLineRepository {

    @Autowired
    private UserLineMapper _mapper;

    public List<UserLine> getAll() {
        UserLineExample example = new UserLineExample();
        return _mapper.selectByExample(example);
    }

    public List<UserLine> getAll(int page,int limit) {
        UserLineExample example = new UserLineExample();
        return _mapper.selectByExampleWithRowbounds(example, new RowBounds(page, limit)); //分页
    }

    public List<UserLine> getList(ISpecification specification) {
        UserLineExample example = (UserLineExample)specification.createExample();
        return _mapper.selectByExample(example);
    }

    public List<UserLine> getList(ISpecification specification,int page,int limit) {
        UserLineExample example = (UserLineExample)specification.createExample();
        return _mapper.selectByExampleWithRowbounds(example, new RowBounds(page, limit)); //分页
    }

    public UserLine getItem(ISpecification specification) {
        List<UserLine> list= _mapper.selectByExample((UserLineExample)specification.createExample());
        if(!list.isEmpty())
        {
            return list.get(0);
        }

        return null;
    }

    public UserLine getItem(Long id) {
        return _mapper.selectByPrimaryKey(id);
    }

    public int insertItem(UserLine userLine)
    {
        return _mapper.insert(userLine);
    }

    public int updateItem(UserLine userLine)
    {
        return _mapper.updateByPrimaryKey(userLine);
    }
}
