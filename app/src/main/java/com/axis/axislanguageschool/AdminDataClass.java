package com.axis.axislanguageschool;

public class AdminDataClass {
    String BatchName;
    String DateOfJoininig;

    public AdminDataClass(String batchName, String dateOfJoininig) {
        BatchName = batchName;
        DateOfJoininig = dateOfJoininig;
    }

    public String getBatchName() {
        return BatchName;
    }

    public void setBatchName(String batchName) {
        BatchName = batchName;
    }

    public String getDateOfJoininig() {
        return DateOfJoininig;
    }

    public void setDateOfJoininig(String dateOfJoininig) {
        DateOfJoininig = dateOfJoininig;
    }
}
