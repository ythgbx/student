package net.bus.web.controller.dto;

import java.util.List;

/**
 * Created by Edifi_000 on 2016-07-27.
 */
public class StationList extends BaseResult  {

    private List<StationItem> stations;
    private Integer page;
    private Integer total_count;

    public List<StationItem> getStations() {
        return stations;
    }

    public void setStations(List<StationItem> stations) {
        this.stations = stations;
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
