package com.mohre.middleware.controller;

import com.mohre.middleware.service.DataFetcherService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mohre.middleware.export.*;
import com.mohre.middleware.model.response.RetrieveEmployerWpsDataResponse.RetrieveEmployerWpsRespData;
import com.mohre.middleware.model.response.RetrieveEmployerWpsDataResponse.WPSStatusList;
import com.mohre.middleware.model.export.WpsReport;
import com.mohre.middleware.model.export.WpsEntry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ExportController {

    private static final Logger log = LoggerFactory.getLogger(ExportController.class);

    private final ExportService exportService;
    private final DataFetcherService dataFetcherService;

    public ExportController(ExportService exportService, DataFetcherService dataFetcherService) {
        this.exportService = exportService;
        this.dataFetcherService = dataFetcherService;
    }

    @GetMapping("/api/export")
    public ResponseEntity<byte[]> export(
            @RequestParam(defaultValue = "pdf") String format,
            @RequestParam(defaultValue = "sif-report") String template) {
        try {
            ExportFormat fmt = ExportFormat.fromString(format);
            Map<String, Object> data = buildModelData(template);

            byte[] bytes = exportService.export(fmt, template, data);

            String filename = template + fmt.getExtension();
            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + filename + "\"")
                    .contentType(MediaType.parseMediaType(fmt.getContentType()))
                    .body(bytes);
        } catch (Exception e) {
            log.error("Export failed", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/exportAsPDF")
    public ResponseEntity<byte[]> exportAsPdf() {
        return export("pdf", "sif-report");
    }

    @GetMapping("/exportAsExcel")
    public ResponseEntity<byte[]> exportAsExcel() {
        return export("excel", "sif-report");
    }

    // New Shortcuts for WPS Dashboard

    @PostMapping("/exportDashboardPdf")
    public ResponseEntity<byte[]> exportDashboardPdf(@RequestBody String wpsData) {
        return exportDashboard("pdf", wpsData);
    }

    @PostMapping("/exportDashboardExcel")
    public ResponseEntity<byte[]> exportDashboardExcel(@RequestBody String wpsData) {
        return exportDashboard("excel", wpsData);
    }

    private ResponseEntity<byte[]> exportDashboard(String format, String jsonRequest) {
        try {

            ObjectMapper objectMapper = new ObjectMapper();
            RetrieveEmployerWpsRespData wpsData = objectMapper.readValue(jsonRequest,
                    RetrieveEmployerWpsRespData.class);
            ExportFormat fmt = ExportFormat.fromString(format);
            Map<String, Object> data = new HashMap<>();
            data.put("report", mapWpsDataToReport(wpsData));
            data.put("generatedBy", "Admin");
            data.put("generatedAt", LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd MMM yyyy HH:mm:ss")));

            // Add Logo path
            String logoPath = "file:///" + new java.io.File("src/main/resources/static/images/uab-logo.png")
                    .getAbsolutePath().replace("\\", "/");
            data.put("logoPath", logoPath);

            byte[] bytes = exportService.export(fmt, "dashboard-report", data);

            String filename = "dashboard-report" + fmt.getExtension();
            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + filename + "\"")
                    .contentType(MediaType.parseMediaType(fmt.getContentType()))
                    .body(bytes);
        } catch (Exception e) {
            log.error("Export failed for dashboard", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    private WpsReport mapWpsDataToReport(RetrieveEmployerWpsRespData wpsData) {
        log.info("Mapping payload to WpsReport. Payload null: {}", (wpsData == null));
        WpsReport report = new WpsReport();
        List<WpsEntry> entries = new ArrayList<>();

        if (wpsData != null) {
            log.info("Payload wpsStatus list size: {}",
                    (wpsData.getWpsStatus() != null ? wpsData.getWpsStatus().size() : "null"));
            if (wpsData.getWpsStatus() != null) {
                int count = 0;
                for (WPSStatusList statusItem : wpsData.getWpsStatus()) {
                    if (count >= 24)
                        break;
                    if (statusItem != null) {
                        log.debug("Mapping entry: {} - {}", statusItem.getMonth(), statusItem.getStatus());
                        entries.add(new WpsEntry(statusItem.getMonth(), statusItem.getStatus()));
                        count++;
                    }
                }
            }
        }

        // Setting fallbacks for UI fields

        report.setEntries(entries);

        log.info("Successfully mapped {} entries to WpsReport", entries.size());
        return report;
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(org.springframework.http.converter.HttpMessageNotReadableException.class)
    public ResponseEntity<String> handleHttpMessageNotReadableException(
            org.springframework.http.converter.HttpMessageNotReadableException ex) {
        log.error("JSON Deserialization Error: ", ex);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }

    private Map<String, Object> buildModelData(String template) {
        Map<String, Object> data = new HashMap<String, Object>();

        if ("dashboard-report".equals(template)) {
            data.put("report", dataFetcherService.fetchWpsData());
        } else {
            data.put("report", dataFetcherService.fetchSifData());
        }

        data.put("generatedBy", "Admin");
        data.put("generatedAt", LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd MMM yyyy HH:mm:ss")));
        return data;
    }
}
