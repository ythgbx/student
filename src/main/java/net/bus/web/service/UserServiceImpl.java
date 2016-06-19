package net.bus.web.service;

import net.bus.web.mapper.UserMapper;
import net.bus.web.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    public ArrayList<User> getAllUsers() {
        return userMapper.getAllUsers();
    }
}
