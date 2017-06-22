package net.bus.web.service.impl;

import net.bus.web.model.LoginStudent;
import net.bus.web.repository.LoginStudentRepository;
import net.bus.web.service.ILoginStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by yth on 2017/6/21.
 */
@Service
public class LoginStudentService implements ILoginStudentService {
    @Autowired
    private LoginStudentRepository repository;
    public LoginStudent getUser(String id) {
        return repository.getStudent(id);
    }
}
