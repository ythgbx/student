package net.bus.web.repository.specification;

import net.bus.web.model.OrdersExample;
import net.bus.web.repository.ISpecification;

/**
 * Created by Edifi_000 on 2016-10-31.
 */
public class OrdersTradeNoSpecification implements ISpecification<OrdersExample> {

    protected String _tradeNo;

    public OrdersTradeNoSpecification(String tradeNo)
    {
        this._tradeNo = tradeNo;
    }

    public OrdersExample createExample()
    {
        OrdersExample example = new OrdersExample();
        OrdersExample.Criteria criteria= example.createCriteria();
        criteria.andTradeNoEqualTo(_tradeNo);
        return example;
    }
}
