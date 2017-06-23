package net.bus.web.model;

/**
 * Created by yth on 2017/6/22.
 */
public class DataStatistics {
    private String colleges;
    private Integer count;
    private String poorGrades;

    public String getPoorGrades() {
        return poorGrades;
    }

    public void setPoorGrades(String poorGrades) {
        this.poorGrades = poorGrades;
    }

    public String getColleges() {
        return colleges;
    }

    public void setColleges(String colleges) {
        this.colleges = colleges;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
