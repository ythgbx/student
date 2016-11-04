package net.bus.web.service;

import net.bus.web.model.Pojo.AlipayAsyncCallBack;

/**
 * Created by sky on 16/10/26.
 */
public interface IPayService {
    public String getOutTradeNo();
    public boolean buyComplete(AlipayAsyncCallBack callBack);
}
