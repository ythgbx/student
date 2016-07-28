package net.bus.web.controller.dto;

import java.util.Date;

/**
 * Created by sky on 16/7/27.
 */

public class SignRecordItem {
    /**
     * 构造函数
     * @param day 连续签到天数
     * @param points 积分值
     */
    public SignRecordItem(int day,int points){
        this.day = day;
        this.points = points;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    private int day;

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    private int points;


}
