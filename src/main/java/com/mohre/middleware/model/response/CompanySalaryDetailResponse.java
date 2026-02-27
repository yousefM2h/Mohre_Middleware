package com.mohre.middleware.model.response;


import java.math.BigDecimal;

import com.mohre.middleware.model.RespStatReferenceId;
import com.mohre.middleware.model.RespStatWsiRefNo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class CompanySalaryDetailResponse {
	private CompanySalaryPaymentResponseDetail responseDetail;

	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public static class CompanySalaryPaymentResponseDetail {

		private RespStatWsiRefNo respStat;
		private CompanySalaryPaymentResponseList responseList;
	}

	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public static class CompanySalaryPaymentResponseList {

		private CompanySalaryResponse response;
	}

	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public static class CompanySalaryResponse {

		private CompanySalaryPaymentRespData respData;
		private RespStatReferenceId respStat;
		private CompanySalaryPaymentWsData wsData;
	}

	@Data
	public static class CompanySalaryPaymentRespData {

	}

	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public static class CompanySalaryPaymentWsData {
		 private Integer cardNumber;
		    private Integer daysPaid;
		    private String workerUnifiedNumber;
		    private BigDecimal refundAmount;
		    private String salaryMonth;
		    private BigDecimal fixedIncome;
		    private BigDecimal totalSalary;
		    private Integer leaves;
		    private Boolean isInsideCountry;
		    private String personNameAr;
		    private String personName;
		    private String salaryType;
		    private String workerEmiratesID;
		    private String passportNumber;
		    private BigDecimal allowance;
		    private Integer companyCode;
		    private String personCode;
		    private String remarks;
	}
	

}
