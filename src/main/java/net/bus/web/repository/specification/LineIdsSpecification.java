package net.bus.web.repository.specification;

import net.bus.web.model.LineExample;
import net.bus.web.repository.ISpecification;

import java.util.List;

/**
 * Created by Edifi_000 on 2016-07-14.
 */
public class LineIdsSpecification implements ISpecification<LineExample> {

    protected List<Long> _ids;

    public LineIdsSpecification(List<Long> ids){
        this._ids = ids;
    }

    public LineExample createExample()
    {
        LineExample example = new LineExample();
        LineExample.Criteria criteriaId = example.createCriteria();
        criteriaId.andIdIn(_ids);
        return example;
    }
}
