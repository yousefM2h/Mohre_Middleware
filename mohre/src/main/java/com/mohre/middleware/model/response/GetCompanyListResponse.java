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
public class GetCompanyListResponse {
	
	private CompanyListResponseDetail responseDetail;
	
	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public static class CompanyListResponseDetail{
		
		private RespStatWsiRefNo respStat;
		private CompanyListResponseList responseList;
		
	}
	
	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public static class CompanyListResponseList{
		
		private CompanyListResponse Response;
		
	}
	
	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public static class CompanyListResponse{
		
		private CompanyListRespData respData;
		private RespStat respStat;
		private CompanyListWsData wsData;
		
	}
	
	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public static class CompanyListWsData{
		
		private String emiratesId;
		private String registrationType;
		
	}

}
