package net.bus.web.service;

import net.bus.web.model.Pojo.AlipayOrderCallBack;
import net.bus.web.model.Pojo.Product;

import java.util.Map;

/**
 * Created by Edifi_000 on 2016-09-08.
 */
public interface IAlipayService {

    String sign(String tradeNo, String subject, String body, String price);

    AlipayOrderCallBack sign(Product product,String tradeNo);

    boolean async(Map<String, String> params);

    boolean ret(String prestr,Map<String, String> params);


}
