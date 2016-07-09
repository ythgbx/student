package net.bus.web.service.impl;

import net.bus.web.model.Line;
import net.bus.web.repository.LineRepository;
import net.bus.web.service.ILineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Edifi_000 on 2016-07-04.
 */

@Service
public class LineService implements ILineService {

    @Autowired
    private LineRepository _rootRepository;

    public List<Line> getAroundLines(double lat,double lng,int page,int limit)
    {
        //TODO Select Around Lines by lat and lng
        return _rootRepository.getAll();
    }

    public List<Line> getUserLines(Long userid,int page,int limit)
    {
        //TODO Select User Lines
        return _rootRepository.getAll();
    }

    public List<Line> getStationLines(String station_name,int page,int limit)
    {
        //TODO Select lines by station name
        return _rootRepository.getAll();
    }

    public List<Line> getAllLines(int page,int limit)
    {
        //TODO Select All Lines
        return _rootRepository.getAll();
    }

    public Line getLineDetails(Long id)
    {
        //TODO Select line by id
        return _rootRepository.getItem(id);
    }
}
