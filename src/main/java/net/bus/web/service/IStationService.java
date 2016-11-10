package net.bus.web.service;

import net.bus.web.model.Station;

import java.util.List;

/**
 * Created by Edifi_000 on 2016-07-27.
 */
public interface IStationService {

    List<Station> getAllStations();

    List<Station> getAllStations(int page,int limit);

    List<Station> getPropStations(String propName);

    List<Station> getStations(List<Long> ids);

    int getAllStationsCount();

    boolean addStation(Station station);

    Boolean del(List<Long> longList);

    Station getDetails(Long id);

    boolean updateStation(Station station);
}
