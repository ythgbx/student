package net.bus.web.service;

import net.bus.web.model.Classname;
import net.bus.web.model.College;
import net.bus.web.model.Professional;

import java.util.List;

/**
 * Created by yth on 2017/6/11.
 */

public interface IMenuService {

    College getCollege(String code);

    List<College> getAll();

    List<Professional> getProfessional(String code);

    List<Classname> getClassname(String pcode);

    boolean update(College college);
}
