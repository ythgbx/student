package net.bus.web.repository.specification;

import net.bus.web.model.UserTicketExample;
import net.bus.web.repository.ISpecification;

/**
 * Created by sky on 16/7/9.
 */
public class UserTicketIdSpecification implements ISpecification<UserTicketExample> {

    protected long _id;

    public UserTicketIdSpecification(long id)
    {
        this._id = id;
    }

    public UserTicketExample createExample()
    {
        UserTicketExample example = new UserTicketExample();
        UserTicketExample.Criteria criteriaId = example.createCriteria();
        criteriaId.andIdEqualTo(_id);
        return example;
    }
}
