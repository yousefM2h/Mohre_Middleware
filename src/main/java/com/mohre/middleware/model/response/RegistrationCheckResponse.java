package com.mohre.middleware.model.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.mohre.middleware.model.RespStat;
import com.mohre.middleware.model.RespStatWsiRefNo;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RegistrationCheckResponse {

	private ResponseDetail responseDetail;

    // ================= RESPONSE DETAIL =================

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class ResponseDetail {

        private RespStatWsiRefNo respStat;
        private ResponseList responseList;
    }

    // ================= RESP STAT =================

//    @Data
//    @JsonIgnoreProperties(ignoreUnknown = true)
//    public static class RespStat {
//
//        private String wsiRefNo;
//        private String responseCode;
//        private String responseMessage;
//    }

    // ================= RESPONSE LIST =================

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class ResponseList {

        private Response response;
    }

    // ================= RESPONSE =================

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Response {

        private RespData respData;
        private RespStat respStat;
        private RegistrationCheckResponseWsData wsData;
    }

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class RespData {

        private List<RegistrationCheckItem> items;
    }

    // ================= ITEM =================

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class RegistrationCheckItem {

        private String unifiedNumber;
        private String ownerNameAr;
        private String ownerName;
        private String passportNo;
        private Boolean isCompanyEmployer;
        @JsonProperty("emiratesID")
        private String emiratesID;
        private Boolean isDomesticEmployer;
        private String personCode;

        private List<CompanyWithEmployer> Company;
    }

    // ================= COMPANY =================

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class CompanyWithEmployer {

        private String companyName;
        private String companyNameAr;
        private Integer companyStatusCode;
        private String registrationStatus;
        private String registrationNumber;
        private String licensePlace;
        private String licenseNumber;
        private String companyStatus;
        private String companyStatusAr;
        private String licensePlaceAr;
        private Integer companyCode;
    }

    // ================= WS DATA =================
//
    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class RegistrationCheckResponseWsData {

        private String emiratesID;
        private String registrationType;
    }
}
