package net.bus.web.service.impl;

import net.bus.web.model.Commodity;
import net.bus.web.model.User;
import net.bus.web.repository.CommodityRepository;
import net.bus.web.service.ICommodityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Edifi_000 on 2016-09-04.
 */
@Service
public class CommodityService implements ICommodityService{

    @Autowired
    private CommodityRepository _rootRepository;

    public List<Commodity> getAll(int page,int limit)
    {
        return _rootRepository.getAll(page - 1,limit);
    }

    public Commodity getDetails(Long id)
    {
        return _rootRepository.getItem(id);
    }

    public boolean buy(long commodity_id,User user)
    {
        //TODO add commodity_order
        return false;
    }

    public int getAllCount()
    {
        return _rootRepository.count();
    }
}
