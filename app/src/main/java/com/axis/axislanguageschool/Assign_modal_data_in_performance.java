package com.axis.axislanguageschool;

public class Assign_modal_data_in_performance {
    String Assignment_name,Submitted_date;

    public String getAssignment_name() {
        return Assignment_name;
    }

    public void setAssignment_name(String assignment_name) {
        Assignment_name = assignment_name;
    }

    public String getSubmitted_date() {
        return Submitted_date;
    }

    public void setSubmitted_date(String submitted_date) {
        Submitted_date = submitted_date;
    }

    public Assign_modal_data_in_performance(String assignment_name, String submitted_date) {
        Assignment_name = assignment_name;
        Submitted_date = submitted_date;
    }
}
