package net.bus.web.service;

import net.bus.web.model.Orders;
import net.bus.web.model.Pojo.Product;
import net.bus.web.model.Pojo.WxAsyncCallBack;
import net.bus.web.model.Pojo.WxOrderCallBack;

import java.util.Map;

/**
 * Created by Edifi_000 on 2016-10-19.
 */
public interface IWxpayService {

    WxOrderCallBack prepay(Product product,String tradeNo);

    WxAsyncCallBack async(Map<String, String> params);

    boolean refund(Orders orders,String refundTradeNo,String userId);
}
