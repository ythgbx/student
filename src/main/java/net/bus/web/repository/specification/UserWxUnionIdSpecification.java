package net.bus.web.repository.specification;

import net.bus.web.model.UserExample;
import net.bus.web.repository.ISpecification;

/**
 * Created by Edifi_000 on 2016-10-07.
 */
public class UserWxUnionIdSpecification implements ISpecification<UserExample> {

    protected String _wxUnionId;

    public UserWxUnionIdSpecification(String wxUnionId)
    {
        this._wxUnionId = wxUnionId;
    }

    public UserExample createExample()
    {
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        criteria.andWxUnionIdEqualTo(_wxUnionId);
        return example;
    }
}
