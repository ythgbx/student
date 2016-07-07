package net.bus.web.controller.dto;

/**
 * Created by Edifi_000 on 2016-07-04.
 */
public class LineItem {
    private String start_station;
    private String end_station;
    private Long start_time;
    private Long end_time;
    private Integer price;
    private String bus_img;

    public String getStart_station() {
        return start_station;
    }

    public void setStart_station(String start_station) {
        this.start_station = start_station;
    }

    public String getEnd_station() {
        return end_station;
    }

    public void setEnd_station(String end_station) {
        this.end_station = end_station;
    }

    public Long getStart_time() {
        return start_time;
    }

    public void setStart_time(Long start_time) {
        this.start_time = start_time;
    }

    public Long getEnd_time() {
        return end_time;
    }

    public void setEnd_time(Long end_time) {
        this.end_time = end_time;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getBus_img() {
        return bus_img;
    }

    public void setBus_img(String bus_img) {
        this.bus_img = bus_img;
    }
}