package net.bus.web.repository.specification;

import net.bus.web.model.UserTicketExample;
import net.bus.web.repository.ISpecification;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by sky on 16/7/9.
 */
public class UserTicketUserIdSpecification implements ISpecification<UserTicketExample> {


    protected long _userId;

    public UserTicketUserIdSpecification(long userId)
    {
        this._userId = userId;
    }

    public UserTicketExample createExample()
    {
        UserTicketExample example = new UserTicketExample();
        UserTicketExample.Criteria criteriaUserId = example.createCriteria();
        criteriaUserId.andUserIdEqualTo(_userId);
        return example;
    }
}
