package net.bus.web.service.impl;

import net.bus.web.context.BusTracks;
import net.bus.web.context.BusesTracksContext;
import net.bus.web.context.Position;
import net.bus.web.context.Track;
import net.bus.web.model.Bus;
import net.bus.web.model.Line;
import net.bus.web.model.LineStation;
import net.bus.web.model.Station;
import net.bus.web.service.IBusTrackService;
import net.bus.web.service.ILineService;
import net.bus.web.service.ILocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Edifi_000 on 2016-07-23.
 */
@Service
public class BusTrackService implements IBusTrackService {

    @Autowired
    private ILineService _lineService;
    @Autowired
    private ILocationService _locationService;

    public void HandlerBusPosition(Bus bus,Position position)
    {
        Track track = new Track();
        track.setPos(position);

        Station aroundStation = getBusAroundStation(bus, position);
        if(aroundStation!=null){
            track.setStation(aroundStation.getId());
        }else {
            track.setStation(null);
        }

        //处理设置track方向
        setBusTracksDirection(bus,track);

        //处理设置track状态
        track = setBusTracksStatus(bus,track);

        //根据track状态,当为start时清空原有track列表
        clearTracks(bus,track);

        End(bus,track);
    }

    public int getBusPosInLine(Bus bus,BusTracks.Direction direction)
    {
        BusTracks busTracks = BusesTracksContext.getInstance().getBusTracks(bus.getId());
        //轨迹存在检查(是否运行)
        if(busTracks==null)
            return -1;
        //运行方向检查
        if(!busTracks.getDirection().equals(direction))
            return -1;
        //轨迹记录检查(是否运行)
        if(busTracks.getTracks()==null||busTracks.getTracks().isEmpty())
            return -1;

        Track lastTrack = busTracks.getTracks().get(busTracks.getTracks().size() - 1);
        //最后点状态为起点或结束点不进行显示
        if(lastTrack.getStatus().equals(Track.Status.Start)||lastTrack.getStatus().equals(Track.Status.End))
            return -1;

        Long lastStationId;
        if(lastTrack.getStation()!=null){
            lastStationId = lastTrack.getStation();
        }else{
            lastStationId = busTracks.getTracks().get(busTracks.getTracks().size() - 2).getStation();
        }
        int posInLine = 0;
        List<LineStation> lineStations =  _lineService.getLineStations(bus.getLineId());
        if(busTracks.getDirection().equals(BusTracks.Direction.Forward)){
            for(int i=0;i<lineStations.size();i++){
                if(lineStations.get(i).getStationId().equals(lastStationId)){
                    posInLine = (i + 1) * 2 - 1;
                }
            }
        }else{
            posInLine = (lineStations.size() * 2 - posInLine);
        }

        if(lastTrack.getStatus().equals(Track.Status.Goto)){
            posInLine = posInLine + 1;
        }

        return posInLine;
    }

    private Station getBusAroundStation(Bus bus,Position position)
    {
        List<Station> aroundStations = _locationService.getAroundStation(position);
        if(aroundStations.size()>0){
            return aroundStations.get(0);
        }
        return null;
    }

    private void setBusTracksDirection(Bus bus,Track track)
    {
        if(track.getStation().equals(null)){
            return;
        }

        BusTracks busTracks = BusesTracksContext.getInstance().getBusTracks(bus.getId());
        if(busTracks.getDirection().equals(null)){
            List<Track> tracks = busTracks.getTracks();
            if(tracks.size()==0){
                return;
            }

            //根据line与轨迹开始点与当前track,设置方向
            Track startTrack = tracks.get(0);
            busTracks.setDirection(getBusTracksDirection(bus, startTrack, track));

            //根据当前轨迹与最后记录轨迹计算车辆角度
            Track lastTracks = tracks.get(tracks.size()-1);
            busTracks.setAngle(getBusTracksAngle(lastTracks,track));
        }
    }

