package com.devepkm.bean;

import java.sql.Date;

public class StudentResult {
    private String hkid;
    private String name;
    private Date birth;
    private String admissionID;
    private String chinese;
    private String english;
    private String maths;
    private String liberalStudies;

    // getter and setter for BeanHandler

    public String getHkid() {
        return hkid;
    }

    public void setHkid(String hkid) {
        this.hkid = hkid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public String getAdmissionID() {
        return admissionID;
    }

    public void setAdmissionID(String admissionID) {
        this.admissionID = admissionID;
    }

    public String getChinese() {
        return chinese;
    }

    public void setChinese(String chinese) {
        this.chinese = chinese;
    }

    public String getEnglish() {
        return english;
    }

    public void setEnglish(String english) {
        this.english = english;
    }

    public String getMaths() {
        return maths;
    }

    public void setMaths(String maths) {
        this.maths = maths;
    }

    public String getLiberalStudies() {
        return liberalStudies;
    }

    public void setLiberalStudies(String liberalStudies) {
        this.liberalStudies = liberalStudies;
    }

    @Override
    public String toString() {
        return "StudentResult{" +
                "hkid='" + hkid + '\'' +
                ", name='" + name + '\'' +
                ", birth=" + birth +
                ", admissionID='" + admissionID + '\'' +
                ", chinese='" + chinese + '\'' +
                ", english='" + english + '\'' +
                ", maths='" + maths + '\'' +
                ", liberalStudies='" + liberalStudies + '\'' +
                '}';
    }
}