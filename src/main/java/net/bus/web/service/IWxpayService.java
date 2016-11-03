package net.bus.web.service;

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
}
