package homework;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class ViewCommand implements Command {
    private final Catalog catalog;
    private final String documentId;

    public ViewCommand(Catalog catalog, String documentId) {
        this.catalog = catalog;
        this.documentId = documentId;
    }

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

