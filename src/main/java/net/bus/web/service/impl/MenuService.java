package net.bus.web.service.impl;

import net.bus.web.model.Classname;
import net.bus.web.model.College;
import net.bus.web.model.Professional;
import net.bus.web.repository.MenuRepository;
import net.bus.web.repository.specification.ClassnamePcodeSpecification;
import net.bus.web.repository.specification.ProfessionalCodeSpecification;
import net.bus.web.service.IMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by yth on 2017/6/11.
 */
@Service
public class MenuService implements IMenuService {
    @Autowired
    private MenuRepository repository;

    public College getCollege(String code) {
        return null;
    }

    public List<College> getAll() {
        return repository.getAllColleges();
    }

    public List<Professional> getProfessional(String code) {
        return repository.getAllProfessional(new ProfessionalCodeSpecification(code));
    }

    public List<Classname> getClassname(String pcode) {
        return repository.getAllClassName(new ClassnamePcodeSpecification(pcode));
    }

    public boolean update(College college) {
        return false;
    }
}
