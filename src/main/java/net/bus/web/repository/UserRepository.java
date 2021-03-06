package net.bus.web.repository;

import net.bus.web.mapper.UserMapper;
import net.bus.web.model.User;
import net.bus.web.model.UserExample;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sky on 16/11/30.
 */
@Repository
public class UserRepository {

    @Autowired
    private UserMapper userMapper;

    public List<User> getAllUsers() {
        UserExample example = new UserExample();
        return userMapper.selectByExample(example);
    }

    public List<User> getAllUsers(int page,int limit) {
        UserExample example = new UserExample();
        return userMapper.selectByExampleWithRowbounds(example, new RowBounds(page*limit, limit));
    }

    public List<User> getAllUsersByExample(ISpecification specification,int page,int limit) {
        return userMapper.selectByExampleWithRowbounds((UserExample) specification.createExample(), new RowBounds(page*limit, limit));
    }

    public List<User> getItems(ISpecification specification) {
        UserExample example = (UserExample)specification.createExample();
        if(example==null)
            return new ArrayList<User>();

        List<User> list= userMapper.selectByExample(example);
        if(!list.isEmpty())
        {
            return list;
        }

        return new ArrayList<User>();
    }


    public User getUser(ISpecification specification)
    {
        List<User> list= userMapper.selectByExample((UserExample)specification.createExample());
        if(!list.isEmpty())
        {
            return list.get(0);
        }

        return null;
    }

    public User getUser(String id) {
        return userMapper.selectByPrimaryKey(id);
    }

    public int insertUser(User user)
    {
        return userMapper.insert(user);
    }

    public int updateUser(User user)
    {
        return userMapper.updateByPrimaryKey(user);
    }

    public int Count(){
        return userMapper.countByExample(null);
    }

    public int CountByExample(ISpecification specification){
        return userMapper.countByExample((UserExample)specification.createExample());
    }

    public int deleteByPrimaryKey(String id){
        return  userMapper.deleteByPrimaryKey(id);
    }

    public int deleteByExample(ISpecification specification){
        return  userMapper.deleteByExample((UserExample) specification.createExample());
    }
}
