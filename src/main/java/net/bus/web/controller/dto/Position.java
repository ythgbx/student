package net.bus.web.controller.dto;

/**
 * Created by Edifi_000 on 2016-07-27.
 */
public class Position {

    private Double lat;

    private Double lng;

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLng() {
        return lng;
    }

    public void setLng(Double lng) {
        this.lng = lng;
    }

    public Position()
    {

    }
    public Position(double lat,double lng)
    {
        setLat(lat);
        setLng(lng);
    }
}
