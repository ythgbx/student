package net.bus.web.controller.dto;

/**
 * Created by yth on 2017/6/9.
 */
public class StudentInfo {
    private String idcard;

    private String nationality;

    private String political;

    private String sroom;

    private String stel;

    private String schoolcard;

    private String fname;

    private String ftel;

    private String mname;

    private String mtel;

    private String nativeplace;

    private String img;

    public String getNationality() {
        return nationality;
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getPolitical() {
        return political;
    }

    public void setPolitical(String political) {
        this.political = political;
    }

    public String getSroom() {
        return sroom;
    }

    public void setSroom(String sroom) {
        this.sroom = sroom;
    }

    public String getStel() {
        return stel;
    }

    public void setStel(String stel) {
        this.stel = stel;
    }

    public String getSchoolcard() {
        return schoolcard;
    }

    public void setSchoolcard(String schoolcard) {
        this.schoolcard = schoolcard;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getFtel() {
        return ftel;
    }

    public void setFtel(String ftel) {
        this.ftel = ftel;
    }

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }

    public String getMtel() {
        return mtel;
    }

    public void setMtel(String mtel) {
        this.mtel = mtel;
    }

    public String getNativeplace() {
        return nativeplace;
    }

    public void setNativeplace(String nativeplace) {
        this.nativeplace = nativeplace;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
