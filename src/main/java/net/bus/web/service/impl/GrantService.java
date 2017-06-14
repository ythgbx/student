package net.bus.web.service.impl;

import net.bus.web.controller.dto.GrantDto;
import net.bus.web.model.Grant;
import net.bus.web.repository.GrantRepository;
import net.bus.web.repository.specification.GrantidCardSpecification;
import net.bus.web.service.IGrantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by sky on 16/12/9.
 */
@Service
public class GrantService implements IGrantService{
    @Autowired
    private GrantRepository _rootRepository;


    public boolean insert(GrantDto grantDto) {
        Grant grant = new Grant();
        grant.setIdcard(grantDto.getIdcard());
        grant.setPopulationcount(grantDto.getPopulationcount());
        grant.setFamilyincome(grantDto.getFamilyincome());
        grant.setMonthlyincome(grantDto.getMonthlyincome());
        grant.setRevenuesource(grantDto.getRevenuesource());
        grant.setPoorgrades(grantDto.getPoorgrades());
        grant.setAmounted(grantDto.getAmounted());
        grant.setFundedpurpose(grantDto.getFundedpurpose());
        grant.setFundpurpose(grantDto.getFundpurpose());
        grant.setBankaccount(grantDto.getBankaccount());
        grant.setM1name(grantDto.getM1name());
        grant.setM1age(grantDto.getM1age());
        grant.setM1relations(grantDto.getM1relations());
        grant.setM1company(grantDto.getM1company());
        grant.setM2name(grantDto.getM2name());
        grant.setM2age(grantDto.getM2age());
        grant.setM2company(grantDto.getM2company());
        grant.setM2relations(grantDto.getM2relations());
        grant.setM3name(grantDto.getM3name());
        grant.setM3age(grantDto.getM3age());
        grant.setM3relations(grantDto.getM3relations());
        grant.setM3company(grantDto.getM3company());
        grant.setApplicationreasons(grantDto.getApplicationreasons());
        grant.setApplicationtime(new Date());
        if (_rootRepository.insertGrant(grant)>0){
            return true;
        }
        return false;
    }

    public Grant getStudent(String idCard) {
        return _rootRepository.getGrant(new GrantidCardSpecification(idCard));
    }
}
