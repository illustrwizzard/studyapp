package com.axis.axislanguageschool;

public class Student_session {
    String Name,Left_time;
    int Join_time;

    public Student_session(String name, int join_time) {
        Name = name;
        Join_time = join_time;
    }


    public Student_session(String name, int  join_time, String left_time) {
        Name = name;
        Join_time = join_time;
        Left_time = left_time;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int  getJoin_time() {
        return Join_time;
    }

    public void setJoin_time(int  join_time) {
        Join_time = join_time;
    }

    public String getLeft_time() {
        return Left_time;
    }

    public void setLeft_time(String left_time) {
        Left_time = left_time;
    }
}
