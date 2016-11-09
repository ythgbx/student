package net.bus.web.service.impl;

import net.bus.web.common.UUIDUtil;
import net.bus.web.enums.OrderState;
import net.bus.web.enums.OrderTypeEnum;
import net.bus.web.enums.ProducedTypeEnum;
import net.bus.web.model.Orders;
import net.bus.web.model.Pojo.AsyncCallBack;
import net.bus.web.model.Pojo.OrderCallBack;
import net.bus.web.model.Pojo.Product;
import net.bus.web.repository.OrdersRepository;
import net.bus.web.repository.specification.OrdersProdTypeAndPaidSpecification;
import net.bus.web.repository.specification.OrdersTradeNoSpecification;
import net.bus.web.repository.specification.OrdersUserIdProdTypeAndPaidSpecification;
import net.bus.web.service.IAlipayService;
import net.bus.web.service.IOrderService;
import net.bus.web.service.IProductService;
import net.bus.web.service.IWxpayService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
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

    @Transactional
    public OrderCallBack submit(Long userId,OrderTypeEnum orderTypeEnum,Product product,int amount) throws RuntimeException{

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

    @Transactional
    public boolean confirm(OrderTypeEnum orderTypeEnum,Map<String, String> params) throws RuntimeException{

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
            if(!StringUtils.isBlank(asyncCallBack.getSelfTradeNo())){

                Orders orders = query(asyncCallBack.getSelfTradeNo());
                if(orders!=null){
                    IProductService payService = ProducedTypeEnum.get(orders.getProductType()).getService();
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

    @Transactional
    public void refund(String tradeNo,String userId) throws RuntimeException{
        Orders orders = query(tradeNo);
        boolean isRefund;
        if(orders!=null&&orders.getState().equals(1)){
            switch (OrderTypeEnum.get(orders.getTradeType())){
                case ALIPAY:
                {
                    //TODO 微信退款
                    isRefund = false;
                    throw new RuntimeException("alipay refund not impl");
                }
                case WXPAY:
                {
                    isRefund = _wxpayService.refund(orders,
                            createRefundTradeNo(OrderTypeEnum.get(orders.getTradeType()), ProducedTypeEnum.get(orders.getProductType())),
                            userId);
                    break;
                }
                default:
                    throw new RuntimeException("unknown order type");
            }

            if(isRefund){
                orders.setModifyTime(new Date());
                orders.setState(2);
                _rootRepository.updateItem(orders);
            }
        }
    }

    public void refundConfirm(Orders order){

    }

    private IPayService getPayService(OrderTypeEnum orderTypeEnum){
        IPayService payService;
        switch (orderTypeEnum){
            case ALIPAY:
            {
                payService = (IPayService)_alipayService;
                break;
            }
            case WXPAY:
            {
                payService = (IPayService)_wxpayService;
                break;
            }
            default:
                throw new RuntimeException("unknown order type");
        }
        return payService;
    }


    public List<Orders> getAllOrders(ProducedTypeEnum prodType,int page,int limit){
         return  _rootRepository.getList(new OrdersProdTypeAndPaidSpecification(prodType), page - 1, limit);
    }

    public int getAllOrdersCount(ProducedTypeEnum prodType){
        return  _rootRepository.count(new OrdersProdTypeAndPaidSpecification(prodType));
    }

    public List<Orders> getUserOrders(long userId,ProducedTypeEnum prodType,int page,int limit){
        return _rootRepository.getList(new OrdersUserIdProdTypeAndPaidSpecification(userId,prodType), page - 1, limit);
    }

    public int getUserOrdersCount(long userId,ProducedTypeEnum prodType){
        return _rootRepository.count(new OrdersUserIdProdTypeAndPaidSpecification(userId,prodType));
    }
}
