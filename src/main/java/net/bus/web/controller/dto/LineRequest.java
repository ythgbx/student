package net.bus.web.controller.dto;

import java.util.List;

/**
 * Created by Edifi_000 on 2016-07-26.
 */
public class LineRequest extends BaseRequest {

    private String name;
    private String start;
    private String end;
    private Long start_time;
    private Long end_time;
    private Double price;
    private Double cost_time;
    private List<LineStation> list_stations;
    private String annotation;
    private String city_name;

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

    public List<LineStation> getList_stations() {
        return list_stations;
    }

    public void setList_stations(List<LineStation> list_stations) {
        this.list_stations = list_stations;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAnnotation() {
        return annotation;
    }

    public void setAnnotation(String annotation) {
        this.annotation = annotation;
    }

    public String getCity_name() {
        return city_name;
    }

    public void setCity_name(String city_name) {
        this.city_name = city_name;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }
}
