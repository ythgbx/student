package net.bus.web.controller.dto;

/**
 * Created by Edifi_000 on 2016-07-27.
 */
public class StationRequest extends BaseRequest {

    private String name;
    private Position pos;
    private String annotation;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Position getPos() {
        return pos;
    }

    public void setPos(Position pos) {
        this.pos = pos;
    }

    public String getAnnotation() {
        return annotation;
    }

    public void setAnnotation(String annotation) {
        this.annotation = annotation;
    }
}
