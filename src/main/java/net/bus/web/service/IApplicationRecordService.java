package net.bus.web.service;

import net.bus.web.controller.dto.RecordDto;

import java.util.List;

/**
 * Created by yth on 2017/6/16.
 */
public interface IApplicationRecordService {
    Boolean insert(String type,String idCard);

    List<RecordDto> getall(String idCard);

}
