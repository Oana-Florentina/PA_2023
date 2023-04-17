package homework;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Catalog catalog = new Catalog();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Enter a command (add, list, report, view, exit): ");
            String input = scanner.nextLine();
            String[] tokens = input.split("\\s+");

            try {
                if (tokens[0].equals("add")) {
                    if (tokens.length != 5) {
                        throw new IllegalArgumentException("Invalid command arguments. Usage: add id name path url");
                    }
                    Document document = new Document(tokens[1], tokens[2], tokens[3], tokens[4], new HashMap<>());
                    Command command = new AddCommand(catalog, document);
                    command.execute();
                } else if (tokens[0].equals("list")) {
                    System.out.println(catalog);
                } else if (tokens[0].equals("report")) {
                    Configuration configuration = new Configuration(Configuration.getVersion());
                    configuration.setClassForTemplateLoading(Main.class, "/");
                    Template template = configuration.getTemplate("report.ftl");

                    Map<String, Object> data = new HashMap<>();
                    data.put("documents", catalog.getDocuments());

                    File file = new File("report.html");
                    FileWriter writer = new FileWriter(file);
                    template.process(data, writer);
                    writer.close();

                    System.out.println("Report created: " + file.getAbsolutePath());
                } else if (tokens[0].equals("view")) {
                    if (tokens.length != 2) {
                        throw new IllegalArgumentException("Invalid command arguments. Usage: view id");
                    }
                    Command command = new ViewCommand(catalog, tokens[1]);
                    command.execute();
                } else if (tokens[0].equals("exit")) {
                    break;
                } else {
                    throw new IllegalArgumentException("Invalid command");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        ReportCommand report = new ReportCommand();
        try {
            report.execute();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        scanner.close();
    }
}
