package net.bus.web.repository.specification;

import net.bus.web.model.LineStationExample;
import net.bus.web.repository.ISpecification;

import java.util.List;

/**
 * Created by Edifi_000 on 2016-07-14.
 */
public class LineStationStationIdsSpecification implements ISpecification<LineStationExample> {

    protected List<Long> _stationIds;

    public LineStationStationIdsSpecification(List<Long> stationIds){
        this._stationIds = stationIds;
    }

    public LineStationExample createExample()
    {
        LineStationExample example = new LineStationExample();
        LineStationExample.Criteria criteriaLineId = example.createCriteria();
        criteriaLineId.andStationIdIn(_stationIds);
        return example;
    }
}
