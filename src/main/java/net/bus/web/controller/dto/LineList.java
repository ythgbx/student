package net.bus.web.controller.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

/**
 * Created by Edifi_000 on 2016-07-26.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class LineList extends BaseResult {

    private List<LineItem> lines;
    private Integer page;
    private Integer total_count;

    public List<LineItem> getLines() {
        return lines;
    }

    public void setLines(List<LineItem> lines) {
        this.lines = lines;
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
