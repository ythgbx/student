package net.bus.web.controller.dto;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Date;

/**
 * Created by yth on 2016/12/1.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDetail extends BaseResult{
    private String id;

    private Long no;

    private String school;

    private String department;

    private Integer grade;

    private String classes;

    private String name;

    private String sex;

    private Date birthdata;

    private Date admissiondate;

    private String politicalstatus;

    private String nation;

    private String specialty;

    private Integer studylength;

    private String idcard;

    private String nativeplace;

    private String depth;

    private String tel;

    private String img;

    private String role;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getNo() {
        return no;
    }

    public void setNo(Long no) {
        this.no = no;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public String getClasses() {
        return classes;
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getBirthdata() {
        return birthdata;
    }

    public void setBirthdata(Date birthdata) {
        this.birthdata = birthdata;
    }

    public Date getAdmissiondate() {
        return admissiondate;
    }

    public void setAdmissiondate(Date admissiondate) {
        this.admissiondate = admissiondate;
    }

    public String getPoliticalstatus() {
        return politicalstatus;
    }

    public void setPoliticalstatus(String politicalstatus) {
        this.politicalstatus = politicalstatus;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public Integer getStudylength() {
        return studylength;
    }

    public void setStudylength(Integer studylength) {
        this.studylength = studylength;
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    public String getNativeplace() {
        return nativeplace;
    }

    public void setNativeplace(String nativeplace) {
        this.nativeplace = nativeplace;
    }

    public String getDepth() {
        return depth;
    }

    public void setDepth(String depth) {
        this.depth = depth;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

}
