package net.bus.web.repository.specification;

import net.bus.web.model.MyMessageExample;
import net.bus.web.repository.ISpecification;

/**
 * Created by Edifi_000 on 2016-10-12.
 */
public class MyMessageUserIdOrNullSpecification implements ISpecification<MyMessageExample> {

    protected Long _userId;

    public MyMessageUserIdOrNullSpecification(Long userId)
    {
        this._userId = userId;
    }

    public MyMessageExample createExample()
    {
        MyMessageExample example = new MyMessageExample();
        MyMessageExample.Criteria criteria= example.createCriteria();
        if(_userId == null){
            criteria.andUserIdIsNull();
        }else{
            criteria.andUserIdEqualTo(_userId);
            example.or().andUserIdIsNull();
        }
        return example;
    }
}
