package com.mohre.middleware.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
import com.mohre.middleware.model.response.RegisteredEmployerDetailsResponse;
import com.mohre.middleware.model.response.RegistrationCheckResponse.RegistrationCheckItem;
import com.mohre.middleware.model.response.RetreiveActiveEmployeeDetailsResponse;
import com.mohre.middleware.model.response.RetrieveEmployeeDetailUsingUnifiedNumberResponse;
import com.mohre.middleware.model.response.RetrieveEmployerWpsDataResponse;
import com.mohre.middleware.model.response.RetrieveEmployerWpsDataResponse.RetrieveEmployerWpsRespData;
import com.mohre.middleware.model.response.SalaryNotificationDetailResponse;
import com.mohre.middleware.model.response.UpdateRegisteredEmployerDetailsResponse;
import com.mohre.middleware.model.response.RegisteredCompanyDetails;
import com.mohre.middleware.model.response.RegisteredCompanyList;
import com.mohre.middleware.model.response.RetrieveWPSReportEmployeeResponse;
import com.mohre.middleware.model.response.RetrieveWPSReportEmployerResponse;
import com.mohre.middleware.service.MohreService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/mohre")
public class MohreController {

	private final MohreService mohreService;

	@GetMapping("/retrieve-WPS-Report-Employee")
	public ResponseEntity<RetrieveWPSReportEmployeeResponse> retrieveWPSReportEmployee(
			@RequestParam String registrationNumber,
			@RequestParam String employeeEIDA) {
		try {
			RetrieveWPSReportEmployeeResponse response = mohreService.retrieveWPSReportEmployee(registrationNumber,
					employeeEIDA);
			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/retrieve-WPS-Report-Employer")
	public ResponseEntity<RetrieveWPSReportEmployerResponse> retrieveWPSReportEmployer(
			@RequestParam String registrationNumber,
			@RequestParam String ownerEIDA) {
		try {
			RetrieveWPSReportEmployerResponse response = mohreService.retrieveWPSReportEmployer(registrationNumber,
					ownerEIDA);
			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/get-company-details")
	public ResponseEntity<RegistrationCheckItem> getCompanyDetails(@RequestParam String emiratesID) {
		// CompanyListRespData companyListRespData =
		// mohreService.getCompanyDetails(request);
		Optional<RegistrationCheckItem> items;
		try {
			items = mohreService.getCompanyDetails(emiratesID);
			RegistrationCheckItem item = items.get();
			return new ResponseEntity<>(item, HttpStatus.OK);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

	}

	@GetMapping("/get-company-employer")
	public ResponseEntity<RegisteredCompanyList> getRegisteredCompany() {
		RegisteredCompanyList RegisteredCompany = mohreService.getRegisteredCompanies();
		return new ResponseEntity<>(RegisteredCompany, HttpStatus.OK);
	}

	@PostMapping("/send-for-approval")
	public ResponseEntity<String> saveCompanyDetailsForApproval(@RequestBody CompanyEmployerDetailsRequest request) {
		mohreService.saveDetailsToWorkflowTable(request);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	// @PostMapping("/employer-details")
	// public ResponseEntity<?> getEmployerDetails(@RequestBody
	// GetCompanyOrDomesticSponsorListRequest request) {
	// String registrationType =
	// request.getWebServiceInputData().getWebServiceInputDetails().getWsDatalst()
	// .getWebServiceData().getRegistrationType();
	//
	// if ("Company".equalsIgnoreCase(registrationType)) {
	// GetCompanyListResponse response = mohreService.getCompanyList(request);
	// return new ResponseEntity<>(HttpStatus.OK);
	// } else if ("Domestic".equalsIgnoreCase(registrationType)) {
	// GetDomesticListResponse response = mohreService.getDomesticList(request);
	// return new ResponseEntity<>(HttpStatus.OK);
	// } else {
	// return ResponseEntity.badRequest().body("Invalid registration type: " +
	// registrationType);
	// }
	// }
	//
	// @PostMapping("/registeredEmployerDetails")
	// public ResponseEntity<RegisteredEmployerDetailsResponse> getEmployerDetails(
	// @RequestBody RegisteredEmployerDetailsRequest request) {
	//
	// RegisteredEmployerDetailsResponse response =
	// mohreService.getRegisteredEmployerDetails(request);
	// return new ResponseEntity<>(HttpStatus.OK);
	// }
	//
	// @PostMapping("/updateRegisteredEmployer")
	// public ResponseEntity<UpdateRegisteredEmployerDetailsResponse>
	// updateRegisteredEmployer(
	// @RequestBody UpdateRegisteredEmployerDetailsRequest request) {
	//
	// UpdateRegisteredEmployerDetailsResponse response =
	// mohreService.updateRegisteredEmployerDetails(request);
	// return new ResponseEntity<>(HttpStatus.OK);
	// }
	//
	// @PostMapping("/retrieveActiveEmployee")
	// public ResponseEntity<RetreiveActiveEmployeeDetailsResponse>
	// retrieveActiveEmployee(
	// @RequestBody RetrieveActiveEmployeeDetailsRequest request) {
	//
	// RetreiveActiveEmployeeDetailsResponse response =
	// mohreService.retrieveActiveEmployeeDetails(request);
	// return new ResponseEntity<>(HttpStatus.OK);
	// }
	//
	// @PostMapping("/retrieveEmployeeUsingUN")
	// public ResponseEntity<RetrieveEmployeeDetailUsingUnifiedNumberResponse>
	// retrieveEmployeeUsingUN(
	// @RequestBody RetrieveEmployeeDetailUsingUnifiedNumberRequest request) {
	//
	// RetrieveEmployeeDetailUsingUnifiedNumberResponse response = mohreService
	// .retrieveEmployeeDetailUsingUnifiedNumber(request);
	// return new ResponseEntity<>(HttpStatus.OK);
	// }
	//
	@GetMapping("/retrieve-Employer-WPSData")
	public ResponseEntity<RetrieveEmployerWpsRespData> retrieveEmployerWPSData(
			@RequestBody WpsStatusDetailsRequest request) {
		try {
			RetrieveEmployerWpsRespData response = mohreService.retrieveEmployerWpsData(request);
			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	//
	// @PostMapping("/registerDomesticEmployer")
	// public ResponseEntity<?> registerDomesticEmployer(@RequestBody
	// RegisterDomesticEmployerRequest model) {
	// DomesticEmployementRegistrationResponse response =
	// mohreService.registerDomesticEmployer(model);
	// return new ResponseEntity<>(HttpStatus.OK);
	// }
	//
	// @PostMapping("/registerCompanyEmployer")
	// public ResponseEntity<CompanyEmployementRegistrationResponse>
	// registerCompanyEmployer(@RequestBody RegisterCompanyEmployerRequest model) {
	// CompanyEmployementRegistrationResponse response =
	// mohreService.registerCompanyEmployer(model);
	// return new ResponseEntity<>(HttpStatus.OK);
	// }
	//
	// @PostMapping("/sendSalaryPaymentNotification")
	// public ResponseEntity<SalaryNotificationDetailResponse>
	// sendSalaryNotification(@RequestBody SendSalaryNotificationDetailRequest
	// model) {
	// SalaryNotificationDetailResponse response =
	// mohreService.sendSalaryNotificationDetail(model);
	// return new ResponseEntity<>(HttpStatus.OK);
	// }
	//
	// @PostMapping("/sendDomesticSalaryPaymentDetails")
	// public ResponseEntity<DomesticSalaryPaymentResponse>
	// sendDomesticSalaryPaymentDetails(
	// @RequestBody SendDomesticSalaryPaymentDetailsRequest model) {
	// DomesticSalaryPaymentResponse respone =
	// mohreService.sendDomesticSalaryPaymentDetails(model);
	// return new ResponseEntity<>(HttpStatus.OK);
	// }
	//
	// @PostMapping("/sendCompanySalaryPaymentDetails")
	// public ResponseEntity<CompanySalaryDetailResponse>
	// sendCompanySalaryPaymentDetails(@RequestBody
	// SendCompanySalaryPaymentDetailsRequest model) {
	// CompanySalaryDetailResponse reponse=
	// mohreService.sendCompanySalaryPaymentDetails(model);
	// return new ResponseEntity<>(HttpStatus.OK);
	// }

}
