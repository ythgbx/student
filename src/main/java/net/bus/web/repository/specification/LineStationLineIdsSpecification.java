package net.bus.web.repository.specification;

import net.bus.web.model.LineStationExample;
import net.bus.web.repository.ISpecification;

import java.util.List;

/**
 * Created by Edifi_000 on 2016-07-28.
 */
public class LineStationLineIdsSpecification implements ISpecification<LineStationExample> {

    protected List<Long> _lineIds;

    public LineStationLineIdsSpecification(List<Long> lineIds){
        this._lineIds = lineIds;
    }

    public LineStationExample createExample()

    {
        LineStationExample example = new LineStationExample();
        if(_lineIds!=null&&!_lineIds.isEmpty()){

            LineStationExample.Criteria criteriaLineId = example.createCriteria();
            criteriaLineId.andLineIdIn(_lineIds);
        }
        return example;
    }
}
