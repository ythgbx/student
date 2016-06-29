package net.bus.web.service;

import net.bus.web.mapper.UserMapper;
import net.bus.web.model.User;
import net.bus.web.model.UserExample;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public List<User> getAllUsers() {

        UserExample example = new UserExample();
        return userMapper.selectByExampleWithRowbounds(example, new RowBounds(1, 2)); //分页
    }
}
