package net.bus.web.service.impl;

import net.bus.web.model.LineStation;
import net.bus.web.model.Line;
import net.bus.web.model.Station;
import net.bus.web.repository.LineStationRepository;
import net.bus.web.repository.StationRepository;
import net.bus.web.repository.specification.LineStationLineIdsSpecification;
import net.bus.web.repository.specification.StationIdsSpecification;
import net.bus.web.service.ILineService;
import net.bus.web.service.IStationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Edifi_000 on 2016-07-27.
 */
@Service
public class StationService implements IStationService {

    @Autowired
    private StationRepository _rootRepository;
    @Autowired
    private ILineService _lineService;
    @Autowired
    private LineStationRepository _lineStationRepository;

    public List<Station> getAllStations()
    {
        return  _rootRepository.getAll();
    }

    public List<Station> getAllStations(int page,int limit)
    {
        return  _rootRepository.getAll(page-1 , limit);
    }

    public List<Station> getPropStations(String propName)
    {
        List<Line> lines = _lineService.getPropLines(propName, 0, _lineService.getPropLinesCount(propName));
        List<Long> stationIds = new ArrayList<Long>();
        for (Line line : lines) {
            for(net.bus.web.model.LineStation lineStation:_lineService.getLineStations(line.getId())){
                stationIds.add(lineStation.getId());
            }
        }
        return  _rootRepository.getList(new StationIdsSpecification(stationIds));
    }

    public List<Station> getStations(List<Long> ids)
    {
        return  _rootRepository.getList(new StationIdsSpecification(ids));
    }

    public List<LineStation> getLineStations(Long id) {
        List<Long> lineIds = new ArrayList<Long>();
        lineIds.add(id);
       List<LineStation> lineStations= _lineStationRepository.getList(new LineStationLineIdsSpecification(lineIds));
        return lineStations;
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

    public boolean addLineStation(LineStation lineStation){
        if(_lineStationRepository.insertItem(lineStation)>0){
            return  true;
        }
        return false;
    }

    public Boolean del(List<Long> longList) {
        StationIdsSpecification Specification = new StationIdsSpecification(longList);
        int result ;
        if (longList.size()==1){
            result = _rootRepository.delete(longList.get(0));
        }else {
            result = _rootRepository.delete(Specification);
        }
        if(result  > 0){
            return true;
        }
        return false;
    }

    public Station getDetails(Long id) {
        return _rootRepository.getItem(id);
    }

    public boolean updateStation(Station station) {
        if (_rootRepository.updateItem(station)>0){
            return true;
        }
        return false;
    }
}
