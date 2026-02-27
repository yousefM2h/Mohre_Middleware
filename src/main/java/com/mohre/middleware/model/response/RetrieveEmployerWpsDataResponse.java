package com.mohre.middleware.model.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mohre.middleware.model.RespStat;
import com.mohre.middleware.model.RespStatWsiRefNo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RetrieveEmployerWpsDataResponse {
	
private RetrieveEmployerWpsDataResponseDetail responseDetail;
	
	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public static class RetrieveEmployerWpsDataResponseDetail{
		
		private RespStatWsiRefNo respStat;
		private RetrieveEmployerWpsDataResponseList responseList;
		
	}
	
	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public static class RetrieveEmployerWpsDataResponseList{
		
		private RetrieveEmployerWpsResponse Response;
		
	}
	
	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public static class RetrieveEmployerWpsResponse{
		
		private RetrieveEmployerWpsRespData respData;
		private RespStat respStat;
		private RegisteredCompanyDetails wsData;
		
	}
	
	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public static class RetrieveEmployerWpsRespData{
		@JsonProperty("WPSStatus")
		private List<WPSStatusList> wpsStatus;
		
	}
	
	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public static class WPSStatusList{
		
		private String status;
	    private String month;
		
	}
	
//	@Data
//	@AllArgsConstructor
//	@NoArgsConstructor
//	public static class RetrieveEmployerWpsWsData{
//		
//		private String emiratesID;
//		private String registrationNumber;
//		
//	}

}

