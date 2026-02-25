package com.mohre.middleware.model.response;

import com.mohre.middleware.model.RespStat;
import com.mohre.middleware.model.RespStatWsiRefNo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class CompanyEmployementRegistrationResponse {
	private CompanyEmployementRegistrationResponseDetail responseDetail;

	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public static class CompanyEmployementRegistrationResponseDetail {

		private RespStatWsiRefNo respStat;
		private CompanyEmployementRegistrationResponseList responseList;
	}

	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public static class CompanyEmployementRegistrationResponseList {

		private CompanyEmployementRegResponse response;
	}

	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public static class CompanyEmployementRegResponse {

		private CompanyEmployementRegistrationRespData respData;
		private RespStat respStat;
		private CompanyEmployementRegistrationWsData wsData;
	}

	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public static class CompanyEmployementRegistrationRespData {

		private String unifiedNumber;
		private String emiratesID;
		private String registrationStatus;
		private String registrationNumber;
		private String registrationType;
	}

	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public static class CompanyEmployementRegistrationWsData {

		private String emiratesID;
		private String personCode;
		private Integer companyCode;
		private String licenseNumber;
		private String licensePlace;
		private String licensePlaceAr;
		private String companyName;
		private String companyNameAr;
		private String ownerName;
		private String ownerNameAr;
	}

}
