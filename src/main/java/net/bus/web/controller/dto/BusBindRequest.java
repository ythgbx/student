package net.bus.web.controller.dto;

/**
 * Created by Edifi_000 on 2016-08-29.
 */
public class BusBindRequest extends BaseRequest{

    private String name;

    private Long user_id;

    private Long line_id;

    private String device;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public Long getLine_id() {
        return line_id;
    }

    public void setLine_id(Long line_id) {
        this.line_id = line_id;
    }

    public String getDevice() {
        return device;
    }

    public void setDevice(String device) {
        this.device = device;
    }
}
