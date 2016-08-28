package net.bus.web.repository.specification;

import net.bus.web.model.BusExample;
import net.bus.web.repository.ISpecification;

/**
 * Created by Edifi_000 on 2016-08-29.
 */
public class BusDeviceSpecification implements ISpecification<BusExample> {

    protected String _device;

    public BusDeviceSpecification(String device)
    {
        this._device = device;
    }

    public BusExample createExample()
    {
        BusExample example = new BusExample();
        BusExample.Criteria criteria= example.createCriteria();
        criteria.andDeviceEqualTo(_device);
        return example;
    }
}
