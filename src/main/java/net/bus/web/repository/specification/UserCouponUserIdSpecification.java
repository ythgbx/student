package net.bus.web.repository.specification;

import net.bus.web.model.UserCouponExample;
import net.bus.web.repository.ISpecification;

import java.util.Date;

/**
 * Created by Edifi_000 on 2016-09-30.
 */
public class UserCouponUserIdSpecification implements ISpecification<UserCouponExample> {

    protected long _userId;

    public UserCouponUserIdSpecification(long userId)
    {
        this._userId = userId;
    }

    public UserCouponExample createExample()
    {
        UserCouponExample example = new UserCouponExample();
        UserCouponExample.Criteria criteria = example.createCriteria();
        criteria.andUserIdEqualTo(_userId).andStartTimeIsNotNull().andEndTimeIsNotNull();
        return example;
    }
}
