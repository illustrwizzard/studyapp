package com.axis.axislanguageschool;

public class tutor_stu_model {
    String Stuname,Stu_date_of_joing;

    public String getStuname() {
        return Stuname;
    }

    public void setStuname(String stuname) {
        Stuname = stuname;
    }

    public String getStu_date_of_joing() {
        return Stu_date_of_joing;
    }

    public void setStu_date_of_joing(String stu_date_of_joing) {
        Stu_date_of_joing = stu_date_of_joing;
    }

    public tutor_stu_model(String stuname, String stu_date_of_joing) {
        Stuname = stuname;
        Stu_date_of_joing = stu_date_of_joing;
    }
}
