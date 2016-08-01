package net.bus.web.context;

import ch.hsr.geohash.GeoHash;
import net.bus.web.model.Bus;
import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Edifi_000 on 2016-07-15.
 */
public class BusesTracksContext {

    private String _headKey = "BusesTracks-";

    private static BusesTracksContext _instance;

    private Cache _cache = null;
    private CacheManager _cacheManager = null;

    private final int HASH_LENGTH = 9;

    public static BusesTracksContext getInstance() {

        if (_instance == null) {
            synchronized (BusesTracksContext.class) {
                if (_instance == null) {
                    _instance = new BusesTracksContext();
                }
            }
        }
        return _instance;
    }

    private BusesTracksContext()
    {
        _cacheManager = CacheManager.create();
        _cache=_cacheManager.getCache("busCache");
    }

    public void saveBusTrack(Bus bus,Track track)
    {
        String key = _headKey+bus.getId();
        BusTracks busTracks;
        if(_cache.isElementInMemory(key)){
            busTracks = (BusTracks)_cache.get(key).getObjectValue();
        }else{
            busTracks = new BusTracks();
            busTracks.setTracks(new ArrayList<Track>());
        }
        if(!busTracks.getTracks().contains(track)){
            busTracks.getTracks().add(track);
        }

        GeoHash geoHash = GeoHash.withCharacterPrecision(track.getPos().getLat(), track.getPos().getLng(), HASH_LENGTH);
        busTracks.setLastGeoHashCodes(geoHash.toBase32());
        bus.setLat(track.getPos().getLat());
        bus.setLng(track.getPos().getLng());
        busTracks.setBus(bus);

        Element element = new Element(key, busTracks);
        _cache.put(element);
    }

    public BusTracks getBusTracks(Long busId)
    {
        String key = _headKey+busId;
        if(_cache.isElementInMemory(key)){
            return  (BusTracks)_cache.get(key).getObjectValue();
        }

        return null;
    }

    public List<Bus> getBusesByGeoHashCodes(List<String> geoHashCodes)
    {
        List<Bus> result = new ArrayList<Bus>();
        List keys =_cache.getKeys();
        for(Object key:keys){
            BusTracks busTracks = (BusTracks)_cache.get(key).getObjectValue();
            for(String geoCode:geoHashCodes){
                if(busTracks.getLastGeoHashCodes().startsWith(geoCode)){
                    result.add(busTracks.getBus());
                }
            }
        }

        return result;
    }
}
