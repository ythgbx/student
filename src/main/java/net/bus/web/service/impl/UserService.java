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
    public User loginCheck(String userName, String password, String role)
    {
        User user = _rootRepository.getUser(userName);
        if (user == null){
            return null;
        }else if (user.getPassword().equals(password) && user.getRole().equals(role)){
            return user;
        }
        return null;
    }

    public User getUser(String id) {
        return _rootRepository.getUser(id);
    }

    public boolean checkPassword(User user, String password) {
        return false;
    }

    public boolean setAccount(User user,String id,String password)
    {
        if(user!=null)
        {
            user.setId(id);
            user.setPassword(password);
            _rootRepository.updateUser(user);
            return true;
        }
        return false;
    }
}
