package net.bus.web.service.impl;

import net.bus.web.common.config.RString;
import net.bus.web.model.PoorBuild;
import net.bus.web.repository.PoorBuildRepositiory;
import net.bus.web.repository.specification.PoorBuildIdCardSpecification;
import net.bus.web.service.IApplicationRecordService;
import net.bus.web.service.IPoorBuildService;
import net.bus.web.teacher.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by sky on 16/12/6.
 */
@Service
public class PoorBuildService implements IPoorBuildService{
    @Autowired
    private PoorBuildRepositiory _rootRepository;
    @Autowired
    private IApplicationRecordService applicationRecordService;

    public boolean insert(PoorBuild poorBuild) {
        int a = _rootRepository.insertStudent(poorBuild);
        if (a>0){
            if (applicationRecordService.insert(RString.APPLICATION_POOR,poorBuild.getIdcard())){
                return true;
            }
        }
        return false;
    }

    public PoorBuild getPoorBuildByIdCard(String idCard) {
        return _rootRepository.getPoorBuildByIdCard(new PoorBuildIdCardSpecification(idCard));
    }

    /**
     *
     * @param page
     * @param rows
     * @return
     *
     */
    public Map<String,Object> getAllPoor(int page, int rows,String college,String profession,String classname,
                                         String sno,String sname,String admin){
        Map<String,Object> param = PageUtil.pageMap(page, rows);
        param.put("college",college);
        param.put("profession",profession);
        param.put("classname",classname);
        param.put("sno",sno);
        param.put("sname",sname);
        param.put("admin",admin);
        List list = _rootRepository.getPoor(param);
        int total = _rootRepository.Count();
        Map<String,Object> map = PageUtil.returnMap(list,total);
        return map;
    }

    public int update(PoorBuild poorBuild){
        return _rootRepository.updatePoorbuild(poorBuild);
    }

}
