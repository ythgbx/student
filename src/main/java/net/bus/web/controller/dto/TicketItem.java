package net.bus.web.controller.dto;

/**
 * Created by Edifi_000 on 2016-07-05.
 */
public class TicketItem {
    private Long id;
    private String head;
    private String start_station;
    private String end_station;
    private String bus_img;
    private Long time;
    private Integer price;

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Long getId(){ return id; }

    public void setId(Long id){ this.id = id; }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

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

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }
}
