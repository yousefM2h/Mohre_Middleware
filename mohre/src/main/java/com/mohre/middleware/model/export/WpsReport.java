package com.mohre.middleware.model.export;

import java.util.List;

public class WpsReport {
    private String emiratesId;
    private String registrationNo;
    private List<WpsEntry> entries;

    public WpsReport() {
    }

    public String getEmiratesId() {
        return emiratesId;
    }

    public void setEmiratesId(String emiratesId) {
        this.emiratesId = emiratesId;
    }

    public String getRegistrationNo() {
        return registrationNo;
    }

    public void setRegistrationNo(String registrationNo) {
        this.registrationNo = registrationNo;
    }

    public List<WpsEntry> getEntries() {
        return entries;
    }

    public void setEntries(List<WpsEntry> entries) {
        this.entries = entries;
    }
}
