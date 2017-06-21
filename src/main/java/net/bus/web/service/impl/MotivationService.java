package net.bus.web.service.impl;

import net.bus.web.repository.specification.IMotivation;
import net.bus.web.service.IMotivationalService;
import net.bus.web.teacher.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by lenovo on 2017/6/21.
 */
@Service
public class MotivationService implements IMotivationalService{

    @Autowired
    private IMotivation _rootRepository;


    public Map getMotivation(int page, int rows, String college, String profession, String classname, String sno, String sname, String admin) {
        Map<String,Object> param = PageUtil.pageMap(page, rows);
        param.put("college",college);
        param.put("profession",profession);
        param.put("classname",classname);
        param.put("sno",sno);
        param.put("sname",sname);
        param.put("admin",admin);
        List list = _rootRepository.getMotivation(param);
        int total = _rootRepository.count();
        Map<String,Object> map = PageUtil.returnMap(list,total);
        return map;
    }
}
