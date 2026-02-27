package com.mohre.middleware.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DomesticEmployerWebServiceData {
	
	private String emiratesId;
	private String ownerName;
	private String ownerNameAr;
	private String unifiedNumber;

}
