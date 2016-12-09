package net.bus.web.service.impl;

import net.bus.web.controller.dto.GrantDto;
import net.bus.web.model.Grant;
import net.bus.web.repository.GrantRepository;
import net.bus.web.service.IGrantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by sky on 16/12/9.
 */
@Service
public class GrantService implements IGrantService{
    @Autowired
    private GrantRepository _rootRepository;


    public boolean insert(GrantDto grantDto) {
        Grant grant = new Grant();
        grant.setPopulationcount(grantDto.getTotalNum());
        grant.setFamilyincome(grantDto.getTotalMoney());
        grant.setMonthlyincome(grantDto.getAveMoney());
        grant.setRevenuesource(grantDto.getEsources());
        grant.setPoorgrades(grantDto.getLevel());
        grant.setAmounted(grantDto.getLastyearMoney());
        grant.setFundedpurpose(grantDto.getUseofFunds());
        grant.setFundpurpose(grantDto.getThisUse());
        grant.setBankaccount(grantDto.getBandCard());
        grant.setM1name(grantDto.getM1name());
        grant.setM1age(grantDto.getM1age());
        grant.setM1relations(grantDto.getM1relations());
        grant.setM1company(grantDto.getM1company());
        grant.setM2name(grantDto.getM2name());
        grant.setM2age(grantDto.getM2age());
        grant.setM2relations(grantDto.getM2relations());
        grant.setM2company(grantDto.getM2company());
        grant.setM3name(grantDto.getM3name());
        grant.setM3age(grantDto.getM3age());
        grant.setM3relations(grantDto.getM3relations());
        grant.setM3company(grantDto.getM3company());
        grant.setApplicationreasons(grantDto.getApplication());
        grant.setMsign(grantDto.getSsign());
        grant.setMsigndate(grantDto.getDatetime());
        grant.setDsign(grantDto.getDsuggest());
        grant.setDsigndate(grantDto.getDdatetime());
        grant.setSgrade(grantDto.getSgrade());
        grant.setSsigndate(grantDto.getSdatetime());
        if (_rootRepository.insertGrant(grant)>0){
            return true;
        }
        return false;
    }

    public Grant getStudent(String id) {
        return _rootRepository.getGrant(id);
    }
}
