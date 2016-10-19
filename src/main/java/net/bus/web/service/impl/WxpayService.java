package net.bus.web.service.impl;

import net.bus.web.common.weixin.util.PayCommonUtil;
import net.bus.web.service.IWxpayService;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Created by Edifi_000 on 2016-10-19.
 */
@Service
public class WxpayService implements IWxpayService{

    public Map<String,String> prepay(Long id)
    {
        Map<String,String> prepayInfo = null;
        try {
            prepayInfo =  PayCommonUtil.getPrepayId("0.01", "192.168.1.110", "123456789","测试商品","");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return prepayInfo;
    }
}
