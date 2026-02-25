package com.mohre.middleware.model.response;

import com.mohre.middleware.model.RespStat;
import com.mohre.middleware.model.RespStatWsiRefNo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetDomesticListResponse {

	private DomesticListResponseDetail responseDetail;
	
	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public static class DomesticListResponseDetail{
		
		private RespStatWsiRefNo respStat;
		private DomesticListResponseList responseList;
		
	}
	
	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public static class DomesticListResponseList{
		
		private DomesticListResponse response;
		
	}
	
	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public static class DomesticListResponse{
		
		private DomesticListRespData respData;
		private RespStat respStat;
		private DomesticListWsData wsData;
		
	}
	
	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public static class DomesticListRespData{
		
		private String unifiedNumber;
		private String ownerNameAr;
		private String ownerName;
		private String passportNo;
		private Boolean isCompanyEmployer;
		private String emiratesID;
		private String registrationStatus;
		private String registrationNumber;
		private Boolean isDomesticEmployer;
	}
	
	
	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public static class DomesticListWsData{
		
		private String emiratesId;
		private String registrationType;
		
	}

}
