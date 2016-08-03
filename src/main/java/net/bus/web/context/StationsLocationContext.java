package net.bus.web.context;

import ch.hsr.geohash.GeoHash;
import net.bus.web.model.Station;
import net.bus.web.service.IStationService;
import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Edifi_000 on 2016-07-15.
 */
public class StationsLocationContext {

    private static StationsLocationContext _instance;

    private Cache _cache = null;
    private CacheManager _cacheManager = null;

    private IStationService _stationService;

    public static StationsLocationContext getInstance(IStationService stationService) {

        if (_instance == null) {
            synchronized (StationsLocationContext.class) {
                if (_instance == null) {
                    _instance = new StationsLocationContext(stationService);
                }
            }
        }
        return _instance;
    }

    private StationsLocationContext(IStationService stationService)
    {
        _stationService = stationService;
        _cacheManager = CacheManager.create();
        _cache=_cacheManager.getCache("stationCache");
        InitStationsLocation();
    }
    public void InitStationsLocation()
    {
        //Add stations location to ehcache 1.key is GeoHash value 2.value is List of Station
        List<Station> stationList = _stationService.getAllStations();
        int hashLength = 9;
        String key;
        GeoHash geoHash;
        List<Station> meList;
        for(Station station:stationList){
            geoHash = GeoHash.withCharacterPrecision(station.getLat(), station.getLng(), hashLength);
            key = geoHash.toBase32();
            if(_cache.isElementInMemory(key)&& _cache.get(key)!=null){
                meList = (List<Station>) _cache.get(key).getObjectValue();

            }else{
                meList = new ArrayList<Station>();
            }
            meList.add(station);
            Element element = new Element(key, meList);
            _cache.put(element);
        }
    }

    public List<Station> getStationsByGeoHashCode(List<String> geoHashCodes)
    {
        //Get Station list collection which the key is geoHashCode(base32Code) that in List
//        List<Station> stationList = new ArrayList<Station>();
//        for(String geoCode:geoHashCodes){
//            if(_cache.isElementInMemory(geoCode)){
//                List<Station> meList = (List<Station>) _cache.get(geoCode).getObjectValue();
//                stationList.addAll(meList);
//            }
//        }

        List<Station> result = new ArrayList<Station>();
        List keys =_cache.getKeys();
        for(Object key:keys){
            for(String geoCode:geoHashCodes){
                if(key.toString().startsWith(geoCode)){
                    List<Station> meList = (List<Station>) _cache.get(key).getObjectValue();
                    result.addAll(meList);
                }
            }
        }
        return result;
    }
}
