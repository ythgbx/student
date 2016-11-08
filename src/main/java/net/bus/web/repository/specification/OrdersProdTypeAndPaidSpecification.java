package net.bus.web.repository.specification;

import net.bus.web.enums.ProducedTypeEnum;
import net.bus.web.model.OrdersExample;
import net.bus.web.repository.ISpecification;

/**
 * Created by Edifi_000 on 2016-11-08.
 */
public class OrdersProdTypeAndPaidSpecification implements ISpecification<OrdersExample> {

    private ProducedTypeEnum _producedTypeEnum;

    public OrdersProdTypeAndPaidSpecification(ProducedTypeEnum producedTypeEnum)
    {
        this._producedTypeEnum = producedTypeEnum;
    }

    public OrdersExample createExample()
    {
        OrdersExample example = new OrdersExample();
        OrdersExample.Criteria criteria= example.createCriteria();
        criteria.andProductTypeEqualTo(_producedTypeEnum.getIndex()).andPayTimeIsNotNull();
        return example;
    }
}