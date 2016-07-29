package net.bus.web.repository.specification;

import net.bus.web.model.BusExample;
import net.bus.web.repository.ISpecification;

/**
 * Created by Edifi_000 on 2016-07-30.
 */
public class BusLineIdSpecification implements ISpecification<BusExample> {

    protected Long _lineId;

    public BusLineIdSpecification(long lineId)
    {
        this._lineId = lineId;
    }

    public BusExample createExample()
    {
        BusExample example = new BusExample();
        BusExample.Criteria criteria= example.createCriteria();
        criteria.andLineIdEqualTo(_lineId);
        return example;
    }
}
