package net.bus.web.model;

public class ApplicationRecord {
    private Integer id;

    private String idcard;

    private String type;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}