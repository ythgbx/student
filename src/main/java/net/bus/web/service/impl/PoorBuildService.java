package net.bus.web.service.impl;

import net.bus.web.controller.dto.PoorBuildDto;
import net.bus.web.repository.PoorBuildRespositiory;
import net.bus.web.service.IPoorBuildService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by sky on 16/12/6.
 */
public class PoorBuildService implements IPoorBuildService{
    @Autowired
    private PoorBuildRespositiory _rootRepository;

    public boolean insert(PoorBuildDto poorBuildDto) {
        if (_rootRepository.insertStudent(poorBuildDto)>0){
            return true;
        }
        return false;
    }
}
