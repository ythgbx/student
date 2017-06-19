package net.bus.web.service.impl;

import net.bus.web.common.Util;
import net.bus.web.common.config.RString;
import net.bus.web.controller.dto.RecordDto;
import net.bus.web.model.ApplicationRecord;
import net.bus.web.model.Grant;
import net.bus.web.model.PoorBuild;
import net.bus.web.repository.ApplicationRecordRepository;
import net.bus.web.repository.specification.ApplicationRecordSpecification;
import net.bus.web.service.IApplicationRecordService;
import net.bus.web.service.IGrantService;
import net.bus.web.service.IPoorBuildService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yth on 2017/6/16.
 */
@Service
public class ApplicationRecordService implements IApplicationRecordService {
    @Autowired
    private ApplicationRecordRepository applicationRecordRepository;
    @Autowired
    private IPoorBuildService poorBuildService;
    @Autowired
    private IGrantService grantService;
//    @Autowired
//    private IMotivationalService motivationalService;
    public Boolean insert(String type,String idCard) {
        ApplicationRecord applicationRecord = new ApplicationRecord();
        applicationRecord.setIdcard(idCard);
        applicationRecord.setTypes(type);
        int a = applicationRecordRepository.insert(applicationRecord);
        if (a>0){
            return true;
        }
        return false;
    }

    public List<RecordDto> getall(String idCard) {
        List<ApplicationRecord> list = applicationRecordRepository.getItems(new ApplicationRecordSpecification(idCard));
       if (!list.isEmpty()){
           List<RecordDto> recordDtos = new ArrayList<RecordDto>();
           String type1 = RString.APPLICATION_POOR;
           for (ApplicationRecord applicationRecord:list){
               RecordDto recordDto = set(applicationRecord);
               recordDtos.add(recordDto);
           }
           return recordDtos;

       }
        return null;
    }

    public RecordDto set(ApplicationRecord applicationRecord){
        RecordDto recordDto = new RecordDto();
        recordDto.setId(applicationRecord.getId());
        recordDto.setType(applicationRecord.getTypes());
        if (applicationRecord.getTypes().equals(RString.APPLICATION_POOR)){
            PoorBuild poorBuild = poorBuildService.getPoorBuildByIdCard(applicationRecord.getIdcard());
            recordDto.setDate(Util.TimeToString(poorBuild.getApplicationtime()));
            if (poorBuild.getAdmin()==0){
                recordDto.setAdmin(RString.AUDIT);
            }else if (poorBuild.getAdmin()==1){
                recordDto.setAdmin(RString.AUDIT_ADMIN_FALSE);
            }else if (poorBuild.getAdmin()==2){
                recordDto.setAdmin(RString.AUDIT_ADMIN_TRUE);
            }
            if (poorBuild.getCounselorreview()==0){
                recordDto.setCounselor(RString.AUDIT);
            }else if (poorBuild.getCounselorreview()==1){
                recordDto.setCounselor(RString.AUDIT_ADMIN_FALSE);
            }else if (poorBuild.getCounselorreview()==2){
                recordDto.setCounselor(RString.AUDIT_ADMIN_TRUE);
            }
            if (poorBuild.getCounselorreviewremarks()!=null){
                recordDto.setRemark(poorBuild.getCounselorreviewremarks());
            }else {
                recordDto.setRemark(poorBuild.getAdminremarks());
            }

        }else if (applicationRecord.getTypes().equals(RString.APPLICATION_GRANT)){
            Grant grant = grantService.getStudent(applicationRecord.getIdcard());
            recordDto.setDate(Util.TimeToString(grant.getApplicationtime()));
            if (grant.getAdmin()==0){
                recordDto.setAdmin(RString.AUDIT);
            }else if (grant.getAdmin()==1){
                recordDto.setAdmin(RString.AUDIT_ADMIN_FALSE);
            }else if (grant.getAdmin()==2){
                recordDto.setAdmin(RString.AUDIT_ADMIN_TRUE);
            }
            if (grant.getDreviewed()==0){
                recordDto.setAdmin(RString.AUDIT);
            }else if (grant.getDreviewed()==1){
                recordDto.setAdmin(RString.AUDIT_ADMIN_FALSE);
            }else if (grant.getDreviewed()==2){
                recordDto.setAdmin(RString.AUDIT_ADMIN_TRUE);
            }
            if (grant.getDreviewedremarks()!=null){
                recordDto.setRemark(grant.getDreviewedremarks());
            }else {
                recordDto.setRemark(grant.getAdminremarks());
            }
        }
//              else if (applicationRecord.getType().equals(RString.APPLICATION_GRANT)){
//            Grant grant = grantService.getStudent(applicationRecord.getIdcard());
//            recordDto.setDate(Util.TimeToString(grant.getApplicationtime()));
//            if (grant.getAdmin()==0){
//                recordDto.setAdmin(RString.AUDIT);
//            }else if (grant.getAdmin()==1){
//                recordDto.setAdmin(RString.AUDIT_ADMIN_FALSE);
//            }else if (grant.getAdmin()==2){
//                recordDto.setAdmin(RString.AUDIT_ADMIN_TRUE);
//            }
//            if (grant.getDreviewed()==0){
//                recordDto.setAdmin(RString.AUDIT);
//            }else if (grant.getDreviewed()==1){
//                recordDto.setAdmin(RString.AUDIT_ADMIN_FALSE);
//            }else if (grant.getDreviewed()==2){
//                recordDto.setAdmin(RString.AUDIT_ADMIN_TRUE);
//            }
//            if (grant.getDreviewedremarks()!=null){
//                recordDto.setRemark(grant.getDreviewedremarks());
//            }else {
//                recordDto.setRemark(grant.getAdminremarks());
//            }
//        }
        return recordDto;
    }
}
