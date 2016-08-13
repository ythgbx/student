package net.bus.web.repository.specification;

import net.bus.web.model.UserCouponExample;
import net.bus.web.repository.ISpecification;

import java.util.Date;

/**
 * Created by sky on 16/8/13.
 */
public class UserCouponUserIdInStartAndEndTimeSpecification implements ISpecification<UserCouponExample> {

    protected long _userId;
    protected Date _time;

    public UserCouponUserIdInStartAndEndTimeSpecification(long userId,Date time)
    {
        this._userId = userId;
        this._time = time;
    }

    public UserCouponExample createExample()
    {
        UserCouponExample example = new UserCouponExample();
        UserCouponExample.Criteria criteria = example.createCriteria();
        criteria.andUserIdEqualTo(_userId).andStartTimeIsNotNull().andStartTimeLessThanOrEqualTo(_time).andEndTimeIsNotNull().andEndTimeGreaterThanOrEqualTo(_time);
        return example;
    }
}