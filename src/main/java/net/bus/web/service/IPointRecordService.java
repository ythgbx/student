package net.bus.web.service;

import net.bus.web.model.PointRecord;
import net.bus.web.model.type.PointRecordType;

import java.sql.Date;
import java.util.List;

/**
 * Created by sky on 16/7/26.
 */
public interface IPointRecordService {
    void recordPoint(long userId, PointRecordType type, String source, int account, String remark);
    List<PointRecord> getRecordByUserId(long userId, int page, int limit);
}
