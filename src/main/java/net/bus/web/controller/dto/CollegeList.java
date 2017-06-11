package net.bus.web.controller.dto;

import net.bus.web.model.College;

import java.util.List;

/**
 * Created by yth on 2017/6/11.
 */
public class CollegeList extends BaseResult {
    private List<College> colleges;

    public List<College> getColleges() {
        return colleges;
    }

    public void setColleges(List<College> colleges) {
        this.colleges = colleges;
    }
}
