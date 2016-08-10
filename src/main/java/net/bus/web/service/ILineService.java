package net.bus.web.service;

import net.bus.web.model.Line;
import net.bus.web.model.LineStation;
import net.bus.web.model.Station;

import java.util.List;

/**
 * Created by Edifi_000 on 2016-07-07.
 */
public interface ILineService {

    List<Line> getAroundLines(double lat,double lng,int page,int limit);

    List<Line> getUserLines(Long userId,int page,int limit);

    List<Line> getUserLines(Long userId,String cityName,int page,int limit);

    List<Line> getStationLines(String station_name,int page,int limit);

    List<Line> getAllLines(int page,int limit);

    List<Line> getCityLines(String cityName, int page,int limit);

    Line getLineDetails(Long id);

    List<LineStation> getLineStations(Long id);

    boolean checkLineExist(Long id);

    int getAroundLinesCount(double lat,double lng);

    int getUserLinesCount(Long userId);

    int getUserLinesCount(Long userId,String cityName);

    int getStationLinesCount(String stationName);

    int getAllLinesCount();

    int getCityLinesCount(String cityName);

    boolean addLine(Line line,List<Long> stationIds);
}
