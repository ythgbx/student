package net.bus.web.repository.specification;

import net.bus.web.model.SignExample;
import net.bus.web.repository.ISpecification;

import java.util.Date;

/**
 * Created by sky on 16/7/26.
 */
public class UserSignSpecification implements ISpecification<SignExample> {

    protected long _userId;
    protected Date _date;
    protected int _succession;


    public UserSignSpecification(long userId)
    {
        this(userId,null);
    }
    public UserSignSpecification(long userId,Date date)
    {
       this(userId,null,0);
    }
    public UserSignSpecification(long userId,Date date,int succession)
    {
        this._userId = userId;
        this._date = date;
        this._succession = succession;
    }




    public SignExample createExample() {
        SignExample example = new SignExample();
        SignExample.Criteria criteria = example.createCriteria();
        criteria.andUseridEqualTo(_userId);
        example.setOrderByClause("sign_date desc");
        return example;
    }
}
