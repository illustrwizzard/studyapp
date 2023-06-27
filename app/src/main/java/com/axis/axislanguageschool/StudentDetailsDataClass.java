package com.axis.axislanguageschool;

public class StudentDetailsDataClass {

    String role;
    String batchname;
    String name;
    String email;
    String address;
    String mobile;
    String date_of_joining;
    String verify_code;
    String dob;

    public StudentDetailsDataClass(String role, String batchname, String name, String email, String address, String mobile, String date_of_joining, String verify_code, String dob) {
        this.role = role;
        this.batchname = batchname;
        this.name = name;
        this.email = email;
        this.address = address;
        this.mobile = mobile;
        this.date_of_joining = date_of_joining;
        this.verify_code = verify_code;
        this.dob = dob;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getBatchname() {
        return batchname;
    }

    public void setBatchname(String batchname) {
        this.batchname = batchname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getDate_of_joining() {
        return date_of_joining;
    }

    public void setDate_of_joining(String date_of_joining) {
        this.date_of_joining = date_of_joining;
    }

    public String getVerify_code() {
        return verify_code;
    }

    public void setVerify_code(String verify_code) {
        this.verify_code = verify_code;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }
}
