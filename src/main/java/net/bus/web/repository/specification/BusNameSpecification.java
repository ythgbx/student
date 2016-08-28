package net.bus.web.repository.specification;

import net.bus.web.model.BusExample;
import net.bus.web.repository.ISpecification;

/**
 * Created by Edifi_000 on 2016-08-29.
 */
public class BusNameSpecification implements ISpecification<BusExample> {

    protected String _name;

    public BusNameSpecification(String name)
    {
        this._name = name;
    }

    public BusExample createExample()
    {
        BusExample example = new BusExample();
        BusExample.Criteria criteria= example.createCriteria();
        criteria.andNameEqualTo(_name);
        return example;
    }
}
