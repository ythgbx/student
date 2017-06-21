package net.bus.web.service.impl;

import net.bus.web.common.config.RString;
import net.bus.web.controller.dto.StudentDetail;
import net.bus.web.model.Motivational;
import net.bus.web.repository.MotivationalRepository;
import net.bus.web.repository.specification.MotivationalIdCardSpecification;
import net.bus.web.service.IApplicationRecordService;
import net.bus.web.service.IMotivationalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Map;

/**
 * Created by yth on 2017/6/20.
 */
@Service
public class MotivationalService implements IMotivationalService{
    @Autowired
    private MotivationalRepository repository;
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
        motivational.setRanking(motivation.getRanking());
        motivational.setTnumber(motivation.getTnumber());
        motivational.setCounselorreview(0);
        motivational.setAdmin(0);
        if (repository.insertStudent(motivational)>0){
            applicationRecordService.insert(RString.APPLICATION_MOTIVATIONAL,motivational.getIdcard());
            return true;
        }
        return false;
    }

    public Motivational getStudent(String idCard) {
        return repository.getStudent(new MotivationalIdCardSpecification(idCard));
    }

    public Map<String, Object> getAllGrant(int page, int rows, String college, String profession, String classname, String sno, String sname, String admin) {
        return null;
    }
}
