package com.axis.axislanguageschool;

public class DataClassForStudentAssignment {
    String assign_name,submitted_date,batchname,link;

    public DataClassForStudentAssignment(String assign_name, String submitted_date,String batchname,String link) {
        this.assign_name = assign_name;
        this.submitted_date = submitted_date;
        this.batchname=batchname;
        this.link=link;
    }

    public String getAssign_name() {
        return assign_name;
    }

    public void setAssign_name(String assign_name) {
        this.assign_name = assign_name;
    }

    public String getSubmitted_date() {
        return submitted_date;
    }

    public void setSubmitted_date(String submitted_date) {
        this.submitted_date = submitted_date;
    }

    public String getBatchname() {
        return batchname;
    }

    public void setBatchname(String batchname) {
        this.batchname = batchname;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
