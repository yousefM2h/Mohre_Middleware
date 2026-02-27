package com.mohre.middleware.client;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mohre.middleware.model.request.CompanyOrDomesticSponsorListWebServiceData;
import com.mohre.middleware.model.request.WpsStatusDetailsRequest;
import com.mohre.middleware.model.response.GetCompanyListResponse;
import com.mohre.middleware.model.response.RegistrationCheckResponse;
import com.mohre.middleware.model.response.RetrieveEmployerWpsDataResponse;
import com.mohre.middleware.model.response.RetrieveWPSReportEmployeeResponse;
import com.mohre.middleware.utils.UrlUtils;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class MohreClient {

	private final RestTemplate restTemplate;

	// @Value("${mohre.url}")

	public GetCompanyListResponse getCompanyDetails()
			// EncryptedRequest getCompanyOrDomesticSponsorListRequest)
			throws URISyntaxException {
		// String url = "http://localhost:8181" ;
		// Map<String, Object> requestBody = new HashMap<>();
		// requestBody.put("username", getCompanyOrDomesticSponsorListRequest);
		// HttpHeaders headers = new HttpHeaders();
		// headers.setContentType(MediaType.APPLICATION_JSON);
		// APIPreCheckHeader apiPreCheckHeader = apiPreChecks.getPrecheckData("");
		// //putHeaderValues(headers, apiPreCheckHeader);
		// URI uri = new URI(UrlUtils.cleanUrl(url));
		// ResponseEntity<GetCompanyListResponse> response = callRestPostAPI(uri,
		// headers, requestBody,
		// GetCompanyListResponse.class);
		// GetCompanyListResponse detail = response.getBody();
		return null;
	}

	public RetrieveWPSReportEmployeeResponse retrieveWPSReportEmployee(String registrationNumber, String employeeEIDA)
			throws Exception {

		String url = "http://localhost:8088/api/mohre/sampleData";
		ObjectMapper mapper = new ObjectMapper();

		try {
			Map<String, String> requestBody = new HashMap<>();
			requestBody.put("registrationNumber", registrationNumber);
			requestBody.put("employeeEIDA", employeeEIDA);
			String jsonString = mapper.writeValueAsString(requestBody);
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);
			HttpEntity<String> entity = new HttpEntity<>(jsonString, headers);
			ResponseEntity<String> jsonResponse = restTemplate.exchange(url, HttpMethod.POST, entity, String.class);
			return mapper.readValue(jsonResponse.getBody(), RetrieveWPSReportEmployeeResponse.class);

		} catch (Exception e) {
			throw new Exception("Error while calling API", e);
		}
	}

	public RetrieveEmployerWpsDataResponse getCompanyEmployerDetails(WpsStatusDetailsRequest request) throws Exception {
		String url = "http://localhost:8088/api/mohre/retrieveEmployerWPSData";
		ObjectMapper mapper = new ObjectMapper();
		try {
			String jsonString = mapper.writeValueAsString(request);
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);
			HttpEntity<String> entity = new HttpEntity<>(jsonString, headers);
			ResponseEntity<String> jsonResponse = restTemplate.exchange(url, HttpMethod.POST, entity, String.class);
			return mapper.readValue(jsonResponse.getBody(), RetrieveEmployerWpsDataResponse.class);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			throw new Exception();
		}

	}

	//
	public <T, R> ResponseEntity<T> callRestPostAPI(URI uri, HttpHeaders headers, R body,
			Class<T> responseCls) {
		HttpEntity<R> req = new HttpEntity<>(body, headers);
		ResponseEntity<T> response = restTemplate.exchange(uri, HttpMethod.POST, req, responseCls);
		return response;
	}

	// public <T> ResponseEntity<T> callRestGetAPI(URI uri, HttpHeaders headers,
	// String json, Class<T> responseCls){
	// HttpEntity<String> req = new HttpEntity<>(json, headers);
	// ResponseEntity<T> response = restTemplate.exchange(uri, HttpMethod.GET, req,
	// responseCls);
	// return response;
	// }

	public RegistrationCheckResponse callRegistrationCheckApi(CompanyOrDomesticSponsorListWebServiceData request)
			throws Exception {
		// TODO Auto-generated method stub
		String mohreUrl = "http://localhost:8088/api/mohre/";
		ObjectMapper mapper = new ObjectMapper();
		try {
			String jsonreq = mapper.writeValueAsString(request);
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);
			URI uri = new URI(UrlUtils.cleanUrl(mohreUrl + "getCompanyOrDomesticSponsorList"));
			ResponseEntity<String> resp = callRestPostAPI(uri, headers, jsonreq, String.class);
			return mapper.readValue(resp.getBody(), RegistrationCheckResponse.class);

		} catch (JsonProcessingException | URISyntaxException e) {
			e.printStackTrace();
			throw new Exception();
		}

		// return null;

	}

}
