package net.bus.web.service.impl;

import net.bus.web.common.UUIDUtil;
import net.bus.web.enums.OrderState;
import net.bus.web.enums.OrderTypeEnum;
import net.bus.web.enums.ProducedTypeEnum;
import net.bus.web.model.Orders;
import net.bus.web.model.Pojo.OrderCallBack;
import net.bus.web.model.Pojo.Product;
import net.bus.web.repository.OrdersRepository;
import net.bus.web.repository.specification.OrdersTradeNoSpecification;
import net.bus.web.service.IAlipayService;
import net.bus.web.service.IOrderService;
import net.bus.web.service.IWxpayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by Edifi_000 on 2016-10-31.
 */
@Service
public class OrderService implements IOrderService{

    @Autowired
    private OrdersRepository _rootRepository;
    @Autowired
    private IAlipayService _alipayService;
    @Autowired
    private IWxpayService _wxpayService;


    public String createTradeNo(OrderTypeEnum orderTypeEnum,ProducedTypeEnum producedType){
        return String.valueOf(orderTypeEnum.getPre())+String.valueOf(producedType.getPre())+UUIDUtil.getNew();
    }

    private Orders create(Long userId,OrderTypeEnum orderTypeEnum,Product product,int amount){
        Orders order = new Orders();
        order.setUserId(userId);
        order.setTradeNo(createTradeNo(orderTypeEnum, product.getType()));
        order.setTradeType(orderTypeEnum.getIndex());
        order.setProductId(product.getId());
        order.setProductType(product.getType().getIndex());
        order.setAmount(amount);
        order.setPrice(product.getPrice());
        order.setPay(BigDecimal.ZERO);
        order.setModifyTime(new Date());
        order.setState(OrderState.TOBEPAID.ordinal());
        return order;
    }

    public OrderCallBack submit(Long userId,OrderTypeEnum orderTypeEnum,Product product,int amount){

        Orders order = create(userId,orderTypeEnum,product,amount);

        //TODO
        OrderCallBack orderCallBack;
        switch (orderTypeEnum){
            case ALIPAY:
            {
                orderCallBack = _alipayService.sign(product,order.getTradeNo());
                break;
            }
            case WXPAY:
            {
                orderCallBack =  _wxpayService.prepay(product,order.getTradeNo());
                break;
            }
            default:
                throw new RuntimeException("unknown order type");
        }
        _rootRepository.insertItem(order);
        return orderCallBack;
    }

    public Orders query(String tradeNo){
        return  _rootRepository.getItem(new OrdersTradeNoSpecification(tradeNo));
    }

    public void confirm(Orders order){

    }

    public void refund(Orders order){

    }

    public void refundConfirm(Orders order){

    }
}
