package com.mohre.middleware.model.response;

import com.mohre.middleware.model.RespStat;
import com.mohre.middleware.model.RespStatWsiRefNo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateRegisteredEmployerDetailsResponse {
private UpdateRegisteredEmployerResponseDetail responseDetail;
	
	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public static class UpdateRegisteredEmployerResponseDetail{
		
		private RespStatWsiRefNo respStat;
		private UpdateRegisteredEmployerResponseList responseList;
		
	}
	
	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public static class UpdateRegisteredEmployerResponseList{
		
		private UpdateRegisteredEmployerResponse Response;
		
	}
	
	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public static class UpdateRegisteredEmployerResponse{
		
		private UpdateRegisteredEmployerRespData respData;
		private RespStat respStat;
		private UpdateRegisteredEmployerWsData wsData;
		
	}
	
	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public static class UpdateRegisteredEmployerRespData{
		
		private String previousStatus;
	    private String previousStatusDate;
	    private String currentStatus;
	    private String currentStatusDate;
		
	}
	
	
	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public static class UpdateRegisteredEmployerWsData{
		private String unifiedNumber;
		private String emiratesId;
		private boolean isActive;
	    private String registrationNumber;
	    private int companyCode;
		
	}

}
