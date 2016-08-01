package net.bus.web.service.impl;

import net.bus.web.context.Position;
import net.bus.web.model.User;
import net.bus.web.repository.UserLineRepository;
import net.bus.web.repository.UserRepository;
import net.bus.web.repository.specification.UserPhonePasswordSpecification;
import net.bus.web.repository.specification.UserPhoneSpecification;
import net.bus.web.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService  implements IUserService {

    @Autowired
    private UserRepository _rootRepository;

    public List<User> getAllUsers(int page,int limit) {

        return _rootRepository.getAllUsers(page-1,limit);
    }

    public User getUser(Long id)
    {
        return _rootRepository.getUser(id);
    }

    public boolean registerCheck(String phone)
    {
        User user = _rootRepository.getUser(new UserPhoneSpecification(phone));
        if(user==null){
            return true;
        }
        return false;
    }

    public User loginCheck(String phone,String password)
    {
        return _rootRepository.getUser(new UserPhonePasswordSpecification(phone, password));
    }

    public User register(String phone,String password,String name)
    {
        User user = new User();
        user.setName(name);
        user.setPhone(phone);
        user.setPassword(password);
        user.setPhoto("default");
        user.setLat(0d);
        user.setLng(0d);
        user.setPoints(0);
        user.setType(0);//用户类型：0是普通用户，1是司机，999是管理员
        _rootRepository.insertUser(user);
        return user;
    }

    public boolean setAccount(User user,String phone,String password)
    {
        if(user!=null)
        {
            user.setPhone(phone);
            user.setPassword(password);
            _rootRepository.updateUser(user);
            return true;
        }
        return false;
    }

    public boolean setBase(User user,Position pos,String name,String photo)
    {
        if(user!=null)
        {
            user.setLat(pos.getLat());
            user.setLng(pos.getLng());
            user.setName(name);
            user.setPhoto(photo);
            _rootRepository.updateUser(user);
            return true;
        }

        return false;
    }

    public boolean addPoint(User user,Integer addNum)
    {
        if(user!=null&&addNum>0)
        {
            int point = user.getPoints() + addNum;
            if(point>=0){
                user.setPoints(point);
                _rootRepository.updateUser(user);
                return true;
            }
        }
        return false;
    }
}
