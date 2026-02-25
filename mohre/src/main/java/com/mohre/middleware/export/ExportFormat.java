package com.mohre.middleware.export;

/**
 * Supported export formats.
 * To add a new format, add an entry here and create a matching ExportStrategy
 * implementation.
 */
public enum ExportFormat {

    PDF("application/pdf", ".pdf"),
    EXCEL("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet", ".xlsx");

    private final String contentType;
    private final String extension;

    ExportFormat(String contentType, String extension) {
        this.contentType = contentType;
        this.extension = extension;
    }

    public String getContentType() {
        return contentType;
    }

    public String getExtension() {
        return extension;
    }

    /**
     * Case-insensitive lookup.
     */
    public static ExportFormat fromString(String value) {
        for (ExportFormat f : values()) {
            if (f.name().equalsIgnoreCase(value))
                return f;
        }
        throw new IllegalArgumentException("Unsupported export format: " + value);
    }
}
