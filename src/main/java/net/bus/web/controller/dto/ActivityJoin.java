package net.bus.web.controller.dto;

/**
 * Created by sky on 16/11/2.
 */
public class ActivityJoin extends BaseRequest {

    private int order_type;

    public int getOrder_type() {
        return order_type;
    }

    public void setOrder_type(int order_type) {
        this.order_type = order_type;
    }
}
