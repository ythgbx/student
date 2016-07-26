package net.bus.web.repository.specification;

import net.bus.web.model.UserLineExample;
import net.bus.web.repository.ISpecification;

/**
 * Created by Edifi_000 on 2016-07-14.
 */
public class UserLineUserIdSpecification implements ISpecification<UserLineExample> {

    protected long _userId;

    public UserLineUserIdSpecification(long userId)
    {
        this._userId = userId;
    }

    public UserLineExample createExample()
    {
        UserLineExample example = new UserLineExample();
        UserLineExample.Criteria criteriaId = example.createCriteria();
        criteriaId.andUserIdEqualTo(_userId);
        return example;
    }
}
