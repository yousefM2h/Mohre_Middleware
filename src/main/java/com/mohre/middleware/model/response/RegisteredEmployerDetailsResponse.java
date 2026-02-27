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
public class RegisteredEmployerDetailsResponse {
	
	private RegisteredEmployerDetailsResponseDetail responseDetail;
	
	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public static class RegisteredEmployerDetailsResponseDetail{
		
		private RespStatWsiRefNo respStat;
		private RegisteredEmployerDetailsResponseList responseList;
		
	}
	
	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public static class RegisteredEmployerDetailsResponseList{
		
		private RegisteredEmployerResponse response;
		
	}
	
	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public static class RegisteredEmployerResponse{
		
		private RegisteredEmployerDetailsRespData respData;
		private RespStat respStat;
		private RegisteredEmployerDetailsWsData wsData;
		
	}
	
	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public static class RegisteredEmployerDetailsRespData{
		
		private boolean isActive;
		private String registrationType;
		private String createdDate;
	    private String lastUpdatedDated;
	    private String registrationStatus;
	    private String registrationNumber;
	    private List<RegistrationAudit> registrationAudit;
		
		
	}
	
	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public static class RegistrationAudit{
		
		private String status;
	    private String date;
	}
	
	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public static class RegisteredEmployerDetailsWsData{
		
		private String registrationNumber;
		
	}

}
