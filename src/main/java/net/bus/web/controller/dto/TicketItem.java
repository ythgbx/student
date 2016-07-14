package net.bus.web.controller.dto;

/**
 * Created by Edifi_000 on 2016-07-05.
 */
public class TicketItem {
    private Long id;
    private String start_station;
    private String end_station;
    private String bus_img;
    private Long active_time;
    private Long time;

    public Long getId(){ return id; }

    public void setId(Long id){ this.id = id; }

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

    public String getBus_img() {
        return bus_img;
    }

    public void setBus_img(String bus_img) {
        this.bus_img = bus_img;
    }

    public Long getActive_time() {
        return active_time;
    }

    public void setActive_time(Long active_time) {
        this.active_time = active_time;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }
}
