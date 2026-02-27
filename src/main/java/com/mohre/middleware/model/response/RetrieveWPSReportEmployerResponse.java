package com.mohre.middleware.model.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.mohre.middleware.model.RespStat;
import com.mohre.middleware.model.RespStatWsiRefNo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class RetrieveWPSReportEmployerResponse {

    private RetrieveWPSReportEmployerResponseDetail responseDetail;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class RetrieveWPSReportEmployerResponseDetail {
        private RespStatWsiRefNo respStat;
        private RetrieveWPSReportEmployerResponseList responseList;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class RetrieveWPSReportEmployerResponseList {
        private RetrieveWPSReportEmployerWPSResponse response;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class RetrieveWPSReportEmployerWPSResponse {
        private RetrieveWPSReportEmployerRespData respData;
        private RespStat respStat;
        private RetrieveWPSReportEmployerWsData wsData;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class RetrieveWPSReportEmployerRespData {
        private List<WPSReportItem> items;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class WPSReportItem {
        private List<CompanyWPSDetail> company;
        @JsonProperty("Domestic")
        private List<DomesticWPSDetail> domestic;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class CompanyWPSDetail {
        private String channelCode;
        private int daysPaid;
        private double fixedIncome;
        private double incomeVariable;
        private double totalSalary;
        private double leaves;
        private boolean isInsideCountry;
        private String salaryType;
        private String workerEmiratesID;
        private String passportNumber;
        private Long companyCode;
        private String fromDate;
        private String toDate;
        private String personCode;
        private String agentCode;
        private int year;
        private long period;
        private String salaryPaymentDate;
        private double totalBenefits;
        private double totalDeductions;
        private double totalAllowance;
        private double totalIncentives;
        private String workerIBANNumber;
        private String remarks;
        private WPSAllowances allowances;
        private WPSDeductions deductions;
        private WPSBenefits benefits;
        private WPSIncentives incentives;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class DomesticWPSDetail {
        private String channelCode;
        private int daysPaid;
        private String employeeName;
        private String employeeNameAr;
        private String sponsorEIDA;
        private long period;
        private String sponsorUnifiedNumber;
        private boolean isInsideCountry;
        private double fixedIncome;
        private double incomeVariable;
        private double totalSalary;
        private double leaves;
        private String salaryType;
        private String workerEmiratesID;
        private String passportNumber;
        private String fromDate;
        private String toDate;
        private String personCode;
        private String agentCode;
        private int year;
        private double totalBenefits;
        private double totalDeductions;
        private double allowance;
        private double totalIncentives;
        private String workerIBANNumber;
        private String remarks;
        private String salaryPaymentDate;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class WPSAllowances {
        private double housingAllowance;
        private double transportationAllowance;
        private double workNatureAllowance;
        private double costofLiving;
        private double mobileConnectivityAllowance;
        private double childrenAllowance;
        private double foodAllowance;
        private double supplementaryAllowance;
        private double utilitiesAllowance;
        private double carAllowance;
        private double socialAllowance;
        private double specialAllowance;
        private double healthcareAllowance;
        private double entertainmentAllowance;
        private double uniformAllowance;
        private double riskAllowance;
        private double extraAllowance;
        private double positionAllowance;
        private double trainerAllowance;
        private double supervisionAllowance;
        private double technicalAllowance;
        private String otherAllowance;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class WPSDeductions {
        private double socialSecuirityOrPensionFund;
        private double endOfService;
        private double healthInsurancePremiums;
        private double accommodationDeductions;
        private double loanRepayments;
        private double uniformOrEquipmentCosts;
        private double voluntaryDeductions;
        private double travelExpenses;
        private double trainingOrCertifications;
        private double otherDeductions;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class WPSBenefits {
        private double airTicket;
        private double medicalInsurance;
        private double lifeAndAccidentCover;
        private double relocation;
        private double annualLeave;
        private double mourningLeave;
        private double maternityLeave;
        private double paternityLeave;
        private double educational;
        private double nationalService;
        private double trainingAndDevelopment;
        private double gymMembershipOrWellnessPrograms;
        private double leaveEncashment;
        private double otherBenefits;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class WPSIncentives {
        private double shortTermIncentiveOrBonus;
        private double commission;
        private double otherIncentives;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class RetrieveWPSReportEmployerWsData {
        private String registrationNumber;
        private String ownerEIDA;
    }
}
