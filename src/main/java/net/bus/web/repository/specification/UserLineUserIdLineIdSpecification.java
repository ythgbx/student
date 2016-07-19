package net.bus.web.repository.specification;

import net.bus.web.model.UserLineExample;
import net.bus.web.repository.ISpecification;

/**
 * Created by Edifi_000 on 2016-07-19.
 */
public class UserLineUserIdLineIdSpecification implements ISpecification<UserLineExample> {

    protected long _userId;
    protected long _lineId;

    public UserLineUserIdLineIdSpecification(long userId,long lineId)
    {
        this._userId = userId;
        this._lineId = lineId;
    }

    public UserLineExample createExample()
    {
        UserLineExample example = new UserLineExample();
        UserLineExample.Criteria criteriaId = example.createCriteria();
        criteriaId.andUserIdEqualTo(_userId).andLineIdEqualTo(_lineId);
        return example;
    }
}
