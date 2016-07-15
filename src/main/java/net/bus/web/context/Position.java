package net.bus.web.context;

/**
 * Created by sky on 16/7/9.
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
