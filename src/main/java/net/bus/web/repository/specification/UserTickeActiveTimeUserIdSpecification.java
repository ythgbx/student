package net.bus.web.repository.specification;

import net.bus.web.model.UserTicketExample;
import net.bus.web.repository.ISpecification;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by sky on 16/7/9.
 */
public class UserTickeActiveTimeUserIdSpecification implements ISpecification<UserTicketExample> {

    public enum ActiveTimeOp{
        IsNull,
        Before,
        After
    }

    protected long _userId;
    protected Date _activeTime;
    protected ActiveTimeOp _op;

    public UserTickeActiveTimeUserIdSpecification(long userId, Date activeTime,ActiveTimeOp op)
    {
        this._userId = userId;
        this._activeTime = activeTime;
        this._op = op;
    }

    public UserTicketExample createExample()
    {
        UserTicketExample example;
        switch (_op)
        {
            case IsNull:
            {
                example = getActiveTimeIsNullExample();
                break;
            }
            case Before:
            {
                example = getActiveTimeBeforeExample();
                break;
            }
            case After:
            {
                example = getActiveTimeAfterExample();
                break;
            }
            default:
                example = getUserIdExample();
        }

        return example;
    }

    private UserTicketExample getUserIdExample()
    {
        UserTicketExample example = new UserTicketExample();
        UserTicketExample.Criteria criteriaUserId = example.createCriteria();
        criteriaUserId.andUserIdEqualTo(_userId);
        return example;
    }

    private UserTicketExample getActiveTimeIsNullExample()
    {
        UserTicketExample example = getUserIdExample();
        UserTicketExample.Criteria criteriaActiveTime = example.getOredCriteria().get(0);
        criteriaActiveTime.andActiveTimeIsNull();
        example.setOrderByClause("id desc");

        return example;
    }

    private UserTicketExample getActiveTimeBeforeExample()
    {
        UserTicketExample example = getUserIdExample();
        UserTicketExample.Criteria criteriaActiveTime = example.getOredCriteria().get(0);
        criteriaActiveTime.andActiveTimeGreaterThanOrEqualTo(_activeTime);
        example.setOrderByClause("id desc");

        return example;
    }

    private UserTicketExample getActiveTimeAfterExample()
    {
        UserTicketExample example = getUserIdExample();
        UserTicketExample.Criteria criteriaActiveTime = example.getOredCriteria().get(0);
        criteriaActiveTime.andActiveTimeLessThan(_activeTime);
        example.setOrderByClause("id desc");

        return example;
    }
}
