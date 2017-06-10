package net.bus.web.model;

import java.io.Serializable;

/**
 * 贫困生建档的povo类
 * Created by lenovo on 2017/6/10.
 */
public class PoorPovo extends PoorBuild implements Serializable{
    private Student student;


    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
