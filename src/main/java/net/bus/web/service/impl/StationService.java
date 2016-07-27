package net.bus.web.service.impl;

import net.bus.web.model.Station;
import net.bus.web.repository.StationRepository;
import net.bus.web.service.IStationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Edifi_000 on 2016-07-27.
 */
@Service
public class StationService implements IStationService {

    @Autowired
    private StationRepository _rootRepository;

    public List<Station> getAllStations()
    {
        return  _rootRepository.getAll();
    }

    public List<Station> getAllStations(int page,int limit)
    {
        return  _rootRepository.getAll(page-1,limit);
    }

    public int getAllStationsCount()
    {
        return _rootRepository.count();
    }

    public boolean addStation(Station station)
    {
        int result = _rootRepository.insertItem(station);

        if(result>0){
            return true;
        }
        return false;
    }
}
