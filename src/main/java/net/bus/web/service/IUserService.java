package net.bus.web.service;

import net.bus.web.context.Position;
import net.bus.web.model.User;

import java.util.List;

/**
 * Created by Edifi_000 on 2016-07-07.
 */
public interface IUserService {

    List<User> getAllUsers(int page,int limit);

    List<User> getUsers(List<Long> ids);

    User getUser(Long id);

    User getUser(String phone);

    User getUserByWx(String wxUnionId);

    boolean registerCheck(String phone);

    User loginCheck(String phone,String password);

    User register(String phone,String password,String name);

    User registerByWx(String wxUnionId,String name,String photo);

    boolean setAccount(User user,String phone,String password);

    boolean setBase(User user,Position pos,String name,String photo);

    boolean addPoint(User user,Integer addNum);

    boolean setPhoto(User user,String photo);

    boolean checkPassword(User user,String password);
}
