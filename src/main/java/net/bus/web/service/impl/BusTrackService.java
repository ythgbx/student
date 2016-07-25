package net.bus.web.service.impl;

import net.bus.web.context.BusTracks;
import net.bus.web.context.BusesTracksContext;
import net.bus.web.context.Position;
import net.bus.web.context.Track;
import net.bus.web.model.Bus;
import net.bus.web.model.Line;
import net.bus.web.model.Station;
import net.bus.web.service.IBusTrackService;
import java.util.List;

/**
 * Created by Edifi_000 on 2016-07-23.
 */
public class BusTrackService implements IBusTrackService {

    public void HandlerBusPosition(Bus bus,Position position)
    {
        Track track = new Track();
        track.setPos(position);

        Station aroundStation = getBusAroundStation(bus,position);
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

    private Station getBusAroundStation(Bus bus,Position position)
    {
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
            busTracks.setDirection(getBusTracksDirection(bus,startTrack,track));
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
        BusesTracksContext.getInstance().saveBusTrack(bus.getId(),track);
    }

    private boolean checkLineEnd(Bus bus,Track track)
    {
        //TODO 取线路方向 联合当前track站点与line,判断是否为结束点
        return false;
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
        //TODO 取线路方向 联合当前track站点与line,判断是否为结束点
        return  BusTracks.Direction.Forward;
    }
}
