package net.bus.web.controller.dto;

import net.bus.web.context.Position;

import java.util.List;

/**
 * Created by Edifi_000 on 2016-07-04.
 */
public class LineDetail implements IResult{

    private Long id;
    private String start_station;
    private String end_station;
    private Long start_time;
    private Long end_time;
    private Double price;
    private Double cost_time;
    private Integer separated_station;
    private Double wait_time;
    private String list_stations;
    private List<LineBus> list_buses;
    private Long current_station_id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getCost_time() {
        return cost_time;
    }

    public void setCost_time(Double cost_time) {
        this.cost_time = cost_time;
    }

    public Integer getSeparated_station() {
        return separated_station;
    }

    public void setSeparated_station(Integer separated_station) {
        this.separated_station = separated_station;
    }

    public Double getWait_time() {
        return wait_time;
    }

    public void setWait_time(Double wait_time) {
        this.wait_time = wait_time;
    }

    public String getList_stations() {
        return list_stations;
    }

    public void setList_stations(String list_stations) {
        this.list_stations = list_stations;
    }

    public List<LineBus> getList_buses() {
        return list_buses;
    }

    public void setList_buses(List<LineBus> list_buses) {
        this.list_buses = list_buses;
    }

    public Long getCurrent_station_id() {
        return current_station_id;
    }

    public void setCurrent_station_id(Long current_station_id) {
        this.current_station_id = current_station_id;
    }
}
