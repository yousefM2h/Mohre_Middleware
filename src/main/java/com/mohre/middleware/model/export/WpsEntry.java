package com.mohre.middleware.model.export;

import lombok.Builder;
import lombok.Getter;

public class WpsEntry {
    private String month;
    private String status;

    public WpsEntry() {
    }

    public WpsEntry(String month, String status) {
        this.month = month;
        this.status = status;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
