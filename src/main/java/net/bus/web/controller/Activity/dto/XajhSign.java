package net.bus.web.controller.Activity.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import net.bus.web.controller.dto.BaseResult;

/**
 * Created by sky on 16/11/11.
 */
public class XajhSign{
    private String name;

    private String school;

    private String institute;

    private String phone;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getInstitute() {
        return institute;
    }

    public void setInstitute(String institute) {
        this.institute = institute;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

}
