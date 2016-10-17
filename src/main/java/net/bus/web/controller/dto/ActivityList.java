package net.bus.web.controller.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

/**
 * Created by sky on 16/10/13.
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ActivityList extends BaseResult{
    private List<ActivityItem> activity;
    private Integer page;
    private Integer total_count;

    public List<ActivityItem> getActivity() {
        return activity;
    }

    public void setActivity(List<ActivityItem> activity) {
        this.activity = activity;
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
