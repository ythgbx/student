package net.bus.web.controller.dto;

import java.math.BigDecimal;

/**
 * Created by Edifi_000 on 2016-07-27.
 */
public class StationRequest extends BaseRequest {

    private String name;
//    private Position pos;
    private Double lat;
    private Double lng;
    private String annotation;
    private BigDecimal price;

    private Long lineid;


//    public Position getPos() {
//        return pos;
//    }
//
//    public void setPos(Position pos) {
//        this.pos = pos;
//    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

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

    public String getAnnotation() {
        return annotation;
    }

    public void setAnnotation(String annotation) {
        this.annotation = annotation;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
    public Long getLineid() {
        return lineid;
    }

    public void setLineid(Long lineid) {
        this.lineid = lineid;
    }
}
