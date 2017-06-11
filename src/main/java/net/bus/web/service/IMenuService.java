package net.bus.web.service;

import net.bus.web.model.College;

import java.util.List;

/**
 * Created by yth on 2017/6/11.
 */

public interface IMenuService {

    College getCollege(String code);

    List<College> getAll();

    boolean update(College college);
}
