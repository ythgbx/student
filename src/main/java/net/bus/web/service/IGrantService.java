package net.bus.web.service;

import net.bus.web.controller.dto.StudentDetail;
import net.bus.web.model.DataStatistics;
import net.bus.web.model.Grant;

import java.util.List;
import java.util.Map;

/**
 * Created by sky on 16/12/9.
 */

public interface IGrantService {
    boolean insert(StudentDetail grantDto);

    Grant getStudent(String idCard);

    List<DataStatistics> getNumGrant(Integer year);

    Map<String,Object> getAllGrant(int page, int rows,String college,String profession,String classname,String sno,String sname,String admin);
}
