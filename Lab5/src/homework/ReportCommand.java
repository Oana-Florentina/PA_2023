package homework;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.awt.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReportCommand implements Command {
    private Catalog catalog;
    private static final String TEMPLATE_NAME = "report.ftl";
    private static final String OUTPUT_FILE = "report.html";

    public static void generateReport(List<Document> documents) {
        try {
            Configuration cfg = new Configuration(Configuration.VERSION_2_3_31);
            cfg.setClassForTemplateLoading(ReportCommand.class, "/");
            cfg.setDefaultEncoding("UTF-8");

            Template template = cfg.getTemplate(TEMPLATE_NAME);

            Map<String, Object> data = new HashMap<>();
            data.put("documents", documents);

            Writer out = new FileWriter(new File(OUTPUT_FILE));
            template.process(data, out);

            System.out.println("HTML report generated successfully!");
        } catch (IOException | TemplateException e) {
            e.printStackTrace();
        }
    }
    /**
     * when called, it creates and opens an HTML report representing the content of the catalog
     */
    @Override
    public void execute() throws IOException {
        Map<String, Object> data = new HashMap<>();
        data.put("documents", catalog.getDocuments());

        Configuration cfg = new Configuration(Configuration.VERSION_2_3_31);
        cfg.setClassForTemplateLoading(getClass(), "/");
        Template template = cfg.getTemplate("report-template.ftl");

        File reportFile = new File("report.html");
        Writer out = new FileWriter(reportFile);

        try {
            template.process(data, out);
        } catch (TemplateException e) {
            e.printStackTrace();
        }

        Desktop.getDesktop().browse(reportFile.toURI());
    }
}