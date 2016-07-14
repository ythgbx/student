package net.bus.web.repository.specification;

import net.bus.web.model.UserLineExample;
import net.bus.web.repository.ISpecification;

/**
 * Created by Edifi_000 on 2016-07-14.
 */
public class UserLineUserIdSpecification implements ISpecification<UserLineExample> {

    protected long _id;

    public UserLineUserIdSpecification(long id)
    {
        this._id = id;
    }

    public UserLineExample createExample()
    {
        UserLineExample example = new UserLineExample();
        UserLineExample.Criteria criteriaId = example.createCriteria();
        criteriaId.andIdEqualTo(_id);
        return example;
    }
}
