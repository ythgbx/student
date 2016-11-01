package net.bus.web.service;

import net.bus.web.context.AlipayCallBack;
import net.bus.web.model.Commodity;
import net.bus.web.model.CommodityOrder;
import net.bus.web.model.User;

import java.util.List;

/**
 * Created by Edifi_000 on 2016-09-04.
 */
public interface ICommodityService {

    List<Commodity> getAll(int page,int limit);

    Commodity getDetails(Long id);

    String buy(long commodityId,User user);

    boolean buyComplete(AlipayCallBack callBack);

    int getAllCount();

    int getAllOrderCount();

    List<Commodity> getList(List<Long> ids);

    List<CommodityOrder> getUserOrders(long userId,int page,int limit);

    List<CommodityOrder> getAllOrers(int page,int limit);

    int getUserOrdersCount(long userId);
}
