package net.bus.web.service.impl;

import net.bus.web.model.PointRecord;
import net.bus.web.model.type.PointRecordType;
import net.bus.web.repository.PointRecordRepository;
import net.bus.web.service.IPointRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by sky on 16/7/27.
 */
@Service
public class PointRecordService implements IPointRecordService {
    @Autowired
    private PointRecordRepository _pointRecordRepository;

    /**
     * 记录积分使用情况
     * @param userId 用户id
     * @param type 消费类型(收入、支出)
     * @param source 来源
     * @param account 数额
     * @param remark 备注
     */
    public void recordPoint(long userId, PointRecordType type, String source, int account, String remark) {
        PointRecord pointRecord = new PointRecord();
        pointRecord.setUserid(userId);
        pointRecord.setType(type.toString());
        pointRecord.setSource(source);
        pointRecord.setAccount(account);
        pointRecord.setRemark(remark);
        pointRecord.setRecordTime(new Date());
        _pointRecordRepository.insertItem(pointRecord);
    }


    /**
     *
     * @param userId
     * @param page
     * @param limit
     * @return
     */
    public List<PointRecord> getRecordByUserId(long userId, int page, int limit) {
        return null;
    }
}
