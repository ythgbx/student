package net.bus.web.service.Activity.impl;

import net.bus.web.model.Temp_active;
import net.bus.web.repository.Activity.XajhRepository;
import net.bus.web.service.Activity.IXajhService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by sky on 16/11/11.
 */
@Service
public class XajhService implements IXajhService {


    @Autowired
    XajhRepository _repository;

    public boolean sign(String name, String phone, String school, String institute) {
        Temp_active model = new Temp_active();
        model.setName(name);
        model.setPhone(phone);
        model.setSchool(school);
        model.setInstitute(institute);
        int result = _repository.insertItem(model);
        return (result > 0);
    }
}
