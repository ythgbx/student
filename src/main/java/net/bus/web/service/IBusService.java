package net.bus.web.service;

import net.bus.web.context.BusTracks;
import net.bus.web.context.Position;
import net.bus.web.context.Track;
import net.bus.web.model.Bus;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Edifi_000 on 2016-07-20.
 */
public interface IBusService {

    void setBusesLocation(long busId,Position pos);

    HashMap<Long,Integer> getBusesCurrentTrack(long lineId,BusTracks.Direction direction);

    List<Bus> getAllBus();

    int getAllCount();

    boolean del(List<Long> longList);

    boolean addBus(Bus bus);

    boolean update(Bus bus);

    boolean bindBus(Long busId,String name,Long userId,Long lineId,String device);

    Bus getBus(String name,String device);

    Bus getBus(Long id);
}
