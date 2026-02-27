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
public class DomesticSalaryPaymentResponse {
	private DomesticSalaryPaymentResponseDetail responseDetail;

	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public static class DomesticSalaryPaymentResponseDetail {

		private RespStatWsiRefNo respStat;
		private DomesticSalaryPaymentResponseList responseList;
	}

	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public static class DomesticSalaryPaymentResponseList {

		private DomesticSalaryResponse response;
	}

	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public static class DomesticSalaryResponse {

		private DomesticSalaryPaymentRespData respData;
		private RespStatReferenceId respStat;
		private DomesticSalaryPaymentWsData wsData;
	}

	@Data
	public static class DomesticSalaryPaymentRespData {

	}

	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public static class DomesticSalaryPaymentWsData {
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

}
