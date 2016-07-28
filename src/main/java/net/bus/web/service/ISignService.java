package net.bus.web.service;

import net.bus.web.model.Sign;
import net.bus.web.model.User;

import java.util.Date;

/**
 * Created by sky on 16/7/26.
 */
public interface ISignService {
    int sign(User user, Date date);
    Sign getSignLast(long userId);
}
