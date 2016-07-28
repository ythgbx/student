package net.bus.web.service.impl;

import net.bus.web.context.Position;
import net.bus.web.model.Line;
import net.bus.web.model.LineStation;
import net.bus.web.model.Station;
import net.bus.web.model.UserLine;
import net.bus.web.repository.LineRepository;
import net.bus.web.repository.LineStationRepository;
import net.bus.web.repository.StationRepository;
import net.bus.web.repository.UserLineRepository;
import net.bus.web.repository.specification.*;
import net.bus.web.service.ILineService;
import net.bus.web.service.ILocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Edifi_000 on 2016-07-04.
 */

@Service
public class LineService implements ILineService {

    @Autowired
    private LineRepository _rootRepository;
    @Autowired
    private UserLineRepository _userLineRepository;
    @Autowired
    private StationRepository _stationRepository;
    @Autowired
    private LineStationRepository _lineStationRepository;

    @Autowired
    private ILocationService _locationService;

    public List<Line> getAroundLines(double lat,double lng,int page,int limit)
    {
        List<Station> listStation =  _locationService.getAroundStation(new Position(lat, lng));
        List<Long> listStationIds = new ArrayList<Long>();
        for (Station station : listStation) {
            listStationIds.add(station.getId());
        }
        List<LineStation> listLineStation = _lineStationRepository.getList(new LineStationStationIdsSpecification(listStationIds));
        List<Long> listLineIds = new ArrayList<Long>();
        for (LineStation lineStation : listLineStation) {
            listLineIds.add(lineStation.getLineId());
        }
        return _rootRepository.getList(new LineIdsSpecification(listLineIds), page - 1, limit);
    }

    public List<Line> getUserLines(Long userId,int page,int limit)
    {
        List<UserLine> listUserLine =  _userLineRepository.getList(new UserLineUserIdSpecification(userId));
        List<Long> listLineIds = new ArrayList<Long>();
        for (UserLine userLine : listUserLine) {
            listLineIds.add(userLine.getLineId());
        }

        return _rootRepository.getList(new LineIdsSpecification(listLineIds), page - 1, limit);
    }

    public List<Line> getStationLines(String station_name,int page,int limit)
    {
        List<Station> listStation =  _stationRepository.getList(new StationNameSpecification(station_name));
        List<Long> listStationIds = new ArrayList<Long>();
        for (Station station : listStation) {
            listStationIds.add(station.getId());
        }
        List<LineStation> listLineStation = _lineStationRepository.getList(new LineStationStationIdsSpecification(listStationIds));
        List<Long> listLineIds = new ArrayList<Long>();
        for (LineStation lineStation : listLineStation) {
            listLineIds.add(lineStation.getLineId());
        }
        return _rootRepository.getList(new LineIdsSpecification(listLineIds), page - 1, limit);
    }

    public List<Line> getAllLines(int page,int limit)
    {
        return _rootRepository.getAll(page - 1, limit);
    }

    public Line getLineDetails(Long id)
    {
        return _rootRepository.getItem(id);
    }

    public List<LineStation> getLineStations(Long id)
    {
        List<Long> lineIds = new ArrayList<Long>();
        lineIds.add(id);
        List<LineStation> listLineStation = _lineStationRepository.getList(new LineStationLineIdsSpecification(lineIds));
        return listLineStation;
    }

    public boolean checkLineExist(Long id){
        List<Long> ids = new ArrayList<Long>();
        ids.add(id);
        return  _rootRepository.existItem(new LineIdsSpecification(ids));
    }

    public int getAroundLinesCount(double lat,double lng)
    {
        List<Station> listStation =  _locationService.getAroundStation(new Position(lat, lng));
        List<Long> listStationIds = new ArrayList<Long>();
        for (Station station : listStation) {
            listStationIds.add(station.getId());
        }
        List<LineStation> listLineStation = _lineStationRepository.getList(new LineStationStationIdsSpecification(listStationIds));
        List<Long> listLineIds = new ArrayList<Long>();
        for (LineStation lineStation : listLineStation) {
            listLineIds.add(lineStation.getLineId());
        }

        return  _rootRepository.count(new LineIdsSpecification(listLineIds));
    }

    public int getUserLinesCount(Long userId)
    {
        List<UserLine> listUserLine =  _userLineRepository.getList(new UserLineUserIdSpecification(userId));
        List<Long> listLineIds = new ArrayList<Long>();
        for (UserLine userLine : listUserLine) {
            listLineIds.add(userLine.getLineId());
        }
        return  _rootRepository.count(new LineIdsSpecification(listLineIds));
    }

    public int getStationLinesCount(String station_name)
    {
        List<Station> listStation =  _stationRepository.getList(new StationNameSpecification(station_name));
        List<Long> listStationIds = new ArrayList<Long>();
        for (Station station : listStation) {
            listStationIds.add(station.getId());
        }
        List<LineStation> listLineStation = _lineStationRepository.getList(new LineStationStationIdsSpecification(listStationIds));
        List<Long> listLineIds = new ArrayList<Long>();
        for (LineStation lineStation : listLineStation) {
            listLineIds.add(lineStation.getLineId());
        }
        return  _rootRepository.count(new LineIdsSpecification(listLineIds));
    }

    public int getAllLinesCount()
    {
        return _rootRepository.count();
    }

    public boolean addLine(Line line,List<Long> stationIds)
    {
        int result = _rootRepository.insertItem(line);

        for(int i=0;i<stationIds.size();i++)
        {
            LineStation lineStation = new LineStation();
            lineStation.setLineId(line.getId());
            lineStation.setStationId(stationIds.get(i));
            lineStation.setIndex(i);
            _lineStationRepository.insertItem(lineStation);
        }

        if(result>0){
            return true;
        }
        return false;
    }
}
