package net.bus.web.context;

import net.bus.web.model.Station;

import java.util.List;

/**
 * Created by Edifi_000 on 2016-07-15.
 */
public class StationsLocationContext {

    private static StationsLocationContext _instance;

    public static StationsLocationContext getInstance() {

        if (_instance == null) {
            synchronized (StationsLocationContext.class) {
                if (_instance == null) {
                    _instance = new StationsLocationContext();
                }
            }
        }
        return _instance;
    }

    private StationsLocationContext()
    {
        InitStationsLocation();
    }
    public static void InitStationsLocation()
    {
        //TODO Add stations location to ehcache 1.key is GeoHash value 2.value is List of Station
    }

    public static List<Station> getStationsByGeoHashCode(List<String> geoHashCodes)
    {
        //TODO Get Station list collection which the key is geoHashCode(base32Code) that in List
        return null;
    }
}
