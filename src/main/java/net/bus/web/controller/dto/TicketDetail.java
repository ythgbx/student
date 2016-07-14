package net.bus.web.controller.dto;

/**
 * Created by Edifi_000 on 2016-07-05.
 */
public class TicketDetail {
    private Long id;
    private String start_station;
    private String end_station;
    private Integer price;
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

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }
}
