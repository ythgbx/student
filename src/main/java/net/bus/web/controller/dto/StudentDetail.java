package net.bus.web.controller.dto;

import java.util.Date;

/**
 * Created by yth on 2016/12/1.
 */

public class StudentDetail extends BaseResult{
    private String idcard;  // 身份证号

    private String sno; // 学号

    private String sname;  //姓名

    private String usedname;  // 曾用名

    private String sex;   //性别

    private String college;  // 学院

    private String birthday;  // 出生日期

    private String profession;  //专业

    private String classname;  // 班级

    private String grade;  // 年级

    private String level;  // 层次

    private String admissiontime;  // 入学时间

    private String studylength;  // 学制

    private String nationality;//名族

    private String political;//政治面貌

    private String sroom;//寝室号

    private String address;  //家庭地址

    private String stel;  //联系方式

    private String schoolcard; // 银行卡号

    private String school;

    private String fname; //父亲名字

    private String ftel;//

    private String mname;

    private String mtel;

    private String nativeplace;  //籍贯

    private String img;

    private String qq;

    private String familyaccount;  //家庭户口

    private String revenuesource;   //收入来源

    private String poorgrades;   //家庭经济困难认定等级

    private String populationcount;   //家庭人口总数

    private String monthlyincome;   //人均月收入

    private Integer m1age;   //身份证号
    private String m1company;   //身份证号
    private String m1name;   //身份证号
    private String m1relations;   //身份证号
    private Integer m2age;   //身份证号
    private String m2company;   //身份证号
    private String m2name;   //身份证号
    private String m2relations;   //身份证号
    private Integer m3age;   //身份证号
    private String m3company;   //身份证号
    private String m3name;   //身份证号
    private String m3relations;   //身份证号

    private String fundedpurpose;   //上学年资助用途
    private String fundpurpose;   //本学年资助用途
    private String familyincome;   //家庭月总收入
    private String amounted;   //上学年=受助金额
    private String applicationreasons;   //申请理由
    private String bankaccount;   //开户银行
    private Integer ranking;  //班级名次
    private Integer tnumber;  //班级总人数

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getUsedname() {
        return usedname;
    }

    public void setUsedname(String usedname) {
        this.usedname = usedname;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getAdmissiontime() {
        return admissiontime;
    }

    public void setAdmissiontime(String admissiontime) {
        this.admissiontime = admissiontime;
    }

    public String getStudylength() {
        return studylength;
    }

    public void setStudylength(String studylength) {
        this.studylength = studylength;
    }

    public String getNationality() {
        return nationality;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
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

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getFamilyaccount() {
        return familyaccount;
    }

    public void setFamilyaccount(String familyaccount) {
        this.familyaccount = familyaccount;
    }

    public String getRevenuesource() {
        return revenuesource;
    }

    public void setRevenuesource(String revenuesource) {
        this.revenuesource = revenuesource;
    }

    public String getPoorgrades() {
        return poorgrades;
    }

    public void setPoorgrades(String poorgrades) {
        this.poorgrades = poorgrades;
    }

    public String getPopulationcount() {
        return populationcount;
    }

    public void setPopulationcount(String populationcount) {
        this.populationcount = populationcount;
    }

    public String getMonthlyincome() {
        return monthlyincome;
    }

    public void setMonthlyincome(String monthlyincome) {
        this.monthlyincome = monthlyincome;
    }

    public Integer getM1age() {
        return m1age;
    }

    public void setM1age(Integer m1age) {
        this.m1age = m1age;
    }

    public String getM1company() {
        return m1company;
    }

    public void setM1company(String m1company) {
        this.m1company = m1company;
    }

    public String getM1name() {
        return m1name;
    }

    public void setM1name(String m1name) {
        this.m1name = m1name;
    }

    public String getM1relations() {
        return m1relations;
    }

    public void setM1relations(String m1relations) {
        this.m1relations = m1relations;
    }

    public Integer getM2age() {
        return m2age;
    }

    public void setM2age(Integer m2age) {
        this.m2age = m2age;
    }

    public String getM2company() {
        return m2company;
    }

    public void setM2company(String m2company) {
        this.m2company = m2company;
    }

    public String getM2name() {
        return m2name;
    }

    public void setM2name(String m2name) {
        this.m2name = m2name;
    }

    public String getM2relations() {
        return m2relations;
    }

    public void setM2relations(String m2relations) {
        this.m2relations = m2relations;
    }

    public Integer getM3age() {
        return m3age;
    }

    public void setM3age(Integer m3age) {
        this.m3age = m3age;
    }

    public String getM3company() {
        return m3company;
    }

    public void setM3company(String m3company) {
        this.m3company = m3company;
    }

    public String getM3name() {
        return m3name;
    }

    public void setM3name(String m3name) {
        this.m3name = m3name;
    }

    public String getM3relations() {
        return m3relations;
    }

    public void setM3relations(String m3relations) {
        this.m3relations = m3relations;
    }

    public String getFundedpurpose() {
        return fundedpurpose;
    }

    public void setFundedpurpose(String fundedpurpose) {
        this.fundedpurpose = fundedpurpose;
    }

    public String getFundpurpose() {
        return fundpurpose;
    }

    public void setFundpurpose(String fundpurpose) {
        this.fundpurpose = fundpurpose;
    }

    public String getFamilyincome() {
        return familyincome;
    }

    public void setFamilyincome(String familyincome) {
        this.familyincome = familyincome;
    }

    public String getAmounted() {
        return amounted;
    }

    public void setAmounted(String amounted) {
        this.amounted = amounted;
    }

    public String getApplicationreasons() {
        return applicationreasons;
    }

    public void setApplicationreasons(String applicationreasons) {
        this.applicationreasons = applicationreasons;
    }

    public String getBankaccount() {
        return bankaccount;
    }

    public void setBankaccount(String bankaccount) {
        this.bankaccount = bankaccount;
    }

    public Integer getRanking() {
        return ranking;
    }

    public void setRanking(Integer ranking) {
        this.ranking = ranking;
    }

    public Integer getTnumber() {
        return tnumber;
    }

    public void setTnumber(Integer tnumber) {
        this.tnumber = tnumber;
    }
}
