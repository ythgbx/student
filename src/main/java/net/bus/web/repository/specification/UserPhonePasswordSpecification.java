package net.bus.web.repository.specification;

import net.bus.web.model.UserExample;
import net.bus.web.repository.ISpecification;

/**
 * Created by sky on 16/7/9.
 */
public class UserPhonePasswordSpecification implements ISpecification<UserExample> {

    protected String _phone;
    protected String _password;

    public UserPhonePasswordSpecification(String phone,String password)
    {
        this._phone = phone;
        this._password =password;
    }

    public UserExample createExample()
    {
        UserExample example = new UserExample();
        UserExample.Criteria criteriaPhone = example.createCriteria();
        criteriaPhone.andPhoneEqualTo(_phone);
        UserExample.Criteria criteriaPassword = example.createCriteria();
        criteriaPassword.andPasswordEqualTo(_password);
        return example;
    }
}
