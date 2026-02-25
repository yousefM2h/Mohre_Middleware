package com.mohre.middleware.model.request;

import java.time.Instant;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@Data
@AllArgsConstructor
public class CompanyEmployerDetailsRequest {

	private int id;
	private String emiratesID;
	private String personCode;
	private String companyCode;
	private String licenseNO;
	private String licensePlace;
	private String licensePlaceArabic;
	private String companyName;
	private String companyNameArabic;
	private String ownerName;
	private String ownerNameArabic;
	private String ownerConsent;
	private String registeringPersonName;
	private String registeringPersonMobile;
	private String registeringPersonEIDA;
    private String uabStatus;
    private String mohreStatus;
    private String registrationNo;
	private Instant firstUserActionDate;
	private Instant secondtUserActionDate;
	private String firstApprover;
	private String secondApprover;
	private String isRejected;
	
}

