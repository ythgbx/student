package net.bus.web.service.impl;

import net.bus.web.mapper.UserMapper;
import net.bus.web.model.User;
import net.bus.web.model.UserExample;
import net.bus.web.repository.ISpecification;
import net.bus.web.repository.UserRepository;
import net.bus.web.repository.UserTicketRepository;
import net.bus.web.repository.specification.UserPhonePasswordSpecification;
import net.bus.web.service.IUserService;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService  implements IUserService {

    @Autowired
    private UserRepository _rootRepository;

    public List<User> getAllUsers() {

        return _rootRepository.getAllUsers(); //分页
    }

    public User loginCheck(String phone,String password)
    {
        return _rootRepository.getUser(new UserPhonePasswordSpecification(phone,password));
    }

}
