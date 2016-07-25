package net.bus.web.context;

import java.util.List;

/**
 * Created by Edifi_000 on 2016-07-25.
 */
public class BusTracks {

    public List<Track> getTracks() {
        return tracks;
    }

    public void setTracks(List<Track> tracks) {
        this.tracks = tracks;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public String getLastGeoHashCodes() {
        return lastGeoHashCodes;
    }

    public void setLastGeoHashCodes(String lastGeoHashCodes) {
        this.lastGeoHashCodes = lastGeoHashCodes;
    }

    public enum Direction {
        Forward, Reverse
    }

    private List<Track> tracks;
    private Direction direction;
    private String lastGeoHashCodes;
}
