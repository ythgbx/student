package net.bus.web.service;

import java.util.Map;

/**
 * Created by Edifi_000 on 2016-10-19.
 */
public interface IWxpayService {

    Map<String,String> prepay(Long id);

    boolean async(Map<String, String> params);
}
