package net.bus.web.repository.specification;

import net.bus.web.repository.ISpecification;

/**
 * Created by sky on 16/7/9.
 */
public class UserPhonePasswordSpecification implements ISpecification {

    protected String _name;
    protected String _password;

    public UserPhonePasswordSpecification(String name,String password)
    {
        this._name = name;
        this._password =password;
    }
}
