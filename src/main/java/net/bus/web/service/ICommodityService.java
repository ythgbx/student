package net.bus.web.service;

import net.bus.web.model.Commodity;
import net.bus.web.model.User;

import java.util.List;

/**
 * Created by Edifi_000 on 2016-09-04.
 */
public interface ICommodityService {

    List<Commodity> getAll(int page,int limit);

    Commodity getDetails(Long id);

    boolean buy(long commodity_id,User user);

    int getAllCount();
}
