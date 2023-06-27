package com.axis.axislanguageschool;

public class DataClassForTutorInAdmin {
    String Tutor_name,Tutor_img;

    public DataClassForTutorInAdmin(String tutor_name, String tutor_img) {

        Tutor_name = tutor_name;
        Tutor_img = tutor_img;
    }

    public String getTutor_name() {
        return Tutor_name;
    }

    public void setTutor_name(String tutor_name) {
        Tutor_name = tutor_name;
    }

    public String getTutor_img() {
        return Tutor_img;
    }

    public void setTutor_img(String tutor_img) {
        Tutor_img = tutor_img;
    }
}
