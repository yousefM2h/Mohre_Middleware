package com.mohre.middleware.export;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Orchestrator — picks the matching strategy for the requested format
 * and delegates export.
 */
@Service
public class ExportService {

    private final List<ExportStrategy> strategies;

    public ExportService(List<ExportStrategy> strategies) {
        this.strategies = strategies;
    }

    /**
     * Export the data using the given format and template.
     *
     * @param format       target export format (PDF, EXCEL, etc.)
     * @param templateName Thymeleaf template name (e.g. "sif-report")
     * @param data         model data to feed into the template / report
     * @return exported bytes
     */
    public byte[] export(ExportFormat format, String templateName, Map<String, Object> data) throws Exception {
        ExportStrategy strategy = strategies.stream()
                .filter(s -> s.supports(format))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(
                        "No export strategy found for format: " + format));
        return strategy.export(templateName, data);
    }
}
