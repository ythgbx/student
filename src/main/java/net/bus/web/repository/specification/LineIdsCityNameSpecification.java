package net.bus.web.repository.specification;

import net.bus.web.model.LineExample;
import net.bus.web.repository.ISpecification;

import java.util.List;

/**
 * Created by Edifi_000 on 2016-08-11.
 */
public class LineIdsCityNameSpecification implements ISpecification<LineExample> {

    protected List<Long> _ids;
    protected String _cityName;

    public LineIdsCityNameSpecification(List<Long> ids,String cityName){
        this._ids = ids;
        this._cityName = cityName;
    }

    public LineExample createExample()
    {
        if(_ids.isEmpty())
            return null;

        LineExample example = new LineExample();
        LineExample.Criteria criteriaId = example.createCriteria();
        criteriaId.andIdIn(_ids).andCityNameEqualTo(_cityName);
        return example;
    }
}
