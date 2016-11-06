package net.bus.web.service.impl;

import net.bus.web.common.UUIDUtil;
import net.bus.web.enums.OrderState;
import net.bus.web.enums.OrderTypeEnum;
import net.bus.web.enums.ProducedTypeEnum;
import net.bus.web.model.Orders;
import net.bus.web.model.Pojo.AsyncCallBack;
import net.bus.web.model.Pojo.OrderCallBack;
import net.bus.web.model.Pojo.Product;
import net.bus.web.model.Pojo.WxAsyncCallBack;
import net.bus.web.repository.OrdersRepository;
import net.bus.web.repository.specification.OrdersTradeNoSpecification;
import net.bus.web.service.IAlipayService;
import net.bus.web.service.IOrderService;
import net.bus.web.service.IPayService;
import net.bus.web.service.IWxpayService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;

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

    public String createRefundTradeNo(OrderTypeEnum orderTypeEnum,ProducedTypeEnum producedType){
        return "Re"+createTradeNo(orderTypeEnum,producedType);
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

    public boolean confirm(OrderTypeEnum orderTypeEnum,Map<String, String> params){
        AsyncCallBack asyncCallBack;
        switch (orderTypeEnum){
            case ALIPAY:
            {
                asyncCallBack = _alipayService.async(params);
                break;
            }
            case WXPAY:
            {
                asyncCallBack = _wxpayService.async(params);
                break;
            }
            default:
                throw new RuntimeException("unknown order type");
        }

        if(asyncCallBack!=null&&!StringUtils.isBlank(asyncCallBack.getFailed())){
            if(!StringUtils.isBlank(asyncCallBack.getTradeNo())){

                Orders orders = query(asyncCallBack.getTradeNo());
                if(orders!=null){
                    IPayService payService = ProducedTypeEnum.get(orders.getProductType()).getService();
                    if(payService.buyComplete(asyncCallBack)){
                        orders.setPay(asyncCallBack.getPay());
                        orders.setPayTime(new Date());
                        _rootRepository.updateItem(orders);

                        return true;
                    }
                }
            }
        }
        return false;
    }

    public void refund(String tradeNo,String userId){
        Orders orders = query(tradeNo);
        if(orders!=null&&orders.getState().equals(2)){
            switch (OrderTypeEnum.get(orders.getTradeType())){
                case ALIPAY:
                {
                    //TODO 微信退款
                    throw new RuntimeException("alipay refund not impl");
                }
                case WXPAY:
                {
                    _wxpayService.refund(orders,
                            createRefundTradeNo(OrderTypeEnum.get(orders.getTradeType()),ProducedTypeEnum.get(orders.getProductType())),
                            userId);
                    break;
                }
                default:
                    throw new RuntimeException("unknown order type");
            }
        }
    }

    public void refundConfirm(Orders order){

    }
}
