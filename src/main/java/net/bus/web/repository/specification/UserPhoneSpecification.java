package net.bus.web.repository.specification;

import freemarker.template.utility.StringUtil;
import net.bus.web.common.Util;
import net.bus.web.model.UserExample;
import net.bus.web.repository.ISpecification;

/**
 * Created by Edifi_000 on 2016-07-19.
 */
public class UserPhoneSpecification implements ISpecification<UserExample> {

    protected String _phone;


    protected String _source;

    public UserPhoneSpecification(String phone)
    {
        this._phone = phone;
    }

    public UserPhoneSpecification(String phone, String source) {
        this._phone = phone;
        this._source = source;
    }

    public UserExample createExample()
    {
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        if (this._phone != null){
            criteria.andPhoneEqualTo(_phone);
        }
        if(this._source!=null){
            criteria.andSourceEqualTo(_source);
        }
        return example;
    }
}
