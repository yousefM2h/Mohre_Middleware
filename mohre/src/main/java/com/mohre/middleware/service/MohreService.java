package com.mohre.middleware.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.mohre.middleware.model.request.CompanyEmployerDetailsRequest;
import com.mohre.middleware.model.request.CompanyOrDomesticSponsorListWebServiceData;
import com.mohre.middleware.model.request.WpsStatusDetailsRequest;
import com.mohre.middleware.model.response.CompanyEmployementRegistrationResponse;
import com.mohre.middleware.model.response.CompanyListRespData;
import com.mohre.middleware.model.response.CompanySalaryDetailResponse;
import com.mohre.middleware.model.response.DomesticEmployementRegistrationResponse;
import com.mohre.middleware.model.response.DomesticSalaryPaymentResponse;
import com.mohre.middleware.model.response.GetCompanyListResponse;
import com.mohre.middleware.model.response.GetDomesticListResponse;
import com.mohre.middleware.model.response.RegisteredCompanyDetails;
import com.mohre.middleware.model.response.RegisteredCompanyList;
import com.mohre.middleware.model.response.RegisteredEmployerDetailsResponse;
import com.mohre.middleware.model.response.RetreiveActiveEmployeeDetailsResponse;
import com.mohre.middleware.model.response.RetrieveEmployeeDetailUsingUnifiedNumberResponse;
import com.mohre.middleware.model.response.RetrieveEmployerWpsDataResponse;
import com.mohre.middleware.model.response.RetrieveEmployerWpsDataResponse.RetrieveEmployerWpsRespData;
import com.mohre.middleware.model.response.RetrieveWPSReportEmployeeResponse;
import com.mohre.middleware.model.response.RetrieveWPSReportEmployerResponse;
import com.mohre.middleware.model.response.SalaryNotificationDetailResponse;
import com.mohre.middleware.model.response.UpdateRegisteredEmployerDetailsResponse;
import com.mohre.middleware.model.response.RegistrationCheckResponse.CompanyWithEmployer;
import com.mohre.middleware.model.response.RegistrationCheckResponse.RegistrationCheckItem;

public interface MohreService {

	public Optional<RegistrationCheckItem> getCompanyDetails(String emiratesID) throws Exception;

	RegisteredCompanyList getRegisteredCompanies();

	void saveDetailsToWorkflowTable(CompanyEmployerDetailsRequest request);

	public RetrieveWPSReportEmployeeResponse retrieveWPSReportEmployee(String registrationNumber, String employeeEIDA)
			throws Exception;

	public RetrieveWPSReportEmployerResponse retrieveWPSReportEmployer(String registrationNumber, String ownerEIDA)
			throws Exception;

	// public GetCompanyListResponse
	// getCompanyList(GetCompanyOrDomesticSponsorListRequest request);
	//
	// public GetDomesticListResponse
	// getDomesticList(GetCompanyOrDomesticSponsorListRequest request);
	//
	// public RegisteredEmployerDetailsResponse
	// getRegisteredEmployerDetails(RegisteredEmployerDetailsRequest request);
	//
	// public UpdateRegisteredEmployerDetailsResponse
	// updateRegisteredEmployerDetails(UpdateRegisteredEmployerDetailsRequest
	// request);
	//
	// public RetreiveActiveEmployeeDetailsResponse
	// retrieveActiveEmployeeDetails(RetrieveActiveEmployeeDetailsRequest request);
	//
	// public RetrieveEmployeeDetailUsingUnifiedNumberResponse
	// retrieveEmployeeDetailUsingUnifiedNumber(RetrieveEmployeeDetailUsingUnifiedNumberRequest
	// request);
	//
	public RetrieveEmployerWpsRespData retrieveEmployerWpsData(WpsStatusDetailsRequest request) throws Exception;
	//
	// public DomesticEmployementRegistrationResponse
	// registerDomesticEmployer(RegisterDomesticEmployerRequest model);
	//
	// public CompanyEmployementRegistrationResponse
	// registerCompanyEmployer(RegisterCompanyEmployerRequest model);
	//
	// public SalaryNotificationDetailResponse
	// sendSalaryNotificationDetail(SendSalaryNotificationDetailRequest model);
	//
	// public DomesticSalaryPaymentResponse
	// sendDomesticSalaryPaymentDetails(SendDomesticSalaryPaymentDetailsRequest
	// model);
	//
	// public CompanySalaryDetailResponse
	// sendCompanySalaryPaymentDetails(SendCompanySalaryPaymentDetailsRequest
	// model);

}
