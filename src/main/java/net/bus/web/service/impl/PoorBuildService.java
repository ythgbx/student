package net.bus.web.service.impl;

import net.bus.web.controller.dto.PoorBuildDto;
import net.bus.web.model.PoorBuild;
import net.bus.web.repository.PoorBuildRepositiory;
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

    public boolean insert(PoorBuildDto poorBuildDto) {
        if (_rootRepository.insertStudent(poorBuildDto)>0){
            return true;
        }
        return false;
    }

    public PoorBuild getStudent(String id) {
        return _rootRepository.getStudent(id);
    }

    /**
     *
     * @param page
     * @param rows
     * @return
     *
     */
    public Map<String,Object> getAllPoor(int page, int rows){
        List list = _rootRepository.getPoor(PageUtil.pageMap(page, rows));
        int total = _rootRepository.Count();
        Map<String,Object> map = PageUtil.returnMap(list,total);
        return map;
    }
}
