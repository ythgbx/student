package net.bus.web.controller.dto;

import java.util.List;

/**
 * Created by Edifi_000 on 2016-11-21.
 */
public class TerminalRecords extends BaseRequest{

    private String device;
    private List<String> data;

    public String getDevice() {
        return device;
    }

    public void setDevice(String device) {
        this.device = device;
    }

    public List<String> getData() {
        return data;
    }

    public void setData(List<String> data) {
        this.data = data;
    }
}
