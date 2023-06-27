package com.axis.axislanguageschool;

public class classPresent_data_modal {
    String present_date,present_status,Duration;

    public String getPresent_date() {
        return present_date;
    }

    public void setPresent_date(String present_date) {
        this.present_date = present_date;
    }

    public String getPresent_status() {
        return present_status;
    }

    public void setPresent_status(String present_status) {
        this.present_status = present_status;
    }

    public String getDuration() {
        return Duration;
    }

    public void setDuration(String duration) {
        Duration = duration;
    }

    public classPresent_data_modal(String present_date, String present_status, String Duration) {
        this.present_date = present_date;
        this.present_status = present_status;
        this.Duration=Duration;
    }
}
