package com.axis.axislanguageschool;

public class Reciever {
    String usercode;
    String name;
    String Role;

    public Reciever(String usercode, String name,String Role) {
        this.usercode = usercode;
        this.name = name;
        this.Role=Role;
    }

    public String getRole() {
        return Role;
    }

    public void setRole(String role) {
        Role = role;
    }

    public String getUsercode() {
        return usercode;
    }

    public void setUsercode(String usercode) {
        this.usercode = usercode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
