package com.mohre.middleware.model.export;

import lombok.Getter;

import java.util.List;

@Getter
public class SifFileDetails {

    private String sifFileName;
    private String companyName;
    private String employerBankCode;
    private String accountDescription;
    private int totalEmployees;
    private String establishmentId;
    private String paymentCurrency;
    private double totalSalary;
    private String establishmentName;
    private String accountNo;
    private List<EmployeeRecord> employees;

    public SifFileDetails() {}

    // --- Getters & Setters ---

    public void setSifFileName(String sifFileName) { this.sifFileName = sifFileName; }

    public void setCompanyName(String companyName) { this.companyName = companyName; }

    public void setEmployerBankCode(String employerBankCode) { this.employerBankCode = employerBankCode; }

    public void setAccountDescription(String accountDescription) { this.accountDescription = accountDescription; }

    public void setTotalEmployees(int totalEmployees) { this.totalEmployees = totalEmployees; }

    public void setEstablishmentId(String establishmentId) { this.establishmentId = establishmentId; }

    public void setPaymentCurrency(String paymentCurrency) { this.paymentCurrency = paymentCurrency; }

    public void setTotalSalary(double totalSalary) { this.totalSalary = totalSalary; }

    public void setEstablishmentName(String establishmentName) { this.establishmentName = establishmentName; }

    public void setAccountNo(String accountNo) { this.accountNo = accountNo; }

    public void setEmployees(List<EmployeeRecord> employees) { this.employees = employees; }
}
