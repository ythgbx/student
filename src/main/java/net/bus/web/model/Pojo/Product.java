package net.bus.web.model.Pojo;

import net.bus.web.enums.ProducedTypeEnum;

import java.math.BigDecimal;

/**
 * Created by Edifi_000 on 2016-11-01.
 */
public class Product {

    private Long id;

    private ProducedTypeEnum type;

    private String subject;

    private String body;

    private BigDecimal price;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ProducedTypeEnum getType() {
        return type;
    }

    public void setType(ProducedTypeEnum type) {
        this.type = type;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
