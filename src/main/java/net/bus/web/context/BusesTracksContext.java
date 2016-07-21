package net.bus.web.context;

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

    private Cache _cache = null;;
    private CacheManager _cacheManager = null;

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

    public void saveBusTrack(Long busId,Track track)
    {
        String key = _headKey+busId;
        List<Track> tracks;
        if(_cache.isElementInMemory(key)){
            tracks  = (List<Track>)_cache.get(key).getObjectValue();
        }else{
            tracks = new ArrayList<Track>();
        }
        if(!tracks.contains(track)){
            tracks.add(track);
        }

        Element element = new Element(key, tracks);
        _cache.put(element);
    }

    public List<Track> getBusTracks(Long busId)
    {
        String key = _headKey+busId;
        if(_cache.isElementInMemory(key)){
            return  (List<Track>)_cache.get(key).getObjectValue();
        }

        return null;
    }
}
