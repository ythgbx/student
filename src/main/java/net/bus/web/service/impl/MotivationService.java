package net.bus.web.service.impl;

import net.bus.web.common.config.RString;
import net.bus.web.controller.dto.StudentDetail;
import net.bus.web.model.Motivational;
import net.bus.web.repository.MotivationRepository;
import net.bus.web.service.IApplicationRecordService;
import net.bus.web.service.IMotivationalService;
import net.bus.web.teacher.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by lenovo on 2017/6/21.
 */
@Service
public class MotivationService implements IMotivationalService{

    @Autowired
    private MotivationRepository _rootRepository;
    @Autowired
    private IApplicationRecordService applicationRecordService;


    public boolean insert(StudentDetail motivation) {
        Motivational motivational = new Motivational();
        motivational.setIdcard(motivation.getIdcard());
        motivational.setPopulationcount(motivation.getPopulationcount());
        motivational.setFamilyincome(motivation.getFamilyincome());
        motivational.setMonthlyincome(motivation.getMonthlyincome());
        motivational.setRevenuesource(motivation.getRevenuesource());
        motivational.setPoorgrades(motivation.getPoorgrades());
        motivational.setAmounted(motivation.getAmounted());
        motivational.setFundedpurpose(motivation.getFundedpurpose());
        motivational.setFundpurpose(motivation.getFundpurpose());
        motivational.setBankaccount(motivation.getBankaccount());
        motivational.setApplicationreasons(motivation.getApplicationreasons());
        motivational.setApplicationtime(new Date());
        motivational.setCounselorreview(0);
        motivational.setAdmin(0);
        if (_rootRepository.insertMotivation(motivational)>0){
            applicationRecordService.insert(RString.APPLICATION_MOTIVATIONAL,motivation.getIdcard());
            return true;
        }
        return false;
    }

    public Motivational getStudent(String idCard) {
        return null;
    }

    public Map<String,Object> getMotivation(int page, int rows, String college, String profession, String classname, String sno, String sname, String admin) {
        Map<String,Object> param = PageUtil.pageMap(page, rows);
        param.put("college",college);
        param.put("profession",profession);
        param.put("classname",classname);
        param.put("sno",sno);
        param.put("sname",sname);
        param.put("admin",admin);
        List list = _rootRepository.getMotivation(param);
        int total = _rootRepository.Count();
        Map<String,Object> map = PageUtil.returnMap(list,total);
        return map;
    }
}
