package com.axis.axislanguageschool;

public class test_model_class {
    String testdate,Listening_mark,Speaking_mark,Reading_mark;

    public String getTestdate() {
        return testdate;
    }

    public void setTestdate(String testdate) {
        this.testdate = testdate;
    }

    public String getListening_mark() {
        return Listening_mark;
    }

    public void setListening_mark(String listening_mark) {
        Listening_mark = listening_mark;
    }

    public String getSpeaking_mark() {
        return Speaking_mark;
    }

    public void setSpeaking_mark(String speaking_mark) {
        Speaking_mark = speaking_mark;
    }

    public String getReading_mark() {
        return Reading_mark;
    }

    public void setReading_mark(String reading_mark) {
        Reading_mark = reading_mark;
    }

    public test_model_class(String testdate, String listening_mark, String speaking_mark, String reading_mark) {
        this.testdate = testdate;
        Listening_mark = listening_mark;
        Speaking_mark = speaking_mark;
        Reading_mark = reading_mark;
    }
}
