package com.axis.axislanguageschool;

public class batchModel {
    private String Course_title;
    private String App_name;

    public String getCourse_title() {
        return Course_title;
    }

    public void setCourse_title(String course_title) {
        Course_title = course_title;
    }

    public String getApp_name() {
        return App_name;
    }

    public void setApp_name(String app_name) {
        App_name = app_name;
    }

    public batchModel(String course_title, String app_name) {
        Course_title = course_title;
        App_name = app_name;
    }
}
