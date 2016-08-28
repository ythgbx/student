package net.bus.web.repository.specification;

import net.bus.web.model.BusExample;
import net.bus.web.repository.ISpecification;

/**
 * Created by Edifi_000 on 2016-08-29.
 */
public class BusIdSpecification implements ISpecification<BusExample> {

    protected Long _id;

    public BusIdSpecification(long id)
    {
        this._id = _id;
    }

    public BusExample createExample()
    {
        BusExample example = new BusExample();
        BusExample.Criteria criteria= example.createCriteria();
        criteria.andIdEqualTo(_id);
        return example;
    }
}
