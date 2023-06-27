package com.axis.axislanguageschool;

public class DataClassForStudentDetailsInAdmin {
    String textname,img,verify_code;

    public DataClassForStudentDetailsInAdmin(String textname, String img,String verify_code) {
        this.textname = textname;
        this.img = img;
        this.verify_code=verify_code;
    }

    public String getTextname() {
        return textname;
    }

    public void setTextname(String textname) {
        this.textname = textname;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getVerify_code() {
        return verify_code;
    }

    public void setVerify_code(String verify_code) {
        this.verify_code = verify_code;
    }
}
