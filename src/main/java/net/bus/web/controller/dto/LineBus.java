package net.bus.web.controller.dto;

import net.bus.web.context.Position;

/**
 * Created by sky on 16/7/16.
 */
public class LineBus {

    private Position pos;
    private Long id;
    private String img;
    private Integer pos_in_line;

    public Position getPos() {
        return pos;
    }

    public void setPos(Position pos) {
        this.pos = pos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Integer getPos_in_line() {
        return pos_in_line;
    }

    public void setPos_in_line(Integer pos_in_line) {
        this.pos_in_line = pos_in_line;
    }
}
