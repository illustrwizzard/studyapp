package com.axis.axislanguageschool;

public class PermissionDataClass {
    String attendace;
    String student;
    String assignment;
    String test;
    String video;
    String live_class;
    String study_material;


    public PermissionDataClass(String attendace, String student, String assignment, String test, String video, String live_class, String study_material) {
        this.attendace = attendace;
        this.student = student;
        this.assignment = assignment;
        this.test = test;
        this.video = video;
        this.live_class = live_class;
        this.study_material = study_material;
    }

    public String getAttendace() {
        return attendace;
    }

    public void setAttendace(String attendace) {
        this.attendace = attendace;
    }

    public String getStudent() {
        return student;
    }

    public void setStudent(String student) {
        this.student = student;
    }

    public String getAssignment() {
        return assignment;
    }

    public void setAssignment(String assignment) {
        this.assignment = assignment;
    }

    public String getTest() {
        return test;
    }

    public void setTest(String test) {
        this.test = test;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public String getLive_class() {
        return live_class;
    }

    public void setLive_class(String live_class) {
        this.live_class = live_class;
    }

    public String getStudy_material() {
        return study_material;
    }

    public void setStudy_material(String study_material) {
        this.study_material = study_material;
    }
}

