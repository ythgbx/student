package net.bus.web.service.impl;

import net.bus.web.model.User;
import net.bus.web.repository.UserRepository;
import net.bus.web.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by sky on 16/11/30.
 */
@Service
public class UserService implements IUserService{
    @Autowired
    private UserRepository _rootRepository;
    public User loginCheck(String userName, String password)
    {
        User user = _rootRepository.getUser(userName);
        if (user == null){
            return null;
        }else if (user.getPassword().equals(password)){
            return user;
        }
        return null;
    }
}
