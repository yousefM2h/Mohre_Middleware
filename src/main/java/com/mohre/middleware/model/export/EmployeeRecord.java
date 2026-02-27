package com.mohre.middleware.model.export;

import lombok.Getter;

@Getter
public class EmployeeRecord {

    private int slNo;
    private String employeeId;
    private String agentId;
    private String employeeAccNo;
    private String payStartDate;
    private String payEndDate;
    private Double fixedValue;
    private Double variableValue;
    private int lopDays;
    private int daysInMonth;
    private Double amtReturned;
    private String returnReason;

    public EmployeeRecord() {
    }

    // --- Getters & Setters ---

    public void setSlNo(int slNo) {
        this.slNo = slNo;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public void setAgentId(String agentId) {
        this.agentId = agentId;
    }

    public void setEmployeeAccNo(String employeeAccNo) {
        this.employeeAccNo = employeeAccNo;
    }

    public void setPayStartDate(String payStartDate) {
        this.payStartDate = payStartDate;
    }

    public void setPayEndDate(String payEndDate) {
        this.payEndDate = payEndDate;
    }

    public void setFixedValue(Double fixedValue) {
        this.fixedValue = fixedValue;
    }

    public void setVariableValue(Double variableValue) {
        this.variableValue = variableValue;
    }

    public void setLopDays(int lopDays) {
        this.lopDays = lopDays;
    }

    public void setDaysInMonth(int daysInMonth) {
        this.daysInMonth = daysInMonth;
    }

    public void setAmtReturned(Double amtReturned) {
        this.amtReturned = amtReturned;
    }

    public void setReturnReason(String returnReason) {
        this.returnReason = returnReason;
    }
}
