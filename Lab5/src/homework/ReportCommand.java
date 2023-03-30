package homework;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import java.awt.Desktop;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class ReportCommand implements Command {
    private Catalog catalog;

    /**
     * constructor method, initialize the catalog
     *
     * @param catalog where a document will be added
     */
    public ReportCommand(Catalog catalog) {
        this.catalog = catalog;
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
