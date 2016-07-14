package net.bus.web.repository.specification;

import net.bus.web.model.StationExample;
import net.bus.web.repository.ISpecification;

/**
 * Created by Edifi_000 on 2016-07-14.
 */
public class StationNameSpecification implements ISpecification<StationExample> {

    protected String _name;

    public StationNameSpecification(String name){
        this._name = name;
    }

    public StationExample createExample()
    {
        StationExample example = new StationExample();
        StationExample.Criteria criteriaId = example.createCriteria();
        criteriaId.andNameLike(_name);
        return example;
    }
}
