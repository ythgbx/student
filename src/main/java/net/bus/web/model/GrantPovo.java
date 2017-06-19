package net.bus.web.model;

import java.io.Serializable;

/**
 * Created by lenovo on 2017/6/19.
 */
public class GrantPovo extends Grant implements Serializable{

    private Student student;

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
