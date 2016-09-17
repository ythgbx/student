package net.bus.web.repository.specification;

import net.bus.web.model.LineExample;
import net.bus.web.repository.ISpecification;

import java.util.List;

/**
 * Created by Edifi_000 on 2016-09-17.
 */
public class LinePropNamesSpecification implements ISpecification<LineExample> {

        protected List<String> _propNames;

        public LinePropNamesSpecification(List<String> propNames){
                this._propNames = propNames;
        }

        public LineExample createExample()
        {
                if(_propNames.isEmpty())
                        return null;

                LineExample example = new LineExample();
                LineExample.Criteria criteriaId = example.createCriteria();
                criteriaId.andPropNameIn(_propNames);
                return example;
        }
}
