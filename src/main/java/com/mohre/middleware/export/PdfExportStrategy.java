package com.mohre.middleware.export;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.xhtmlrenderer.pdf.ITextRenderer;

import java.io.ByteArrayOutputStream;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * Renders a Thymeleaf template to PDF using Flying Saucer + iText.
 * <p>
 * Thymeleaf 3.x outputs HTML5, which is not necessarily well-formed XML.
 * This strategy cleans the output into valid XHTML before passing it
 * to Flying Saucer's XML parser.
 */
@Component
public class PdfExportStrategy implements ExportStrategy {

    private static final Logger log = LoggerFactory.getLogger(PdfExportStrategy.class);

    // Pattern to find void HTML elements that need self-closing: <meta ...> , <br>
    // , <hr> , <img ...> , <link ...> , <input ...>
    private static final Pattern VOID_ELEMENT_PATTERN = Pattern.compile(
            "<(meta|br|hr|img|link|input|col)\\b([^>/]*?)\\s*/?>",
            Pattern.CASE_INSENSITIVE);

    private final TemplateEngine templateEngine;

    public PdfExportStrategy(TemplateEngine templateEngine) {
        this.templateEngine = templateEngine;
    }

    @Override
    public boolean supports(ExportFormat format) {
        return format == ExportFormat.PDF;
    }

    @Override
    public byte[] export(String templateName, Map<String, Object> data) throws Exception {
        // 1. Render the Thymeleaf template to HTML
        Context ctx = new Context();
        ctx.setVariables(data);
        String html = templateEngine.process(templateName, ctx);
        log.debug("Rendered HTML length: {}", html.length());

        // 2. Clean HTML → well-formed XHTML for Flying Saucer
        String xhtml = toXhtml(html);
        log.debug("Cleaned XHTML length: {}", xhtml.length());

        // 3. Convert XHTML → PDF
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ITextRenderer renderer = new ITextRenderer();
        renderer.setDocumentFromString(xhtml);
        renderer.layout();
        renderer.createPDF(baos);
        baos.close();

        log.info("PDF generated successfully ({} bytes)", baos.size());
        return baos.toByteArray();
    }

    /**
     * Convert Thymeleaf HTML5 output to well-formed XHTML suitable for Flying
     * Saucer.
     */
    private String toXhtml(String html) {
        String result = html;

        // Remove HTML5 doctype and replace with XHTML doctype
        result = result.replaceAll("<!DOCTYPE[^>]*>",
                "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Strict//EN\" " +
                        "\"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd\">");

        // Ensure the <html> tag has the correct XHTML namespace regardless of what
        // Thymeleaf outputs
        if (result.contains("<html")) {
            // First, remove any existing xmlns attributes to avoid duplicates
            result = result.replaceAll("(<html[^>]*)\\s+xmlns=\"[^\"]*\"", "$1");
            // Then, add the correct XHTML namespace
            result = result.replace("<html", "<html xmlns=\"http://www.w3.org/1999/xhtml\"");
        }

        // Remove Thymeleaf namespace (not valid in strict XHTML output)
        result = result.replaceAll("\\s+xmlns:th=\"[^\"]*\"", "");

        // Self-close void elements: <meta ...> → <meta ... />
        result = VOID_ELEMENT_PATTERN.matcher(result).replaceAll("<$1$2 />");

        // Add XML declaration if missing
        if (!result.startsWith("<?xml")) {
            result = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" + result;
        }

        return result;
    }
}
