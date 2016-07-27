package net.bus.web.service;

import net.bus.web.model.PointRecord;
import net.bus.web.model.User;
import net.bus.web.model.type.PointRecordType;
import net.bus.web.model.type.PointSourceType;

import java.sql.Date;
import java.util.List;

/**
 * Created by sky on 16/7/26.
 */
public interface IPointRecordService {
    void recordPoint(long userId, PointRecordType type, PointSourceType source, int account, String remark);

    List<PointRecord> getRecordWithSource(User user, PointSourceType sourceType, int page, int limit);

    List<PointRecord> getSignRecord(User user, int page, int limit);

    int getRecordWithSourceCount(User user, PointSourceType sourceType);
    int getSignRecordCount(User user);
}