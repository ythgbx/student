package net.bus.web.controller.dto;

import java.util.Date;

/**
 * Created by Edifi_000 on 2016-07-05.
 */
public class TicketDetail extends BaseResult{
    private Long id;
    private String start_station;
    private String end_station;
    private Integer price;
    private Long time;
    private Long active_time;
    private long remain_time;
    private String state;
    private static final int CHECKE_OUT_TIME = 900;//检票时间
    public Long getActive_time() {
        return active_time;
    }

    public void setActive_time(Date active_time) {
        if(active_time!= null){
            this.active_time = active_time.getTime();
            Date current = new Date();
            this.remain_time = CHECKE_OUT_TIME - ((current.getTime() - this.active_time)/1000);
            this.state = this.remain_time>CHECKE_OUT_TIME?"done":"checked";
        }else{
            this.state = "unchecked";
        }

    }
    public long getRemain_time() {
        return remain_time;
    }

    public void setRemain_time(long remain_time) {
        this.remain_time = remain_time;
    }
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
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

    public void setTime(Date time) {
        this.time = time.getTime();

    }
}
