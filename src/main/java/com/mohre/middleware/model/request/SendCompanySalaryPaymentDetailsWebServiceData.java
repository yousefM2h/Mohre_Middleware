package com.mohre.middleware.model.request;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SendCompanySalaryPaymentDetailsWebServiceData {
	
	private Integer cardNumber;
    private Integer daysPaid;
    private String workerUnifiedNumber;
    private BigDecimal refundAmount;
    private String salaryMonth;
    private BigDecimal fixedIncome;
    private BigDecimal totalSalary;
    private Integer leaves;
    private Boolean isInsideCountry;
    private String personName;
    private String personNameAr;
    private String salaryType;
    private String workerEmiratesID;
    private String passportNumber;
    private BigDecimal allowance;
    private Integer companyCode;
    private String personCode;
    private String remarks;

}
