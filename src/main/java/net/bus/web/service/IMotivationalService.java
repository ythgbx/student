package net.bus.web.service;

import net.bus.web.controller.dto.StudentDetail;
import net.bus.web.model.DataStatistics;
import net.bus.web.model.Motivational;

import java.util.List;
import java.util.Map;

/**
 * Created by yth on 2017/6/16.
 */
public interface IMotivationalService {
   boolean insert(StudentDetail grantDto);

    Motivational getStudent(String idCard);

    List<DataStatistics> getNumMotivational(Integer year);

    Map<String,Object> getMotivation(int page, int rows,String college,String profession,String classname,String sno,String sname,String admin);

}
