package net.bus.web.repository.specification;

import net.bus.web.model.UserCouponExample;
import net.bus.web.model.type.UserCouponType;
import net.bus.web.repository.ISpecification;

import java.util.Date;

/**
 * Created by Edifi_000 on 2016-08-04.
 */
public class UserCouponTypeInStartAndEndTimeSpecification implements ISpecification<UserCouponExample> {

    protected UserCouponType _type;
    protected Date _time;

    public UserCouponTypeInStartAndEndTimeSpecification(UserCouponType type,Date time)
    {
        this._type = type;
        this._time = time;
    }

    public UserCouponExample createExample()
    {
        UserCouponExample example = new UserCouponExample();
        UserCouponExample.Criteria criteria = example.createCriteria();
        criteria.andTypeEqualTo(_type.ordinal()).andStartTimeIsNotNull().andStartTimeLessThanOrEqualTo(_time).andEndTimeIsNotNull().andEndTimeGreaterThanOrEqualTo(_time);
        return example;
    }
}
