package com.mohre.middleware.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisteredCompanyDetails{
@JsonProperty("emiratesID")
private String emiratesId;
private String registrationNo;
}
