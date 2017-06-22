package net.bus.web.repository;

import net.bus.web.mapper.LoginStudentMapper;
import net.bus.web.model.LoginStudent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by yth on 2017/6/21.
 */
@Repository
public class LoginStudentRepository {
    @Autowired
    private LoginStudentMapper mapper;

    public LoginStudent getStudent(String id) {
        return mapper.selectByPrimaryKey(id);
    }

}
