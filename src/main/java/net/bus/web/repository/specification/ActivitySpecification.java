package net.bus.web.repository.specification;

import net.bus.web.model.ActivityExample;
import net.bus.web.repository.ISpecification;

/**
 * Created by sky on 16/10/25.
 */
public class ActivitySpecification implements ISpecification {
    //TODO ActivitySpecification logical implement
    public Object createExample() {
        ActivityExample example = new ActivityExample();
        return example;
    }
}
