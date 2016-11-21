package net.bus.web.repository.specification;

import net.bus.web.model.UserExample;
import net.bus.web.repository.ISpecification;

import java.util.List;

/**
 * Created by Edifi_000 on 2016-08-05.
 */
public class UserIdsSpecification implements ISpecification<UserExample> {

    protected List<Long> _ids;

    public UserIdsSpecification(List<Long> ids){
        this._ids = ids;
    }

    public UserExample createExample()
    {

        UserExample example = new UserExample();
        if(_ids !=null && !_ids.isEmpty()){
            UserExample.Criteria criteria = example.createCriteria();
            criteria.andIdIn(_ids);
        }

        return example;
    }
}
