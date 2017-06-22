package net.bus.web.mapper;

import net.bus.web.model.LoginStudent;

/**
 * Created by yth on 2017/6/21.
 */
public interface LoginStudentMapper {
    LoginStudent selectByPrimaryKey(String idCard);
}
