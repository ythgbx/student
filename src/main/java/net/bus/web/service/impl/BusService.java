package net.bus.web.service.impl;

import net.bus.web.context.BusTracks;
import net.bus.web.context.Position;
import net.bus.web.context.Track;
import net.bus.web.service.IBusService;

import java.util.HashMap;

/**
 * Created by Edifi_000 on 2016-07-21.
 */
public class BusService  implements IBusService {

    public void setBusesLocation(long busId,Position pos)
    {
        //TODO Get Bus and bus's tracks

        //TODO Get last two track . If last track is 'goto' get it ,but use line id get station list and last two track to judge which the next

        //TODO Whether arrive the last
    }

    public HashMap<Long,Track> getBusesCurrentTrack(long lineId,BusTracks.Direction direction)
    {
        //TODO Get this direction buses in line

        //TODO Get their track
        return null;
    }
}
