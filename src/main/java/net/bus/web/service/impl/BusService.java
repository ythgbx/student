package net.bus.web.service.impl;

import net.bus.web.context.BusTracks;
import net.bus.web.context.Position;
import net.bus.web.context.Track;
import net.bus.web.model.Bus;
import net.bus.web.model.Line;
import net.bus.web.repository.BusRepository;
import net.bus.web.repository.LineRepository;
import net.bus.web.repository.UserRepository;
import net.bus.web.repository.specification.*;
import net.bus.web.service.IBusService;
import net.bus.web.service.IBusTrackService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    @Autowired
    private UserRepository _userRepository;
    @Autowired
    private LineRepository _lineRepository;

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


    public List<Bus> getAllBus(int page,int limit) {
        return _rootRepository.getAll(page-1,limit);
    }

    public int getAllCount() {
        return _rootRepository.count();
    }

    public boolean del(List<Long> longList) {
        BusIdSpecification Specification = new BusIdSpecification(longList);
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

    public boolean addBus(Bus bus)
    {
        //TODO addBus
        _rootRepository.insertItem(bus);
        return true;
    }

    public boolean update(Bus bus) {
        if (_rootRepository.updateItem(bus)>0){
            return true;
        }
        return false;
    }

    public boolean bindBus(Long busId,String name,Long userId,Long lineId,String device)
    {
        //TODO bindLine
        Bus bus = null;
        if(busId!=null&&busId>0){
            bus = _rootRepository.getItem(busId);
        }

        if(bus==null&&!StringUtils.isBlank(name)){
            bus = _rootRepository.getItem(new BusNameSpecification(name));
        }

        if(bus!=null){
            boolean change = false;
            List<Long> userIds = new ArrayList<Long>();
            userIds.add(userId);
            if(_userRepository.getUser(new UserIdsSpecification(userIds))!=null){
                bus.setUserId(userId);
                if(!change)
                    change = true;
            }

            List<Long> lineIds = new ArrayList<Long>();
            lineIds.add(lineId);
            if(_lineRepository.existItem(new LineIdsSpecification(lineIds))){
                bus.setLineId(lineId);
                if(!change)
                    change = true;
            }

            if(!StringUtils.isBlank(device)){
                bus.setDevice(device);
                if(!change)
                    change = true;
            }

            if(change){
                _rootRepository.updateItem(bus);
                return true;
            }
        }

        return false;
    }

    public Bus getBus(String name,String device)
    {
        Bus bus = null;
        if(!StringUtils.isBlank(name)){
            bus = _rootRepository.getItem(new BusNameSpecification(name));
        }

        if(bus==null&&!StringUtils.isBlank(device)){
            bus = _rootRepository.getItem(new BusDeviceSpecification(device));
        }

        return bus;
    }

    public Bus getBus(Long id) {
        return _rootRepository.getItem(id);
    }
}
