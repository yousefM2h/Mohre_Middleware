package com.mohre.middleware.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CompanyEmployerWebServiceData {
	
	private String emiratesID;
	private String personCode;
	private String companyCode;
	private String licenseNumber;
	private String licensePlace;
	private String licensePlaceAr;
	private String companyName;
	private String companyNameAr;
	private String ownerName;
	private String ownerNameAr;

}
