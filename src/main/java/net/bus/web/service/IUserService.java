package net.bus.web.service;

import net.bus.web.model.User;
import net.bus.web.repository.ISpecification;

import java.util.List;

/**
 * Created by Edifi_000 on 2016-07-07.
 */
public interface IUserService {

    List<User> getAllUsers(int page,int limit);

    User loginCheck(String phone,String password);
}
