package com.mohre.middleware.export;

import com.mohre.middleware.model.export.EmployeeRecord;
import com.mohre.middleware.model.export.SifFileDetails;
import com.mohre.middleware.model.export.WpsEntry;
import com.mohre.middleware.model.export.WpsReport;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;

import java.io.ByteArrayOutputStream;
import java.util.List;
import java.util.Map;

/**
 * Generates an Excel workbook from the report data.
 * Template name is accepted for consistency but
 * the Excel layout is built programmatically via Apache POI.
 */
@Component
public class ExcelExportStrategy implements ExportStrategy {

    @Override
    public boolean supports(ExportFormat format) {
        return format == ExportFormat.EXCEL;
    }

    @Override
    public byte[] export(String templateName, Map<String, Object> data) throws Exception {
        if ("dashboard-report".equals(templateName)) {
            return exportDashboard(data);
        }
        return exportSif(data);
    }

    private byte[] exportSif(Map<String, Object> data) throws Exception {
        SifFileDetails details = (SifFileDetails) data.get("report");

        try (XSSFWorkbook workbook = new XSSFWorkbook();
                ByteArrayOutputStream baos = new ByteArrayOutputStream()) {

            Sheet sheet = workbook.createSheet("SIF File Details");

            // --- Styles ---
            CellStyle headerStyle = createHeaderStyle(workbook);
            CellStyle metaLabelStyle = createMetaLabelStyle(workbook);
            CellStyle metaValueStyle = createMetaValueStyle(workbook);
            CellStyle dataStyle = createDataStyle(workbook);
            CellStyle titleStyle = createTitleStyle(workbook);

            int rowIdx = 0;

            // Title row
            Row titleRow = sheet.createRow(rowIdx++);
            Cell titleCell = titleRow.createCell(0);
            titleCell.setCellValue("SIF File Details");
            titleCell.setCellStyle(titleStyle);
            sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 11));
            rowIdx++; // blank row

            // --- Metadata rows ---
            rowIdx = writeMetaRow(sheet, rowIdx, metaLabelStyle, metaValueStyle,
                    "SIF File Name", details.getSifFileName(),
                    "Total Employees", details.getTotalEmployees(),
                    "Total Salary", details.getTotalSalary());

            rowIdx = writeMetaRow(sheet, rowIdx, metaLabelStyle, metaValueStyle,
                    "Company Name", details.getCompanyName(),
                    "Establishment Id", details.getEstablishmentId(),
                    "Establishment Name", details.getEstablishmentName());

            rowIdx = writeMetaRow(sheet, rowIdx, metaLabelStyle, metaValueStyle,
                    "Employer Bank Code", details.getEmployerBankCode(),
                    "Payment Currency", details.getPaymentCurrency(),
                    "Account No", details.getAccountNo());

            // Account Description row with Merged Value Cell
            Row descRow = sheet.createRow(rowIdx++);
            createCell(descRow, 0, "Account Description", metaLabelStyle);
            createCell(descRow, 1, details.getAccountDescription(), metaValueStyle);
            sheet.addMergedRegion(new CellRangeAddress(rowIdx - 1, rowIdx - 1, 1, 5));
            // Add blank cells with style for the merged region borders
            for (int i = 2; i <= 5; i++)
                createCell(descRow, i, "", metaValueStyle);

            rowIdx++; // blank row

            // --- Employee table header ---
            String[] headers = { "Sl No", "Employee Id", "Agent Id", "Employee Acc No",
                    "Pay Start Date", "Pay End Date", "Fixed Value", "Variable Value",
                    "LOP Days", "Days In Month", "Amt Returned", "Return Reason" };
            Row hdrRow = sheet.createRow(rowIdx++);
            for (int i = 0; i < headers.length; i++) {
                Cell cell = hdrRow.createCell(i);
                cell.setCellValue(headers[i]);
                cell.setCellStyle(headerStyle);
            }

