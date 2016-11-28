package net.bus.web.repository.specification;

import net.bus.web.model.LineExample;
import net.bus.web.repository.ISpecification;

import java.util.List;

/**
 * Created by sky on 16/11/25.
 */
public class LineNamesSpecification implements ISpecification<LineExample> {
    protected String _lineName;

    public LineNamesSpecification(String _lineName){
        this._lineName = _lineName;
    }

    public LineExample createExample() {
        LineExample example = new LineExample();
        LineExample.Criteria criteriaId = example.createCriteria();
        if (!_lineName.equals("") || _lineName != null) {
            criteriaId.andNameLike(_lineName);
        }
        return example;

    }

}
