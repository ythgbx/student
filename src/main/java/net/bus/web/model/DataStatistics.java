package net.bus.web.model;

import java.io.Serializable;

/**
 * Created by yth on 2017/6/22.
 */
public class DataStatistics implements Serializable{

    private String colleges;

    private Integer count;

    private Integer commonly;

    private Integer general;

    private Integer special;


    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getColleges() {
        return colleges;
    }

    public void setColleges(String colleges) {
        this.colleges = colleges;
    }

    public Integer getCommonly() {
        return commonly;
    }

    public void setCommonly(Integer commonly) {
        this.commonly = commonly;
    }

    public Integer getGeneral() {
        return general;
    }

    public void setGeneral(Integer general) {
        this.general = general;
    }

    public Integer getSpecial() {
        return special;
    }

    public void setSpecial(Integer special) {
        this.special = special;
    }
}
