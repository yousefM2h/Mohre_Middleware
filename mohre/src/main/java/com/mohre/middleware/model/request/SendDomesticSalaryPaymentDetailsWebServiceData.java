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
public class SendDomesticSalaryPaymentDetailsWebServiceData {
	
	private Integer daysPaid;
	private String workerUnifiedNumber;
	private String sponsorEIDA;
	private BigDecimal refundAmount;
	private String salaryMonth;
	private String sponsorUnifiedNumber;
	private BigDecimal fixedIncome;
	private BigDecimal totalSalary;
	private Integer leaves;
	private String salaryType;
	private String workerEmiratesID;
	private String passportNumber;
	private BigDecimal allowance;

}
