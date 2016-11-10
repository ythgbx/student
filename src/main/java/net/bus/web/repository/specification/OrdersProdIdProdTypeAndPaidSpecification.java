package net.bus.web.repository.specification;

import net.bus.web.enums.ProducedTypeEnum;
import net.bus.web.model.OrdersExample;
import net.bus.web.repository.ISpecification;

/**
 * Created by Edifi_000 on 2016-11-09.
 */
public class OrdersProdIdProdTypeAndPaidSpecification implements ISpecification<OrdersExample> {

    protected long _productId;
    private ProducedTypeEnum _productTypeEnum;

    public OrdersProdIdProdTypeAndPaidSpecification(long productId, ProducedTypeEnum productTypeEnum)
    {
        this._productId = productId;
        this._productTypeEnum = productTypeEnum;
    }

    public OrdersExample createExample()
    {
        OrdersExample example = new OrdersExample();
        OrdersExample.Criteria criteria= example.createCriteria();
        criteria.andProductIdEqualTo(_productId).andProductTypeEqualTo(_productTypeEnum.getIndex()).andPayTimeIsNotNull();
        return example;
    }
}
