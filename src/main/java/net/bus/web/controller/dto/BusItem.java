package net.bus.web.controller.dto;

/**
 * Created by sky on 16/7/30.
 */
public class BusItem {

    private Long id;
    private String name;
    private Position pos;
    private Double angle;

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

    public Position getPos() {
        return pos;
    }

    public void setPos(Position pos) {
        this.pos = pos;
    }

    public Double getAngle() {
        return angle;
    }

    public void setAngle(Double angle) {
        this.angle = angle;
    }
}
