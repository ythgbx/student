package net.bus.web.controller.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

/**
 * Created by Edifi_000 on 2016-09-04.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CommodityList extends BaseResult {

    private List<CommodityItem> commoditys;
    private Integer page;
    private Integer total_count;

    public List<CommodityItem> getCommoditys() {
        return commoditys;
    }

    public void setCommoditys(List<CommodityItem> commoditys) {
        this.commoditys = commoditys;
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
