package com.mohre.middleware.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SendSalaryNotificationDetailWebServiceData {
	
	private String emiratesID;
	private String salaryMonth;
	private String companyCode;
	private String remarks;

}
