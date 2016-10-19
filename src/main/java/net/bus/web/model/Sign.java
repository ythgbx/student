package net.bus.web.model;

import java.util.Date;

public class Sign {
    private Long id;

    private Long userid;

    private Date signDate;

    private Integer succession;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public Date getSignDate() {
        return signDate;
    }

    public void setSignDate(Date signDate) {
        this.signDate = signDate;
    }

    public Integer getSuccession() {
        return succession;
    }

    public void setSuccession(Integer succession) {
        this.succession = succession;
    }
}