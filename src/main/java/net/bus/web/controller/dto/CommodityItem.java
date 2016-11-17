package net.bus.web.controller.dto;

import java.math.BigDecimal;

/**
 * Created by Edifi_000 on 2016-09-04.
 */
public class CommodityItem {

    private Long id;

    private String name;

    private String Itemimg;

    private BigDecimal price;

    private String depict;

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

    public String getItemimg() {
        return Itemimg;
    }

    public void setItemimg(String Itemimg) {
        this.Itemimg = Itemimg;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getDepict() {
        return depict;
    }

    public void setDepict(String depict) {
        this.depict = depict;
    }
}
