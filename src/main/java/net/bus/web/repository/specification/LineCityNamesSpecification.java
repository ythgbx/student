package net.bus.web.repository.specification;

import net.bus.web.model.LineExample;
import net.bus.web.repository.ISpecification;

import java.util.List;

/**
 * Created by Edifi_000 on 2016-08-10.
 */
public class LineCityNamesSpecification implements ISpecification<LineExample> {

    protected List<String> _cityNames;

    public LineCityNamesSpecification(List<String> cityNames){
        this._cityNames = cityNames;
    }

    public LineExample createExample()
    {
        if(_cityNames.isEmpty())
            return null;

        LineExample example = new LineExample();
        LineExample.Criteria criteriaId = example.createCriteria();
        criteriaId.andCityNameIn(_cityNames);
        return example;
    }
}
