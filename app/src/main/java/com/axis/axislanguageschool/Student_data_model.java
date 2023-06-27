package com.axis.axislanguageschool;

public class Student_data_model {
    String STUname;
    String STUbatch;
    String STUPhone;
    String STUAttendence;

    public String getSTUname() {
        return STUname;
    }

    public void setSTUname(String STUname) {
        this.STUname = STUname;
    }

    public String getSTUbatch() {
        return STUbatch;
    }

    public void setSTUbatch(String STUbatch) {
        this.STUbatch = STUbatch;
    }

    public String getSTUPhone() {
        return STUPhone;
    }

    public void setSTUPhone(String STUPhone) {
        this.STUPhone = STUPhone;
    }

    public String getSTUAttendence() {
        return STUAttendence;
    }

    public void setSTUAttendence(String STUAttendence) {
        this.STUAttendence = STUAttendence;
    }

    public Student_data_model(String STUname, String STUbatch, String STUPhone, String STUAttendence) {
        this.STUname = STUname;
        this.STUbatch = STUbatch;
        this.STUPhone = STUPhone;
        this.STUAttendence = STUAttendence;
    }
}
