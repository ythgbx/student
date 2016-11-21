package net.bus.web.repository.specification;

import net.bus.web.model.ActivityExample;
import net.bus.web.repository.ISpecification;

import java.util.List;

/**
 * Created by sky on 16/10/25.
 */
public class ActivitySpecification implements ISpecification<ActivityExample> {
    protected List<Long> _ids;

    public ActivitySpecification(List<Long> ids) {
        this._ids = ids;
    }

    //TODO ActivitySpecification logical implement
    public ActivityExample createExample() {
        ActivityExample example = new ActivityExample();
        if (_ids != null && !_ids.isEmpty()) {
            ActivityExample.Criteria criteria = example.createCriteria();
            criteria.andIdIn(_ids);
        }
        return example;
    }
}
