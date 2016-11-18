package net.bus.web.service;

import net.bus.web.enums.OrderTypeEnum;
import net.bus.web.model.Commodity;
import net.bus.web.model.Orders;
import net.bus.web.model.Pojo.OrderCallBack;
import net.bus.web.model.User;

import java.util.List;

/**
 * Created by Edifi_000 on 2016-09-04.
 */
public interface ICommodityService {

    List<Commodity> getAll(int page,int limit);

    Commodity getDetails(Long id);

    OrderCallBack buy(OrderTypeEnum orderType, long commodityId,User user);

    //boolean buyComplete(AlipayAsyncCallBack callBack);

    Boolean del(List<Long> longList);

    Boolean update(Commodity commodity);

    Boolean add(Commodity commodity);

    Boolean addType(String TypeName);

    int getAllCount();

    List<Commodity> getList(List<Long> ids);

    List<Orders> getAllOrders(int page,int limit);

    int getAllOrderCount();

    List<Orders> getUserOrders(long userId,int page,int limit);

    int getUserOrdersCount(long userId);
}
