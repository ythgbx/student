package net.bus.web.service.impl;

import net.bus.web.context.Position;
import net.bus.web.model.Line;
import net.bus.web.model.LineStation;
import net.bus.web.model.Station;
import net.bus.web.model.UserLine;
import net.bus.web.repository.*;
import net.bus.web.repository.specification.*;
import net.bus.web.service.ILineService;
import net.bus.web.service.ILocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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

    public List<Line> getUserLines(Long userId,String cityName,int page,int limit)
    {
        List<UserLine> listUserLine =  _userLineRepository.getList(new UserLineUserIdSpecification(userId));
        List<Long> listLineIds = new ArrayList<Long>();
        for (UserLine userLine : listUserLine) {
            listLineIds.add(userLine.getLineId());
        }

        return _rootRepository.getList(new LineIdsCityNameSpecification(listLineIds, cityName), page - 1, limit);
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

    public List<Line> getAllLines(String lineName, int page, int limit) {
        if(lineName.equals("")){
            return _rootRepository.getAll(page - 1, limit);
        }else {
            return _rootRepository.getAllByLineName(new LineNamesSpecification(lineName),page-1,limit);
        }

    }

    public List<Line> getAllLines(int page,int limit)
    {
        return _rootRepository.getAll(page - 1, limit);
    }

    public List<Line> getCityLines(String city_name, int page,int limit)
    {
        List<String> listCityNames = new ArrayList<String>();
        listCityNames.add(city_name);
        return _rootRepository.getList(new LineCityNamesSpecification(listCityNames), page - 1, limit);
    }

    public List<Line> getPropLines(String prop_name, int page,int limit)
    {
        List<String> listPropNames = new ArrayList<String>();
        listPropNames.add(prop_name);
        return _rootRepository.getList(new LinePropNamesSpecification(listPropNames), page - 1, limit);
    }

    public Line getLineDetails(Long id)
    {
        return _rootRepository.getItem(id);
    }

    public List<LineStation> getLineStations(Long id,int page,int limit)
    {
        List<Long> lineIds = new ArrayList<Long>();
        lineIds.add(id);
        List<LineStation> listLineStation = _lineStationRepository.getList(new LineStationLineIdsSpecification(lineIds), page, limit);
        return listLineStation;
    }
    public List<LineStation> getLineStations(Long id)
    {
        List<Long> lineIds = new ArrayList<Long>();
        lineIds.add(id);
        List<LineStation> listLineStation = _lineStationRepository.getList(new LineStationLineIdsSpecification(lineIds));
        return listLineStation;
    }

    public List<Station> getStationList(Long id)
    {
        final List<LineStation> listLineStation = getLineStations(id);
        List<Long> stationIds = new ArrayList<Long>();
        for(LineStation lineStation:listLineStation){
            stationIds.add(lineStation.getStationId());
        }
        List<Station> stationList = _stationRepository.getList(new StationIdsSpecification(stationIds));
        Collections.sort(stationList, new Comparator<Station>() {
            //@Override
            public int compare(Station s1, Station s2) {
                Integer indexS1 = getLineStationIndex(listLineStation, s1);
                Integer indexS2 = getLineStationIndex(listLineStation, s2);
                return indexS1.compareTo(indexS2);
            }
        });
        return stationList;
    }
    public List<Station> getStationList(Long id,int page,int limit)
    {
        final List<LineStation> listLineStation = getLineStations(id);
        List<Long> stationIds = new ArrayList<Long>();
        for(LineStation lineStation:listLineStation){
            stationIds.add(lineStation.getStationId());
        }
        List<Station> stationList = _stationRepository.getList(new StationIdsSpecification(stationIds), page-1,limit);
        Collections.sort(stationList, new Comparator<Station>() {
            //@Override
            public int compare(Station s1, Station s2) {
                Integer indexS1 = getLineStationIndex(listLineStation, s1);
                Integer indexS2 = getLineStationIndex(listLineStation, s2);
                return indexS1.compareTo(indexS2);
            }
        });
        return stationList;
    }

    public boolean checkLineExist(Long id){
        List<Long> ids = new ArrayList<Long>();
        ids.add(id);
        return  _rootRepository.existItem(new LineIdsSpecification(ids));
    }

    public int getStationLinesCount(Long id) {
        return getLineStations(id).size();
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

    public int getUserLinesCount(Long userId,String cityName)
    {
        List<UserLine> listUserLine =  _userLineRepository.getList(new UserLineUserIdSpecification(userId));
        List<Long> listLineIds = new ArrayList<Long>();
        for (UserLine userLine : listUserLine) {
            listLineIds.add(userLine.getLineId());
        }
        return  _rootRepository.count(new LineIdsCityNameSpecification(listLineIds,cityName));
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


    public int getCityLinesCount(String city_name)
    {
        List<String> listCityNames = new ArrayList<String>();
        listCityNames.add(city_name);
        return  _rootRepository.count(new LineCityNamesSpecification(listCityNames));
    }

    public int getPropLinesCount(String prop_name)
    {
        List<String> listPropNames = new ArrayList<String>();
        listPropNames.add(prop_name);
        return  _rootRepository.count(new LinePropNamesSpecification(listPropNames));
    }

    @Transactional
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

    public boolean addLine(Line line){
        if(_rootRepository.insertItem(line)>0){
            return true;
        }
        return false;
    }

    public boolean del(Long id) {
        if(_rootRepository.del(id)>0){
          return true;
        }
        return false;
    }

    public boolean del(List<Long> ids) {
        LineIdsSpecification lineIdsSpecification=new LineIdsSpecification(ids);
        int result;
        if(ids.size()==1){
            result=_rootRepository.del(ids.get(0));
        }else{
            result = _rootRepository.del( lineIdsSpecification);
        }
        if(result>0){
            return true;
        }
        return false;
    }

    public boolean updateline(Line line) {
       if(_rootRepository.updateItem(line)>0){
           return  true;
       }
        return false;
    }


    private int getLineStationIndex(List<LineStation> lineStations,Station station)
    {
        for(LineStation lineStation:lineStations){
            if(lineStation.getStationId().equals(station.getId())){
                return lineStation.getIndex();
            }
        }
        return 999;
    }
}
