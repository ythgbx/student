package net.bus.web.repository.specification;

import net.bus.web.model.BusExample;
import net.bus.web.repository.ISpecification;

import java.util.List;

/**
 * Created by Edifi_000 on 2016-08-29.
 */
public class BusIdSpecification implements ISpecification<BusExample> {

    protected List<Long> _ids;

    public BusIdSpecification(List<Long> ids)
    {
        this._ids = _ids;
    }

    public BusExample createExample()
    {
        BusExample example = new BusExample();
        if(_ids!= null && !_ids.isEmpty()){
            BusExample.Criteria criteriaId = example.createCriteria();
            criteriaId.andIdIn(_ids);
        }
        return example;
    }
}
