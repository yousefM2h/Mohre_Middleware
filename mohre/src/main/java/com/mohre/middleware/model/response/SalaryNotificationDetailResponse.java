package com.mohre.middleware.model.response;
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
public class SalaryNotificationDetailResponse {
	private SalaryNotificationResponseDetail responseDetail;

	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public static class SalaryNotificationResponseDetail {

		private RespStatWsiRefNo respStat;
		private SalaryNotificationResponseList responseList;
	}

	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public static class SalaryNotificationResponseList {

		private SalaryNotificationResponse response;
	}

	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public static class SalaryNotificationResponse {

		private SalaryNotificationRespData respData;
		private RespStatReferenceId respStat;
		private SalaryNotificationWsData wsData;
	}

	@Data
	public static class SalaryNotificationRespData {

	
	}

	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public static class SalaryNotificationWsData {
		private String emiratesID;
		private String salaryMonth;
		private String companyCode;

		private String remarks;
	}

}
