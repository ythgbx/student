package net.bus.web.service;

import net.bus.web.context.BusTracks;
import net.bus.web.context.Position;
import net.bus.web.context.Track;
import net.bus.web.model.Bus;

import java.util.HashMap;

/**
 * Created by Edifi_000 on 2016-07-20.
 */
public interface IBusService {

    void setBusesLocation(long busId,Position pos);

    HashMap<Long,Integer> getBusesCurrentTrack(long lineId,BusTracks.Direction direction);

    boolean addBus(Bus bus);

    boolean bindBus(Long busId,String name,Long userId,Long lineId,String device);

    Bus getBus(String name,String device);
}
