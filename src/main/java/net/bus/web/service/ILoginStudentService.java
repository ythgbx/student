package net.bus.web.service;


import net.bus.web.model.LoginStudent;

/**
 * Created by yth on 2017/6/21.
 */
public interface ILoginStudentService {
    LoginStudent getUser(String id);
}
