package com.mohre.middleware.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WpsStatusDetailsRequest {

	private String registrationNo;
	private String emiratesId;
	
}
