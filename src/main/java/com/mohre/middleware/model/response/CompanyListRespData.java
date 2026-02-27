package com.mohre.middleware.model.response;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompanyListRespData {
	
	private String UnifiedNumber;
	private String OwnerNameAr;
	private String OwnerName;
	private String PassportNo;
	private Boolean IsCompanyEmployer;
	private String EmiratesID;
	private String RegistrationStatus;
	private String RegistrationNumber;
	private Boolean IsDomesticEmployer;
	private List<CompanyListCompany> Company;

}
