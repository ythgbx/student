package net.bus.web.repository.specification;

import net.bus.web.model.UserTicketExample;
import net.bus.web.repository.ISpecification;

/**
 * Created by sky on 16/7/9.
 */
public class UserTicketLineIdSpecification implements ISpecification<UserTicketExample> {

    protected long _lineId;

    public UserTicketLineIdSpecification(long lineId)
    {
        this._lineId = lineId;
    }

    public UserTicketExample createExample()
    {
        UserTicketExample example = new UserTicketExample();
        UserTicketExample.Criteria criteriaLineId = example.createCriteria();
        criteriaLineId.andLineIdEqualTo(_lineId);
        return example;
    }
}
