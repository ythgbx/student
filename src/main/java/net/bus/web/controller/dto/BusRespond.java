package net.bus.web.controller.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Created by sky on 16/11/11.
 */
public class BusRespond extends BaseResult{
    private Long id;

    private String name;

    private Long user_id;

    private Long line_id;

    private String device;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
