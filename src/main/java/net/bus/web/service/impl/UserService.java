package net.bus.web.service.impl;

import net.bus.web.model.User;
import net.bus.web.repository.UserRepository;
import net.bus.web.repository.specification.UserPhonePasswordSpecification;
import net.bus.web.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService  implements IUserService {

    @Autowired
    private UserRepository _rootRepository;

    public List<User> getAllUsers(int page,int limit) {

        return _rootRepository.getAllUsers(page,limit);
    }

    public User loginCheck(String phone,String password)
    {
        return _rootRepository.getUser(new UserPhonePasswordSpecification(phone,password));
    }

}
