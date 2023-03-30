package homework;

import java.awt.*;
import java.io.File;
import java.io.IOException;
/**
 * A command that opens the file associated with a given document in the system's default application.
 */
public class ViewCommand implements Command {
    private final Catalog catalog;
    private final String documentId;

    public ViewCommand(Catalog catalog, String documentId) {
        this.catalog = catalog;
        this.documentId = documentId;
    }
    /**
     * Opens the file associated with the document specified in the constructor in the system's default application.
     *
     * @throws IOException if there was an error opening the file
     * @throws IllegalArgumentException if the document with the given ID could not be found in the catalog
     * @throws UnsupportedOperationException if the system does not support opening files with a default application
     */
    @Override
    public void execute() throws IOException {
        Document doc = catalog.getDocument(documentId);
        if (doc == null) {
            throw new IllegalArgumentException("Document with id " + documentId + " not found");
        }
        String path = doc.getPath();
        if (Desktop.isDesktopSupported()) {
            Desktop.getDesktop().open(new File(path));
        } else {
            throw new UnsupportedOperationException("Desktop not supported");
        }
    }

}

