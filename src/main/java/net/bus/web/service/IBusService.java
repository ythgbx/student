package net.bus.web.service;

import net.bus.web.context.Position;
import net.bus.web.context.Track;

import java.util.HashMap;

/**
 * Created by Edifi_000 on 2016-07-20.
 */
public interface IBusService {

    void setBusesLocation(long busId,Position pos);

    HashMap<Long,Track> getBusesCurrentTrack(long lineId,Track.Direction direction);
}
