package com.axis.axislanguageschool;

public class tutor_data_model {
    String name;
    String attendence;
    String number;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAttendence() {
        return attendence;
    }

    public void setAttendence(String attendence) {
        this.attendence = attendence;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public tutor_data_model(String name, String attendence, String number) {
        this.name = name;
        this.attendence = attendence;
        this.number = number;
    }
}
