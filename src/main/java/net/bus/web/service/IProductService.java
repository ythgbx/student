package net.bus.web.service;

import net.bus.web.model.Pojo.AsyncCallBack;

/**
 * Created by sky on 16/10/26.
 */
public interface IProductService {
    String getOutTradeNo();
    boolean buyComplete(AsyncCallBack callBack);
}
