package net.bus.web.controller.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

/**
 * Created by Edifi_000 on 2016-10-11.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CommodityOrderList extends BaseResult {

    private List<CommodityOrderItem> commoditys;
    private Integer page;
    private Integer total_count;

    public List<CommodityOrderItem> getCommoditys() {
        return commoditys;
    }

    public void setCommoditys(List<CommodityOrderItem> commoditys) {
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
