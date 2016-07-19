package net.bus.web.repository.specification;

import net.bus.web.model.UserExample;
import net.bus.web.repository.ISpecification;

/**
 * Created by Edifi_000 on 2016-07-19.
 */
public class UserPhoneSpecification implements ISpecification<UserExample> {

    protected String _phone;

    public UserPhoneSpecification(String phone)
    {
        this._phone = phone;
    }

    public UserExample createExample()
    {
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        criteria.andPhoneEqualTo(_phone);
        return example;
    }
}
