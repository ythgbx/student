package net.bus.web.service;

import net.bus.web.controller.dto.PoorBuildDto;
import net.bus.web.model.PoorBuild;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Created by sky on 16/12/6.
 */
@Service
public interface IPoorBuildService {
    boolean insert(PoorBuildDto poorBuildDto);
    PoorBuild getPoorBuild(String Idcard);

    //获取所有贫困生建档的信息
    Map<String,Object> getAllPoor(int page, int rows,String college,String profession,String classname);


}