    private Track setBusTracksStatus(Bus bus,Track track)
    {
        BusTracks busTracks = BusesTracksContext.getInstance().getBusTracks(bus.getId());
        if(busTracks.getTracks().size()==0){
            track.setStatus(Track.Status.Start);
            return  track;
        }

        List<Track> tracks = busTracks.getTracks();
        Track lastTrack = tracks.get(tracks.size() - 1);

        if(lastTrack.getStatus().equals(Track.Status.End)){
            track.setStatus(Track.Status.Start);
        }else{
            if(isTrackArriveStation(track)){
                if(!checkLineEnd(bus,track)){
                    track.setStatus(Track.Status.Arrive);
                }else{
                    track.setStatus(Track.Status.End);
                }
            }else{
                track.setStatus(Track.Status.Goto);
            }
        }

        return  track;
    }

    private void End(Bus bus,Track track)
    {
        BusesTracksContext.getInstance().saveBusTrack(bus,track);
    }

    private boolean checkLineEnd(Bus bus,Track track)
    {
        //联合当前track站点与line,判断是否为结束点
        BusTracks busTracks = BusesTracksContext.getInstance().getBusTracks(bus.getId());
        //TODO 由于频繁调用获取getLineStations需要进行缓存
        List<LineStation> lineStations =  _lineService.getLineStations(bus.getLineId());
        Long lineEndStationId;
        if(busTracks.getDirection().equals(BusTracks.Direction.Forward)){
            lineEndStationId = lineStations.get(0).getStationId();
        }else{
            lineEndStationId = lineStations.get(lineStations.size()-1).getStationId();

        }

        if(lineEndStationId.equals(track.getStation())){
            return true;
        }else{
            return false;
        }
    }

    private boolean clearTracks(Bus bus,Track track)
    {
        BusTracks busTracks = BusesTracksContext.getInstance().getBusTracks(bus.getId());
        if(track.getStatus().equals(Track.Status.Start)){
            busTracks.getTracks().clear();
            busTracks.setDirection(null);
            return true;
        }
        return false;
    }

    private boolean isTrackArriveStation(Track track)
    {
        if(track.getStation().equals(null)){
             return false;
        }
        return true;
    }

    private BusTracks.Direction getBusTracksDirection(Bus bus,Track startTrack,Track currentTrack)
    {
        //TODO 由于频繁调用获取getLineStations需要进行缓存
        List<LineStation> lineStations =  _lineService.getLineStations(bus.getLineId());
        int startIndex = -1;
        int currentIndex = -1;
        for(LineStation lineStation:lineStations){
            if(lineStation.getStationId().equals(startTrack.getStation())){
                startIndex = lineStation.getIndex();
            }

            if(lineStation.getStationId().equals(currentTrack.getStation())){
                currentIndex = lineStation.getIndex();
            }
        }

        if(startIndex<currentIndex){
            return  BusTracks.Direction.Forward;
        }else{
            return  BusTracks.Direction.Reverse;
        }
    }

    private Double getBusTracksAngle(Track lastTrack,Track currentTrack)
    {
        double dRotateAngle = Math.atan2(Math.abs(lastTrack.getPos().getLat() - currentTrack.getPos().getLat()), Math.abs(lastTrack.getPos().getLng() - currentTrack.getPos().getLng()));
        if (currentTrack.getPos().getLat() >= lastTrack.getPos().getLat())
        {
            if (currentTrack.getPos().getLng() >= lastTrack.getPos().getLng()){
            }else{
                dRotateAngle = Math.PI - dRotateAngle;
            }
        }else{
            if (currentTrack.getPos().getLng() >= lastTrack.getPos().getLng()){
                dRotateAngle = 2 * Math.PI - dRotateAngle;
            }else{
                dRotateAngle = Math.PI + dRotateAngle;
            }
        }
        dRotateAngle = dRotateAngle * 180 / Math.PI;
        return dRotateAngle;
    }
}
