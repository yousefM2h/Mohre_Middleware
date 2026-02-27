package com.mohre.middleware.service;

import java.nio.charset.StandardCharsets;
import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.mohre.middleware.client.MohreClient;
import com.mohre.middleware.model.CompanyEmployer;
import com.mohre.middleware.model.CompanyEmployerWF;
import com.mohre.middleware.model.request.CompanyEmployerDetailsRequest;
import com.mohre.middleware.model.request.CompanyOrDomesticSponsorListWebServiceData;
import com.mohre.middleware.model.request.WpsStatusDetailsRequest;
import com.mohre.middleware.model.response.CompanyListRespData;
import com.mohre.middleware.model.response.GetCompanyListResponse;
import com.mohre.middleware.model.response.RegisteredCompanyDetails;
import com.mohre.middleware.model.response.RegisteredCompanyList;
import com.mohre.middleware.model.response.RegistrationCheckResponse;
import com.mohre.middleware.model.response.RegistrationCheckResponse.CompanyWithEmployer;
import com.mohre.middleware.model.response.RegistrationCheckResponse.RegistrationCheckItem;
import com.mohre.middleware.model.response.RetrieveEmployerWpsDataResponse;
import com.mohre.middleware.model.response.RetrieveEmployerWpsDataResponse.RetrieveEmployerWpsRespData;
import com.mohre.middleware.model.response.RetrieveWPSReportEmployeeResponse;
import com.mohre.middleware.model.response.RetrieveWPSReportEmployerResponse;
import com.mohre.middleware.repository.ComapnyEmployerWFRepository;
import com.mohre.middleware.repository.CompanyEmployerRepository;
import com.mohre.middleware.security.HmacService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class MohreServiceImpl implements MohreService {
	// @Value("${entitydetails.username}")
	// private String username;
	// @Value("${entitydetails.password}")
	// private String password;
	// @Value("${shared.secrete.key}")
	// private String secreteKey;

	private final MohreClient mohreClient;
	private final HmacService hmacService;
	private final CompanyEmployerRepository companyEmployerRepo;
	private final ComapnyEmployerWFRepository comapnyEmployerWFRepo;
	// private final EncryptionService encryptionService;

	@Override
	public Optional<RegistrationCheckItem> getCompanyDetails(String emiratesID) throws Exception {

		CompanyOrDomesticSponsorListWebServiceData request = CompanyOrDomesticSponsorListWebServiceData.builder()
				.emiratesId(emiratesID)
				.registrationType("Domestic")
				.build();
		RegistrationCheckResponse response = mohreClient.callRegistrationCheckApi(request);
		return response.getResponseDetail().getResponseList().getResponse().getRespData().getItems()
				.stream().findFirst();

		// CompanyListRespData companyListRespData = null;
		// GetCompanyListResponse getCompanyListResponse = null;
		// GetCompanyOrDomesticSponsorListRequest
		// getCompanyOrDomesticSponsorListRequest= new
		// GetCompanyOrDomesticSponsorListRequest();
		// try {
		// getCompanyOrDomesticSponsorListRequest.getWebServiceInputData().getWebServiceInputDetails().
		// getWsDatalst().setWebServiceData(request);
		// getCompanyOrDomesticSponsorListRequest.getWebServiceInputData().getWebServiceInputDetails().setEntityDetails(
		// EntityDetails.builder()
		// .bankId("046")
		// .password("password")
		// .username("username")
		// .requesterRef("WPS0001").build()
		// );
		//
		// CompanyOrDomesticSponsorListWebServiceInputDetails webserviceDetails =
		// getCompanyOrDomesticSponsorListRequest.getWebServiceInputData().getWebServiceInputDetails();
		//
		// ObjectMapper mapper = new ObjectMapper();
		// // Step 1: Convert to JSON string
		// String ServicePayload = mapper.writeValueAsString(webserviceDetails);
		// byte[] jsonBytes = ServicePayload.getBytes(StandardCharsets.UTF_8);
		//
		// String hashString = hmacService.getHMACMessageDigest(jsonBytes, " ");
		//
		// getCompanyOrDomesticSponsorListRequest.getWebServiceInputData().setHashStringDetails(
		// HashStringDetails.builder()
		// .hashString(hashString).build()
		// );
		// String jsonPayload =
		// mapper.writeValueAsString(getCompanyOrDomesticSponsorListRequest);
		// EncryptedRequest encryptedRequest =
		// null;//encryptionService.encryptRequest("046", "username", "password",
		// jsonPayload);
		//
		// getCompanyListResponse = mohreClient.getCompanyDetails(encryptedRequest);
		// } catch (Exception e) {
		// // TODO: handle exception
		// }
		// return companyListRespData;
	}

	@Override
	public RegisteredCompanyList getRegisteredCompanies() {

		List<CompanyEmployer> list = companyEmployerRepo.findAll();
		List<RegisteredCompanyDetails> result = list.stream().map(data -> {
			RegisteredCompanyDetails req = RegisteredCompanyDetails.builder()
					.emiratesId(data.getEmiratesID())
					.registrationNo(data.getRegistrationNo())
					.build();
			return req;
		}).collect(Collectors.toList());

		RegisteredCompanyList details = RegisteredCompanyList.builder().registeredCompanyDetails(result).build();

		return details; // result;
	}

	@Override
	@Transactional
	public void saveDetailsToWorkflowTable(CompanyEmployerDetailsRequest request) {

		CompanyEmployerWF company = new CompanyEmployerWF();
		BeanUtils.copyProperties(request, company);
		comapnyEmployerWFRepo.save(company);
		// if(request.getCompanyRequest()!=null)
		// {
		// request.getCompanyRequest().forEach(item ->{
		// CompanyWF wf = new CompanyWF();
		// BeanUtils.copyProperties(item, wf);
		// wf.setCompanyEmployerWf(company);
		// companyWFrepo.save(wf);
		// });
		// }
	}

	@Override
	public RetrieveEmployerWpsRespData retrieveEmployerWpsData(WpsStatusDetailsRequest request) throws Exception {
		// apiRequest = new RegisteredEmployerDetailsRequest(registrationNo,
		// emiratesId);
		RetrieveEmployerWpsDataResponse resp = mohreClient.getCompanyEmployerDetails(request);
		return resp.getResponseDetail().getResponseList().getResponse().getRespData();
	}

	@Override
	public RetrieveWPSReportEmployeeResponse retrieveWPSReportEmployee(String registrationNumber, String employeeEIDA)
			throws Exception {
		return mohreClient.retrieveWPSReportEmployee(registrationNumber, employeeEIDA);
	}

	@Override
	public RetrieveWPSReportEmployerResponse retrieveWPSReportEmployer(String registrationNumber, String ownerEIDA)
			throws Exception {
		return mohreClient.retrieveWPSReportEmployer(registrationNumber, ownerEIDA);
	}
}
