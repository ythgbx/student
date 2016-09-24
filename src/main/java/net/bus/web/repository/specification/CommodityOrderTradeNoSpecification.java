package net.bus.web.repository.specification;

import net.bus.web.model.CommodityOrderExample;
import net.bus.web.repository.ISpecification;

/**
 * Created by Edifi_000 on 2016-09-24.
 */
public class CommodityOrderTradeNoSpecification implements ISpecification<CommodityOrderExample> {

    protected String _tradeNo;

    public CommodityOrderTradeNoSpecification(String tradeNo)
    {
        this._tradeNo = tradeNo;
    }

    public CommodityOrderExample createExample()
    {
        CommodityOrderExample example = new CommodityOrderExample();
        CommodityOrderExample.Criteria criteria= example.createCriteria();
        criteria.andTradeNoEqualTo(_tradeNo);
        return example;
    }
}
