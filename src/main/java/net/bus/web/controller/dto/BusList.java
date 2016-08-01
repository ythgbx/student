package net.bus.web.controller.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

/**
 * Created by sky on 16/7/30.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BusList extends BaseResult {

    private List<BusItem> buses;
    private Integer page;
    private Integer total_count;

    public List<BusItem> getBuses() {
        return buses;
    }

    public void setBuses(List<BusItem> buses) {
        this.buses = buses;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getTotal_count() {
        return total_count;
    }

    public void setTotal_count(Integer total_count) {
        this.total_count = total_count;
    }
}
