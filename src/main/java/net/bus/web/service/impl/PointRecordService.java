package net.bus.web.service.impl;

import net.bus.web.model.PointRecord;
import net.bus.web.model.PointRecordExample;
import net.bus.web.model.User;
import net.bus.web.model.type.PointRecordType;
import net.bus.web.model.type.PointSourceType;
import net.bus.web.repository.PointRecordRepository;
import net.bus.web.repository.specification.UserPointRecordSpecification;
import net.bus.web.service.IPointRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
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
    public void recordPoint(long userId, PointRecordType type, PointSourceType source, int account, String remark) {
        PointRecord pointRecord = new PointRecord();
        pointRecord.setUserid(userId);
        pointRecord.setType(type.toString());
        pointRecord.setSource(source.toString());
        pointRecord.setAccount(account);
        pointRecord.setRemark(remark);
        pointRecord.setRecordTime(new Date());
        _pointRecordRepository.insertItem(pointRecord);
    }


    /**
     * 获取用户签到积分记录
     * @param user user实例
     * @param page 页数
     * @param limit 每页显示多少条
     * @return
     */
    public List<PointRecord> getSignRecord(User user,int page, int limit){
        return _pointRecordRepository.getList(new UserPointRecordSpecification(user.getId(),PointSourceType.SIGN),page,limit);
    }

    /**
     * 获得签到用户记录总数
     * @param user user实例
     * @return
     */
    public int getSignRecordCount(User user){
        return _pointRecordRepository.getCount(new UserPointRecordSpecification(user.getId(),PointSourceType.SIGN));
    }

    /**
     * 获得用户积分记录
     * @param user 用户
     * @param sourceType 积分来源
     * @param page 页数
     * @param limit 每页显示的条目
     * @return
     */
    public List<PointRecord> getRecordWithSource(User user, PointSourceType sourceType, int page, int limit) {
        return _pointRecordRepository.getList(new UserPointRecordSpecification(user.getId(),sourceType),page,limit);
    }

    /**
     * 获得个人某来源的积分记录
     * @return 积分使用记录
     */
    public int getRecordWithSourceCount(User user, PointSourceType sourceType){
        return _pointRecordRepository.getCount(new UserPointRecordSpecification(user.getId(),sourceType));
    }
}
