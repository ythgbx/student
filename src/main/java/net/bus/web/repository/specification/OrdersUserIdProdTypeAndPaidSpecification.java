package net.bus.web.repository.specification;

import net.bus.web.enums.ProducedTypeEnum;
import net.bus.web.model.OrdersExample;
import net.bus.web.repository.ISpecification;

/**
 * Created by Edifi_000 on 2016-11-08.
 */
public class OrdersUserIdProdTypeAndPaidSpecification implements ISpecification<OrdersExample> {

    protected long _userId;
    private ProducedTypeEnum _producedTypeEnum;

    public OrdersUserIdProdTypeAndPaidSpecification(long userId, ProducedTypeEnum producedTypeEnum)
    {
        this._userId = userId;
        this._producedTypeEnum = producedTypeEnum;
    }

    public OrdersExample createExample()
    {
        OrdersExample example = new OrdersExample();
        OrdersExample.Criteria criteria= example.createCriteria();
        criteria.andUserIdEqualTo(_userId).andProductTypeEqualTo(_producedTypeEnum.getIndex()).andPayTimeIsNotNull();
        return example;
    }
}
