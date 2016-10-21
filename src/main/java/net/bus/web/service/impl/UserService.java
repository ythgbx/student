package net.bus.web.service.impl;

import net.bus.web.common.MD5;
import net.bus.web.context.Position;
import net.bus.web.model.User;
import net.bus.web.repository.UserRepository;
import net.bus.web.repository.specification.UserIdsSpecification;
import net.bus.web.repository.specification.UserPhoneSpecification;
import net.bus.web.repository.specification.UserWxUnionIdSpecification;
import net.bus.web.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class UserService  implements IUserService {

    @Autowired
    private UserRepository _rootRepository;

    public List<User> getAllUsers(int page,int limit) {

        return _rootRepository.getAllUsers(page - 1, limit);
    }

    public List<User> getUsers(List<Long> ids)
    {
        return _rootRepository.getItems(new UserIdsSpecification(ids));
    }

    public User getUser(Long id)
    {
        return _rootRepository.getUser(id);
    }

    public User getUser(String phone)
    {
        return  _rootRepository.getUser(new UserPhoneSpecification(phone));
    }

    public User getUserByWx(String wxUnionId){
        return  _rootRepository.getUser(new UserWxUnionIdSpecification(wxUnionId));
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
        User user = _rootRepository.getUser(new UserPhoneSpecification(phone));

        if(user==null){
            return null;
        }

        if(user.getPassword().equals(getUserPasswordMd5(user.getSalt(),password))){
            return user;
        }
        return null;
    }

    public User register(String phone,String password,String name)
    {
        User user = new User();
        user.setName(name);
        user.setPhone(phone);
        user.setPhoto("default");
        user.setLat(0d);
        user.setLng(0d);
        user.setPoints(0);
        user.setType(0);//用户类型：0是普通用户，1是司机，999是管理员
        user.setSalt(getRandomString(6));
        user.setPassword(getUserPasswordMd5(user.getSalt(),password));
        user.setRealName("");
        user.setIdCard("");
        _rootRepository.insertUser(user);
        return user;
    }

    public User registerByWx(String wxUnionId,String name,String photo)
    {
        User user = new User();
        user.setName(name);
        user.setPhone("");
        user.setWxUnionId(wxUnionId);
        user.setPhoto(photo);
        user.setLat(0d);
        user.setLng(0d);
        user.setPoints(0);
        user.setType(0);//用户类型：0是普通用户，1是司机，999是管理员
        user.setSalt("");
        user.setPassword("");
        user.setRealName("");
        user.setIdCard("");
        _rootRepository.insertUser(user);
        return user;
    }

    public boolean setAccount(User user,String phone,String password)
    {
        if(user!=null)
        {
            user.setPhone(phone);
            user.setPassword(getUserPasswordMd5(user.getSalt(), password));
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
            user.setPoints(point);
            _rootRepository.updateUser(user);
            return true;
        }
        return false;
    }

    public boolean setPhoto(User user, String photo) {
        if(user!=null&&photo.trim()!="")
        {
            user.setPhoto(photo);
            _rootRepository.updateUser(user);
            return true;
        }
        return false;
    }

    public boolean checkPassword(User user,String password)
    {
        return user.getPassword().equals(getUserPasswordMd5(user.getSalt(),password));
    }

    public boolean userCertification(User user, String realName, String id_card) {
        if(user!=null&&user.getRealName().equals("")&&user.getIdCard().equals("")){
            user.setRealName(realName);
            user.setIdCard(id_card);
            _rootRepository.updateUser(user);
            return true;
        }
        return false;
    }

    private String getUserPasswordMd5(String salt,String password){
        //兼容原有账号(对salt为null进行直接判断)
        if(salt.equals(null)||salt.equals("")){
            return password;
        }
        return (MD5.GetMD5Code(salt + password));
    }

    private String getRandomString(int length) { //length表示生成字符串的长度
        String base = "abcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }
        return sb.toString();
    }

}
