package net.bus.web.service;

import net.bus.web.context.Position;
import net.bus.web.model.Station;

import java.util.List;

/**
 * Created by Edifi_000 on 2016-07-15.
 */
public interface ILocationService {

    List<Station> getAroundStation(Position pos);
}
