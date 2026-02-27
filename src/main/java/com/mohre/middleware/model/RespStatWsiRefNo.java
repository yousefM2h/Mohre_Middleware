package com.mohre.middleware.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RespStatWsiRefNo extends RespStat{
	
	private String wsiRefNo;
	private String responseCode;
	private String responseMessage;
}
