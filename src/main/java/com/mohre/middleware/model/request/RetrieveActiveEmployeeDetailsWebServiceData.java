package com.mohre.middleware.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RetrieveActiveEmployeeDetailsWebServiceData {
	
	private String emiratesId;
	private String registrationNumber;
	private int PageIndex;
    private int PageSize;

}
