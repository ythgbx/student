package net.bus.web.repository.specification;

import net.bus.web.model.CommodityOrderExample;
import net.bus.web.repository.ISpecification;

/**
 * Created by Edifi_000 on 2016-10-11.
 */
public class CommodityOrderUserIdAndPaied  implements ISpecification<CommodityOrderExample> {

    protected long _userId;

    public CommodityOrderUserIdAndPaied(long userId)
    {
        this._userId = userId;
    }

    public CommodityOrderExample createExample()
    {
        CommodityOrderExample example = new CommodityOrderExample();
        CommodityOrderExample.Criteria criteria= example.createCriteria();
        criteria.andUserIdEqualTo(_userId).andPayTimeIsNotNull();
        return example;
    }
}
