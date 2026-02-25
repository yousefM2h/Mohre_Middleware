package com.mohre.middleware.model.response;

import java.util.List;

import com.mohre.middleware.model.RespStat;
import com.mohre.middleware.model.RespStatWsiRefNo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RetreiveActiveEmployeeDetailsResponse {
	
	private RetreiveActiveEmployeeResponseDetail responseDetail;
	
	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public static class RetreiveActiveEmployeeResponseDetail{
		
		private RespStatWsiRefNo respStat;
		private RetreiveActiveEmployeeResponseList responseList;
		
	}
	
	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public static class RetreiveActiveEmployeeResponseList{
		
		private RetreiveActiveEmployeeResponse response;
		
	}
	
	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public static class RetreiveActiveEmployeeResponse{
		
		private RetreiveActiveEmployeeRespData respData;
		private RespStat respStat;
		private RetreiveActiveEmployeeWsData wsData;
		
	}
	
	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public static class RetreiveActiveEmployeeRespData{
		
		private List<EmployeeList> employeeList;
		
	}
	
	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public static class EmployeeList{
		
		private long cardNumber;
	    private String unifiedNumber;
	    private String employeeEmiratesID;
	    private boolean isActive;
	    private String passportNumber;
	    private String employeeName;
	    private String employeeNameAr;
	    private String personCode;
	}
	
	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public static class RetreiveActiveEmployeeWsData{
		
		private String emiratesId;
		private String registrationNumber;
		private int pageIndex;
	    private int pageSize;
		
	}

}
