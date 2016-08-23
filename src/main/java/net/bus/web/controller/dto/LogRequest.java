package net.bus.web.controller.dto;

/**
 * Created by Edifi_000 on 2016-08-23.
 */
public class LogRequest extends BaseRequest {

    private String device_id;
    private String type;
    private String content;

    public String getDevice_id() {
        return device_id;
    }

    public void setDevice_id(String device_id) {
        this.device_id = device_id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
