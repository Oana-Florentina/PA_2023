package homework;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

public class AddCommand implements Command {
    private Catalog catalog;
    private Document document;

    /**
     * constructor method, initialize the catalog and document
     *
     * @param catalog  where a document will be added
     * @param document the document to be added
     */
    public AddCommand(Catalog catalog, Document document) {
        this.catalog = catalog;
        this.document = document;
    }

    /**
     * when called, it adds the document in the current catalog
     */
    @Override
    public void execute() throws DocumentAlreadyExistsException {
        catalog.addDocument(document);
        System.out.println("New document added!");
    }
}