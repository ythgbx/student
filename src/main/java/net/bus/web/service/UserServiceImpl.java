package net.bus.web.service;

import net.bus.web.mapper.UserMapper;
import net.bus.web.model.User;
import net.bus.web.model.UserExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    public List<User> getAllUsers() {
        UserExample example = new UserExample();
        example.createCriteria().andIdBetween(3l, 4l);
        return userMapper.selectByExample(example);
    }
}
