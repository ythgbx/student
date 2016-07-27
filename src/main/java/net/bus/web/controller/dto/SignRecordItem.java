package net.bus.web.controller.dto;

import java.util.Date;

/**
 * Created by sky on 16/7/27.
 */
public class SignRecordItem {
    public SignRecordItem(Date day,int points){
        this.day = day;
        this.points = points;
    }
    private Date day;
    private int points;

    public Date getDay() {
        return day;
    }

    public void setDay(Date day) {
        this.day = day;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
}
