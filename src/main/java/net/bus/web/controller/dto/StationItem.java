package net.bus.web.controller.dto;

import java.math.BigDecimal;

/**
 * Created by Edifi_000 on 2016-07-27.
 */
public class StationItem extends BaseResult{

    private Long id;
    private String name;
    private Position pos;
    private String annotation;
    private BigDecimal price;

    public BigDecimal getPrice() {return price;}

    public void setPrice(BigDecimal price) {this.price = price;}

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

    public String getAnnotation() {
        return annotation;
    }

    public void setAnnotation(String annotation) {
        this.annotation = annotation;
    }

}
