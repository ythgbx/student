package net.bus.web.service;

import net.bus.web.enums.OrderTypeEnum;
import net.bus.web.enums.ProducedTypeEnum;
import net.bus.web.model.Order;
import net.bus.web.model.Pojo.IOrderCallBack;

import java.math.BigDecimal;

/**
 * Created by Edifi_000 on 2016-10-30.
 */
public interface IOrderService {

    String createTradeNo(OrderTypeEnum orderTypeEnum,ProducedTypeEnum producedType,int limitLength);

    Order create(Long userId,OrderTypeEnum orderTypeEnum,Long productId,ProducedTypeEnum producedType,int amount,BigDecimal price);

    IOrderCallBack submit(Order order);

    Order query(String tradeNo);

    void confirm(Order order);

    void refund(Order order);

    void refundConfirm(Order order);
}
