package net.bus.web.service;

import net.bus.web.model.User;

/**
 * Created by sky on 16/11/30.
 */
public interface IUserService {
    User loginCheck(String userName, String password);
}
