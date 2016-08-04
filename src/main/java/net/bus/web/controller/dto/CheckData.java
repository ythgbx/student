package net.bus.web.controller.dto;

import java.util.List;

/**
 * Created by sky on 16/8/3.
 */
public class CheckData {
    private List<String> code;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;

    public List<String>  getCode() {
        return code;
    }

    public void setCode(List<String>  code) {
        this.code = code;
    }
}
