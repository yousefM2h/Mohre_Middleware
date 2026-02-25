package com.mohre.middleware.model.response;

import com.mohre.middleware.model.RespStat;
import com.mohre.middleware.model.RespStatWsiRefNo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DomesticEmployementRegistrationResponse {

	private DomesticEmployementRegistrationResponseDetail responseDetail;

	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public static class DomesticEmployementRegistrationResponseDetail {

		private RespStatWsiRefNo respStat;
		private DomesticEmployementRegistrationResponseList responseList;
	}

	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public static class DomesticEmployementRegistrationResponseList {

		private DomesticEmployementRegResponse response;
	}

	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public static class DomesticEmployementRegResponse {

		private DomesticEmployementRegistrationRespData respData;
		private RespStat respStat;
		private DomesticEmployementRegistrationWsData wsData;
	}

	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public static class DomesticEmployementRegistrationRespData {

		private String unifiedNumber;
		private String emiratesID;
		private String registrationStatus;
		private String registrationNumber;
		private String registrationType;
	}

	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public static class DomesticEmployementRegistrationWsData {
		private String ownerName;
		private String ownerNameAr;
		private String unifiedNumber;
		private String emiratesId;
	}
}
