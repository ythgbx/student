package net.bus.web.service;

import net.bus.web.model.User;

import java.util.List;

/**
 * Created by sky on 16/11/30.
 */
public interface IUserService {
    User loginCheck(String userName, String password, String role);

    User getUser(String id);

    boolean checkPassword(User user,String password);

    boolean setAccount(User user,String id,String password);

    boolean update(User user);

    Boolean add(User user );

    List<User> getAll(Integer role);

    Boolean del(String id);
}
