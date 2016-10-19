package net.bus.web.service;

import java.util.Map;

/**
 * Created by Edifi_000 on 2016-10-19.
 */
public interface IWxpayService {

    public Map<String,String> prepay(Long id);
}
