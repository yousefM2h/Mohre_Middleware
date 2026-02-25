package com.mohre.middleware.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompanyListCompany {
	
	private String CompanyName;
	private String CompanyNameAr;
	private Integer CompanyStatusCode;
	private String LicensePlace;
	private String LicenseNumber;
	private String CompanyStatus;
	private String CompanyStatusAr;
	private String LicensePlaceAr;
	private String CompanyCode;

}
