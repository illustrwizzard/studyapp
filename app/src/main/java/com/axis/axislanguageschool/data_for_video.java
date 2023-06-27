package com.axis.axislanguageschool;

public class data_for_video {
    String url,batch,type;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public data_for_video(String url, String batch, String type) {
        this.url = url;
        this.batch = batch;
        this.type = type;
    }
}