            // --- Employee data rows ---
            List<EmployeeRecord> employees = details.getEmployees();
            if (employees != null) {
                for (EmployeeRecord emp : employees) {
                    Row row = sheet.createRow(rowIdx++);
                    createCell(row, 0, emp.getSlNo(), dataStyle);
                    createCell(row, 1, emp.getEmployeeId(), dataStyle);
                    createCell(row, 2, emp.getAgentId(), dataStyle);
                    createCell(row, 3, emp.getEmployeeAccNo(), dataStyle);
                    createCell(row, 4, emp.getPayStartDate(), dataStyle);
                    createCell(row, 5, emp.getPayEndDate(), dataStyle);
                    createCell(row, 6, emp.getFixedValue(), dataStyle);
                    createCell(row, 7, emp.getVariableValue(), dataStyle);
                    createCell(row, 8, emp.getLopDays(), dataStyle);
                    createCell(row, 9, emp.getDaysInMonth(), dataStyle);
                    createCell(row, 10, emp.getAmtReturned(), dataStyle);
                    createCell(row, 11, emp.getReturnReason(), dataStyle);
                }
            }

            // Auto-size columns
            for (int i = 0; i < headers.length; i++) {
                sheet.autoSizeColumn(i);
            }

            workbook.write(baos);
            return baos.toByteArray();
        }
    }

    private byte[] exportDashboard(Map<String, Object> data) throws Exception {
        WpsReport report = (WpsReport) data.get("report");
        List<WpsEntry> entries = report != null ? report.getEntries() : null;
        int entriesCount = (entries != null) ? entries.size() : 0;

        System.out.println("ExcelExportStrategy: Generating dashboard with " + entriesCount + " entries");

        try (XSSFWorkbook workbook = new XSSFWorkbook();
                ByteArrayOutputStream baos = new ByteArrayOutputStream()) {

            Sheet sheet = workbook.createSheet("WPS Dashboard");
            CellStyle titleStyle = createTitleStyle(workbook);
            CellStyle headerStyle = createHeaderStyle(workbook);
            CellStyle dataStyle = createDataStyle(workbook);

            int rowIdx = 0;

            // Title
            Row titleRow = sheet.createRow(rowIdx++);
            titleRow.setHeightInPoints(30);
            Cell titleCell = titleRow.createCell(0);
            titleCell.setCellValue("Company Employer WPS Data");
            titleCell.setCellStyle(titleStyle);
            sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 3));
            rowIdx++;

            // Set widths for 4 columns
            for (int i = 0; i < 4; i++) {
                sheet.setColumnWidth(i, 5000);
            }

            // Header
            Row headRow = sheet.createRow(rowIdx++);
            headRow.setHeightInPoints(25);
            createCell(headRow, 0, "Month", headerStyle);
            createCell(headRow, 1, "", headerStyle);
            createCell(headRow, 2, "WPS Status", headerStyle);
            createCell(headRow, 3, "", headerStyle);
            sheet.addMergedRegion(new CellRangeAddress(rowIdx - 1, rowIdx - 1, 0, 1));
            sheet.addMergedRegion(new CellRangeAddress(rowIdx - 1, rowIdx - 1, 2, 3));

            // Data
            if (entries != null) {
                for (WpsEntry entry : entries) {
                    Row row = sheet.createRow(rowIdx++);
                    row.setHeightInPoints(20);
                    createCell(row, 0, entry.getMonth(), dataStyle);
                    createCell(row, 1, "", dataStyle);
                    createCell(row, 2, entry.getStatus(), dataStyle);
                    createCell(row, 3, "", dataStyle);
                    sheet.addMergedRegion(new CellRangeAddress(rowIdx - 1, rowIdx - 1, 0, 1));
                    sheet.addMergedRegion(new CellRangeAddress(rowIdx - 1, rowIdx - 1, 2, 3));
                }
            }

            sheet.autoSizeColumn(0);
            sheet.autoSizeColumn(1);

            workbook.write(baos);
            return baos.toByteArray();
        }
    }

    // --------- helper methods ---------

    private int writeMetaRow(Sheet sheet, int rowIdx, CellStyle labelStyle, CellStyle valueStyle,
            String l1, Object v1, String l2, Object v2, String l3, Object v3) {
        Row row = sheet.createRow(rowIdx++);
        createCell(row, 0, l1, labelStyle);
        createCell(row, 1, v1, valueStyle);
        createCell(row, 2, l2, labelStyle);
        createCell(row, 3, v2, valueStyle);
        createCell(row, 4, l3, labelStyle);
        createCell(row, 5, v3, valueStyle);
        return rowIdx;
    }

    private void createCell(Row row, int col, Object value, CellStyle style) {
        Cell cell = row.createCell(col);
        if (value instanceof Number) {
            cell.setCellValue(((Number) value).doubleValue());
        } else {
            cell.setCellValue(value != null ? value.toString() : "");
        }
        cell.setCellStyle(style);
    }

    private CellStyle createTitleStyle(XSSFWorkbook wb) {
        CellStyle style = wb.createCellStyle();
        Font font = wb.createFont();
        font.setBold(true);
        font.setFontHeightInPoints((short) 16);
        style.setFont(font);
        style.setAlignment(HorizontalAlignment.CENTER);
        style.setVerticalAlignment(VerticalAlignment.CENTER);
        return style;
    }

    private CellStyle createHeaderStyle(XSSFWorkbook wb) {
        CellStyle style = wb.createCellStyle();
        Font font = wb.createFont();
        font.setBold(true);
        font.setFontHeightInPoints((short) 12);
        style.setFont(font);
        style.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        style.setBorderBottom(BorderStyle.THIN);
        style.setBorderTop(BorderStyle.THIN);
        style.setBorderLeft(BorderStyle.THIN);
        style.setBorderRight(BorderStyle.THIN);
        style.setAlignment(HorizontalAlignment.CENTER);
        style.setVerticalAlignment(VerticalAlignment.CENTER);
        return style;
    }

    private CellStyle createMetaLabelStyle(XSSFWorkbook wb) {
        CellStyle style = wb.createCellStyle();
        Font font = wb.createFont();
        font.setBold(true);
        font.setFontHeightInPoints((short) 10);
        style.setFont(font);
        style.setBorderBottom(BorderStyle.THIN);
        style.setBorderTop(BorderStyle.THIN);
        style.setBorderLeft(BorderStyle.THIN);
        style.setBorderRight(BorderStyle.THIN);
        return style;
    }

    private CellStyle createMetaValueStyle(XSSFWorkbook wb) {
        CellStyle style = wb.createCellStyle();
        DataFormat format = wb.createDataFormat();
        Font font = wb.createFont();
        font.setFontHeightInPoints((short) 10);
        style.setFont(font);
        style.setBorderBottom(BorderStyle.THIN);
        style.setBorderTop(BorderStyle.THIN);
        style.setBorderLeft(BorderStyle.THIN);
        style.setBorderRight(BorderStyle.THIN);
        style.setDataFormat(format.getFormat("#,##0.00"));
        return style;
    }

    private CellStyle createDataStyle(XSSFWorkbook wb) {
        CellStyle style = wb.createCellStyle();
        Font font = wb.createFont();
        font.setFontHeightInPoints((short) 11);
        style.setFont(font);
        style.setBorderBottom(BorderStyle.THIN);
        style.setBorderTop(BorderStyle.THIN);
        style.setBorderLeft(BorderStyle.THIN);
        style.setBorderRight(BorderStyle.THIN);
        style.setAlignment(HorizontalAlignment.CENTER);
        style.setVerticalAlignment(VerticalAlignment.CENTER);
        return style;
    }
}
