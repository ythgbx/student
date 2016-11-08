package net.bus.web.controller.dto;

/**
 * Created by Edifi_000 on 2016-09-04.
 */
public class CommodityBuy extends BaseRequest{

    private int order_type;

    public int getOrder_type() {
        return order_type;
    }

    public void setOrder_type(int order_type) {
        this.order_type = order_type;
    }
}
