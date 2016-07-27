package net.bus.web.service.impl;

import net.bus.web.model.Sign;
import net.bus.web.model.User;
import net.bus.web.model.type.PointRecordType;
import net.bus.web.repository.SignRespository;
import net.bus.web.repository.UserRepository;
import net.bus.web.repository.specification.UserSignSpecification;
import net.bus.web.service.ISignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by sky on 16/7/26.
 */
@Service
public class SignService implements ISignService {
    @Autowired
    private SignRespository _respository;
    @Autowired
    private UserRepository _userRepository;
    @Autowired
    private PointRecordService _pointRecordService;

    /**
     * 用户签到
     * @param user User实例
     * @param date 时间
     * @return
     */
    public boolean sign(User user, Date date) {
        //此处也需要来一波事物
        Sign lastSign = this.getSignLast(user.getId());
        Sign sign = new Sign();
        sign.setUserid(user.getId());
        sign.setSignDate(date);
        sign.setSuccession(1);
        if (lastSign!=null){
            //比较上一次日期是否相差一天
            GregorianCalendar calendarOld = new GregorianCalendar();
            calendarOld.setTime(lastSign.getSignDate());
            GregorianCalendar calendar = new GregorianCalendar();
            calendar.setTime(date);
            if(calendar.get(1) == calendarOld.get(1) && calendar.get(2) == calendarOld.get(2)&&
                    calendar.get(5) == calendarOld.get(5)){
                return false;//同一天只能签到一次
            }
            calendar.add(5,-1);
            //比较年月日
            if(calendar.get(1) == calendarOld.get(1) && calendar.get(2) == calendarOld.get(2)&&
                    calendar.get(5) == calendarOld.get(5)){
                sign.setSuccession(lastSign.getSuccession()+1);
            }
        }
        int point = sign.getSuccession()>7?40:sign.getSuccession()*5;//1天5个每天加5个7天封顶40个断掉重来
        user.setPoints(user.getPoints()+point);
        _pointRecordService.recordPoint(user.getId(), PointRecordType.Income,"签到",point,"");
        _respository.insertItem(sign);
        _userRepository.updateUser(user);
        return true;
    }

    /**
     * 获取用户最近一次签到
     * @param userId 用户id
     * @return
     */
    public Sign getSignLast(long userId) {
        return _respository.getItem(new UserSignSpecification(userId));
    }

}
