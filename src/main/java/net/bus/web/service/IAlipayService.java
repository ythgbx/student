package net.bus.web.service;

import net.bus.web.context.AlipayCallBack;

import java.util.Map;

/**
 * Created by Edifi_000 on 2016-09-08.
 */
public interface IAlipayService {

    String sign(String tradeNo, String subject, String body, String price);

    boolean async(Map<String, String> params);

    boolean ret(String prestr,Map<String, String> params);


}
