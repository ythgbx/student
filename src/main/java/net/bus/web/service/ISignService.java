package net.bus.web.service;

import net.bus.web.model.Pojo.SignRecordPojo;
import net.bus.web.model.Sign;
import net.bus.web.model.User;

import java.util.Date;
import java.util.List;

/**
 * Created by sky on 16/7/26.
 */
public interface ISignService {
    int sign(User user, Date date);
    Sign getSignLast(long userId);
    List<SignRecordPojo> getSignRecordByUserId(long userId,int page,int limit);
}
