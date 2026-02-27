package com.mohre.middleware.export;

import java.util.Map;

/**
 * Strategy interface for export format implementations.
 * <p>
 * To support a new format (e.g. CSV), implement this interface and annotate
 * the class with {@code @Component} — it will be auto-discovered.
 */
public interface ExportStrategy {

    /**
     * @return true if this strategy handles the given format.
     */
    boolean supports(ExportFormat format);

    /**
     * Render the report.
     *
     * @param templateName Thymeleaf template name (without extension), e.g.
     *                     "sif-report"
     * @param data         model attributes to pass to the template
     * @return the exported bytes (PDF, XLSX, etc.)
     */
    byte[] export(String templateName, Map<String, Object> data) throws Exception;
}
