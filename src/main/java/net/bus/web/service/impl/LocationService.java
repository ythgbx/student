package net.bus.web.service.impl;

import ch.hsr.geohash.GeoHash;
import com.spatial4j.core.context.SpatialContext;
import com.spatial4j.core.distance.DistanceUtils;
import net.bus.web.context.BusesTracksContext;
import net.bus.web.context.Position;
import net.bus.web.context.StationsLocationContext;
import net.bus.web.model.Bus;
import net.bus.web.model.Station;
import net.bus.web.service.ILocationService;
import net.bus.web.service.IStationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Edifi_000 on 2016-07-15.
 */
@Service
public class LocationService implements ILocationService {

    @Autowired
    private IStationService _stationService;

    public List<Station> getAroundStation(Position pos)
    {
        return getAroundStation(pos,9);
    }

    public List<Station> getAroundStation(Position pos,int hashLength)
    {
        //step1
        GeoHash geoHash = GeoHash.withCharacterPrecision(pos.getLat(), pos.getLng(), hashLength);
        List<String> listStationAdjacentCode = new ArrayList<String>();
        GeoHash[] adjacent = geoHash.getAdjacent();
        listStationAdjacentCode.add(geoHash.toBase32());
        for (GeoHash hash : adjacent) {
            listStationAdjacentCode.add(hash.toBase32());
        }
        List<Station> allStationAdjacent = StationsLocationContext.getInstance(_stationService).getStationsByGeoHashCode(listStationAdjacentCode);

        //step2
        if(allStationAdjacent!=null) {
            final Position currentPos = pos;
            Collections.sort(allStationAdjacent, new Comparator<Station>() {
                //@Override
                public int compare(Station s1, Station s2) {
                    Double distanceS1 = getDistance(currentPos, new Position(s1.getLat(), s1.getLng()));
                    Double distanceS2 = getDistance(currentPos, new Position(s2.getLat(), s2.getLng()));
                    return distanceS1.compareTo(distanceS2);
                }

            });
        }

        return allStationAdjacent;
    }

    public List<Bus> getAroundBuses(Position pos)
    {
        return getAroundBuses(pos,9);
    }

    public List<Bus> getAroundBuses(Position pos, int hashLength)
    {
        //step1
        GeoHash geoHash = GeoHash.withCharacterPrecision(pos.getLat(), pos.getLng(), hashLength);
        List<String> listStationAdjacentCode = new ArrayList<String>();
        GeoHash[] adjacent = geoHash.getAdjacent();
        listStationAdjacentCode.add(geoHash.toBase32());
        for (GeoHash hash : adjacent) {
            listStationAdjacentCode.add(hash.toBase32());
        }

        return null;

    }

    private Double getDistance(Position posA,Position posB)
    {
        SpatialContext geo = SpatialContext.GEO;
        Double distance = geo.calcDistance(geo.makePoint(posA.getLng(), posA.getLat()), geo.makePoint(posB.getLng(), posB.getLat())) * DistanceUtils.DEG_TO_KM;
        return distance;
    }
}
