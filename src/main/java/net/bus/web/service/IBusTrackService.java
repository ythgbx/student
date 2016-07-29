package net.bus.web.service;

import net.bus.web.context.BusTracks;
import net.bus.web.context.Position;
import net.bus.web.model.Bus;

import java.util.logging.Handler;

/**
 * Created by Edifi_000 on 2016-07-23.
 */
public interface IBusTrackService {

    void HandlerBusPosition(Bus bus,Position position);

    int getBusPosInLine(Bus bus,BusTracks.Direction direction);
}
