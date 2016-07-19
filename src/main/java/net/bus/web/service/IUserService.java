package net.bus.web.service;

import net.bus.web.context.Position;
import net.bus.web.model.User;

import java.util.List;

/**
 * Created by Edifi_000 on 2016-07-07.
 */
public interface IUserService {

    List<User> getAllUsers(int page,int limit);

    boolean registerCheck(String phone);

    User loginCheck(String phone,String password);

    User register(String phone,String password,String name);

    boolean setAccount(User user,String phone,String password);

    boolean setBase(User user,Position pos,String name,String photo);
}
