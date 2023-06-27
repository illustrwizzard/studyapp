package com.axis.axislanguageschool;

public class DataModelClass_Batch_In_PerformanceAdmin {
    String Batchname,JoiningDate;

    public DataModelClass_Batch_In_PerformanceAdmin(String batchname, String joiningDate) {

        Batchname = batchname;
        JoiningDate = joiningDate;
    }

    public String getBatchname() {
        return Batchname;
    }

    public void setBatchname(String batchname) {
        Batchname = batchname;
    }

    public String getJoiningDate() {
        return JoiningDate;
    }

    public void setJoiningDate(String joiningDate) {
        JoiningDate = joiningDate;
    }
}
