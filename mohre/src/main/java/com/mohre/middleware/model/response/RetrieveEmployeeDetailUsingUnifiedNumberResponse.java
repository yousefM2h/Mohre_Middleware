package com.mohre.middleware.model.response;


import com.mohre.middleware.model.RespStat;
import com.mohre.middleware.model.RespStatWsiRefNo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RetrieveEmployeeDetailUsingUnifiedNumberResponse {
	
	private RetrieveEmployeeDetailUsingUNResponseDetail responseDetail;
	
	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public static class RetrieveEmployeeDetailUsingUNResponseDetail{
		
		private RespStatWsiRefNo respStat;
		private RetrieveEmployeeDetailUsingUNResponseList responseList;
		
	}
	
	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public static class RetrieveEmployeeDetailUsingUNResponseList{
		
		private RetrieveEmployeeDetailUsingUNResponse Response;
		
	}
	
	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public static class RetrieveEmployeeDetailUsingUNResponse{
		
		private RetrieveEmployeeDetailUsingUNRespData respData;
		private RespStat respStat;
		private RetrieveEmployeeDetailUsingUNWsData wsData;
		
	}
	
	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public static class RetrieveEmployeeDetailUsingUNRespData{
		
		private String cardNumber;
		private String unifiedNumber;
		private String employeeEmiratesID;
		private boolean isActive;
		private String passportNo;
		private String employeeName;
	    private String employeeNameAr;
	    private String personCode;
		
	}
	
	
	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public static class RetrieveEmployeeDetailUsingUNWsData{
		
		private String emiratesId;
		private String registrationNumber;
		private String employeeUnifiedNumber;
		
	}

}
