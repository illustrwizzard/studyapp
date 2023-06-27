package com.axis.axislanguageschool;

public class MeetingDetailsDataClass {
    String batch,meet_code,verify_code,date;
    String status;
    String time;
    String total_time;

    public MeetingDetailsDataClass(String batch, String meet_code, String verify_code, String date, String status, String time, String total_time) {
        this.batch = batch;
        this.meet_code = meet_code;
        this.verify_code = verify_code;
        this.date = date;
        this.status = status;
        this.time = time;
        this.total_time = total_time;
    }

    public MeetingDetailsDataClass(String meet_code) {
        this.meet_code = meet_code;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTotal_time() {
        return total_time;
    }

    public void setTotal_time(String total_time) {
        this.total_time = total_time;
    }

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }

    public String getMeet_code() {
        return meet_code;
    }

    public void setMeet_code(String meet_code) {
        this.meet_code = meet_code;
    }

    public String getVerify_code() {
        return verify_code;
    }

    public void setVerify_code(String verify_code) {
        this.verify_code = verify_code;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
