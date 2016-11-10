package net.bus.web.service;

import net.bus.web.enums.OrderTypeEnum;
import net.bus.web.enums.ProducedTypeEnum;
import net.bus.web.model.Orders;
import net.bus.web.model.Pojo.OrderCallBack;
import net.bus.web.model.Pojo.Product;

import java.util.List;
import java.util.Map;

/**
 * Created by Edifi_000 on 2016-10-30.
 */
public interface IOrderService {

    String createTradeNo(OrderTypeEnum orderTypeEnum,ProducedTypeEnum producedType);

    OrderCallBack submit(Long userId,OrderTypeEnum orderTypeEnum,Product product,int amount);

    Orders query(String tradeNo);

    boolean confirm(OrderTypeEnum orderTypeEnum,Map<String, String> params);

    void refund(String tradeNo,String userId);

    void refundConfirm(Orders order);

    List<Orders> getAllOrders(ProducedTypeEnum prodType,int page,int limit);

    int getAllOrdersCount(ProducedTypeEnum prodType);

    List<Orders> getUserOrders(long userId,ProducedTypeEnum prodType,int page,int limit);

    int getUserOrdersCount(long userId,ProducedTypeEnum prodType);

    List<Orders> getProductOrders(long productId, ProducedTypeEnum prodType,int page,int limit);

    int getProductOrdersCount(long productId,ProducedTypeEnum prodType);
}
