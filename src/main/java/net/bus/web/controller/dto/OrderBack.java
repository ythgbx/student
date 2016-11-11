package net.bus.web.controller.dto;

/**
 * Created by sky on 16/11/11.
 */
public class OrderBack extends BaseResult {
    private Object payinfo;

    public Object getPayinfo() {
        return payinfo;
    }

    public void setPayinfo(Object payinfo) {
        this.payinfo = payinfo;
    }
}
