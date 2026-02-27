package com.mohre.middleware.service;

import com.mohre.middleware.model.export.EmployeeRecord;
import com.mohre.middleware.model.export.SifFileDetails;
import com.mohre.middleware.model.export.WpsEntry;
import com.mohre.middleware.model.export.WpsReport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * Fetches report data from an external REST API.
 * Falls back to hard-coded sample data when the API is unreachable
 * (useful for local development / demo).
 */
@Service
public class DataFetcherService {

    private static final Logger log = LoggerFactory.getLogger(DataFetcherService.class);

    private final RestTemplate restTemplate;
    private final String apiBaseUrl;

    public DataFetcherService(RestTemplate restTemplate,
                              @Value("${app.api.base-url}") String apiBaseUrl) {
        this.restTemplate = restTemplate;
        this.apiBaseUrl = apiBaseUrl;
    }

    /**
     * Try to fetch SIF data from external API; fall back to sample data on failure.
     */
    public SifFileDetails fetchSifData() {
        try {
            String url = apiBaseUrl + "/sif-details";
            log.info("Fetching SIF data from {}", url);
            SifFileDetails details = restTemplate.getForObject(url, SifFileDetails.class);
            if (details != null)
                return details;
        } catch (Exception ex) {
            log.warn("External API unavailable ({}). Using sample data.", ex.getMessage());
        }
        return buildSampleData();
    }

    // -----------------------------------------------------------------
    // Sample data matching the provided PDF screenshot
    // -----------------------------------------------------------------
    private SifFileDetails buildSampleData() {
        SifFileDetails d = new SifFileDetails();
        d.setSifFileName("343434343434325070212514");
        d.setCompanyName("tom");
        d.setEmployerBankCode("904630101");
        d.setAccountDescription("tom");
        d.setTotalEmployees(10);
        d.setEstablishmentId("3434343434343");
        d.setPaymentCurrency("AED");
        d.setTotalSalary(85000.00);
        d.setEstablishmentName("tom");
        d.setAccountNo("2767676767677");

        List<EmployeeRecord> emps = new ArrayList<>();
        emps.add(emp(1, "3041404782528", "30262012", "AE470260001015856508601", "01 Jun 2025", "30 Jun 2025",
                10000.0, 0.0, 0, 30));
        emps.add(emp(2, "0032010885190", "60031010", "AE230030010497928132001", "01 Jun 2025", "30 Jun 2025",
                15000.0, 0.0, 0, 30));
        emps.add(emp(3, "1001110860763", "60031010", "AE270030011235694920001", "01 Jun 2025", "30 Jun 2025",
                8500.0, 0.0, 0, 30));
        emps.add(emp(4, "1003005810717", "30262012", "AE890260000959022873901", "01 Jun 2025", "30 Jun 2025",
                6000.0, 0.0, 0, 30));
        emps.add(emp(5, "1003005765162", "60031010", "AE920030012575803910001", "01 Jun 2025", "30 Jun 2025",
                6000.0, 0.0, 0, 30));
        emps.add(emp(6, "1000610937813", "30262012", "AE390260001015812960401", "01 Jun 2025", "30 Jun 2025",
                7500.0, 0.0, 0, 30));
        emps.add(emp(7, "1000610937814", "30262012", "AE390260001015812960402", "01 Jun 2025", "30 Jun 2025",
                8000.0, 0.0, 0, 30));
        emps.add(emp(8, "1000610937815", "30262012", "AE390260001015812960403", "01 Jun 2025", "30 Jun 2025",
                9000.0, 0.0, 0, 30));
        emps.add(emp(9, "1000610937816", "30262012", "AE390260001015812960404", "01 Jun 2025", "30 Jun 2025",
                7000.0, 0.0, 0, 30));
        emps.add(emp(10, "1000610937817", "30262012", "AE390260001015812960405", "01 Jun 2025", "30 Jun 2025",
                7000.0, 0.0, 0, 30));

        d.setEmployees(emps);
        return d;
    }

    private EmployeeRecord emp(int sl, String empId, String agentId, String accNo,
                               String startDate, String endDate,
                               Double fixed, Double variable, int lop, int days) {
        EmployeeRecord e = new EmployeeRecord();
        e.setSlNo(sl);
        e.setEmployeeId(empId);
        e.setAgentId(agentId);
        e.setEmployeeAccNo(accNo);
        e.setPayStartDate(startDate);
        e.setPayEndDate(endDate);
        e.setFixedValue(fixed);
        e.setVariableValue(variable);
        e.setLopDays(lop);
        e.setDaysInMonth(days);
        e.setAmtReturned(null);
        e.setReturnReason(null);
        return e;
    }

    public WpsReport fetchWpsData() {
        WpsReport report = new WpsReport();

        List<WpsEntry> entries = new ArrayList<WpsEntry>();
        entries.add(new WpsEntry("August 2024", "WPS Paid for Month"));
        entries.add(new WpsEntry("July 2024", "WPS Paid for Month"));
        entries.add(new WpsEntry("June 2024", "WPS Paid for Month"));
        entries.add(new WpsEntry("May 2024", "WPS Paid for Month"));
        entries.add(new WpsEntry("April 2024", "WPS Paid for Month"));
        entries.add(new WpsEntry("March 2024", "WPS Paid for Month"));

        report.setEntries(entries);
        return report;
    }
}
