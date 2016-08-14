package net.bus.web.repository.specification;

import net.bus.web.model.StationExample;
import net.bus.web.repository.ISpecification;

import java.util.List;

/**
 * Created by Edifi_000 on 2016-08-14.
 */
public class StationIdsSpecification  implements ISpecification<StationExample> {

    protected List<Long> _ids;

    public StationIdsSpecification(List<Long> ids){
        this._ids = ids;
    }

    public StationExample createExample()
    {
        if(_ids.isEmpty())
            return null;

        StationExample example = new StationExample();
        StationExample.Criteria criteriaId = example.createCriteria();
        criteriaId.andIdIn(_ids);
        return example;
    }
}
