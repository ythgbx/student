package net.bus.web.service.impl;

import net.bus.web.context.BusTracks;
import net.bus.web.context.Position;
import net.bus.web.context.Track;
import net.bus.web.model.Bus;
import net.bus.web.repository.BusRepository;
import net.bus.web.repository.specification.BusLineIdSpecification;
import net.bus.web.service.IBusService;
import net.bus.web.service.IBusTrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Edifi_000 on 2016-07-21.
 */
@Service
public class BusService  implements IBusService {

    @Autowired
    private BusRepository _rootRepository;
    @Autowired
    private IBusTrackService _busTrackService;

    public void setBusesLocation(long busId,Position pos)
    {
        //TODO 由于频繁调用获取getItem需要进行缓存
        Bus bus = _rootRepository.getItem(busId);
        if(bus!=null){
            _busTrackService.HandlerBusPosition(bus,pos);
        }
    }

    public HashMap<Long,Integer> getBusesCurrentTrack(long lineId,BusTracks.Direction direction)
    {
        //TODO 获取线路下有效运行车辆,在线路中位置(中间间隔算1)
        //获取线路下车辆
        List<Bus> buses = _rootRepository.getList(new BusLineIdSpecification(lineId));

        HashMap<Long,Integer> result = new HashMap<Long,Integer>();
        for(Bus bus:buses){
            Integer posInLine = _busTrackService.getBusPosInLine(bus,direction);
            if(posInLine.equals(-1))
                continue;

            result.put(bus.getId(), posInLine);
        }
        return result;
    }
}
