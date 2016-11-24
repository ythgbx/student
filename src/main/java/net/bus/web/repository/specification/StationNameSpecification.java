package net.bus.web.repository.specification;

import net.bus.web.model.StationExample;
import net.bus.web.repository.ISpecification;

/**
 * Created by Edifi_000 on 2016-07-14.
 */
public class StationNameSpecification implements ISpecification<StationExample> {

    protected String _name;
    protected Long _id;

    public StationNameSpecification(String name){
        this._name = name;
    }
    public StationNameSpecification(Long id){
        this._id = id;
    }

    public StationExample createExample()
    {
        StationExample example = new StationExample();
        StationExample.Criteria criteriaId = example.createCriteria();
        if (_name!=""&&_name!=null){
            criteriaId.andNameLike(_name);
        }
        if (_id!=null){
            criteriaId.andIdEqualTo(_id);
        }
        return example;
    }
}
