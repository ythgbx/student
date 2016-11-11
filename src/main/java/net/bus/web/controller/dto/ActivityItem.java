package net.bus.web.controller.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by sky on 16/10/13.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ActivityItem extends BaseResult{
    private Long id;
    private String img;
    private String title;
    private Integer remain;    //活动剩余时间
    private String detail; //活动详情
    private Integer number_of_people;    //参加活动人数
    private Date start_time;    //活动开始时间
    private Date end_time;
    private Integer lower_limit;   //人数下限
    private Integer upper_limit;   //人数上限
    private BigDecimal price;
    private Date paytime;

    public Date getPaytime() {
        return paytime;
    }

    public void setPaytime(Date paytime) {
        this.paytime = paytime;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getRemain() {
        return remain;
    }

    public void setRemain(Integer remain) {
        this.remain = remain;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public Integer getNumber_of_people() {
        return number_of_people;
    }

    public void setNumber_of_people(Integer number_of_people) {
        this.number_of_people = number_of_people;
    }

    public Date getStart_time() {
        return start_time;
    }

    public void setStart_time(Date start_time) {
        this.start_time = start_time;
    }

    public Date getEnd_time() {
        return end_time;
    }

    public void setEnd_time(Date end_time) {
        this.end_time = end_time;
    }

    public Integer getLower_limit() {
        return lower_limit;
    }

    public void setLower_limit(Integer lower_limit) {
        this.lower_limit = lower_limit;
    }

    public Integer getUpper_limit() {
        return upper_limit;
    }

    public void setUpper_limit(Integer upper_limit) {
        this.upper_limit = upper_limit;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
