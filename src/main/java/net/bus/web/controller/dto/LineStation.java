package net.bus.web.controller.dto;

import net.bus.web.context.Position;

/**
 * Created by sky on 16/7/16.
 */
public class LineStation {

    private Long id;
    private String name;
    private Position pos;
    private int index;

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

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
