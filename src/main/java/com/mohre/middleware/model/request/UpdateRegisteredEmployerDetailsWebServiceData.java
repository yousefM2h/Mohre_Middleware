package com.mohre.middleware.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UpdateRegisteredEmployerDetailsWebServiceData {
	
	private String unifiedNumber;
	private String emiratesId;
	private boolean isActive;
	private String registrationNumber;
	private int companyCode;

}
