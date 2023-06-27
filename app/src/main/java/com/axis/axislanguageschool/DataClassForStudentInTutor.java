package com.axis.axislanguageschool;

public class DataClassForStudentInTutor {
    String name,verif_id;

    public DataClassForStudentInTutor(String name, String verif_id) {
        this.name = name;
        this.verif_id = verif_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVerif_id() {
        return verif_id;
    }

    public void setVerif_id(String verif_id) {
        this.verif_id = verif_id;
    }
}
