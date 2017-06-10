package net.bus.web.service;

import net.bus.web.controller.dto.PoorBuildDto;
import net.bus.web.model.PoorBuild;
import org.springframework.stereotype.Service;

/**
 * Created by sky on 16/12/6.
 */
@Service
public interface IPoorBuildService {
    boolean insert(PoorBuildDto poorBuildDto);
    PoorBuild getStudent(String id);


}
