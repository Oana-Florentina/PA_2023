package homework;

import com.fasterxml.jackson.databind.ObjectMapper;
import homework.Catalog;
import homework.Document;
import homework.DocumentAlreadyExistsException;
import homework.InvalidDocumentException;

import java.io.File;
import java.io.IOException;

class CatalogManager {
    private homework.Catalog catalog = new homework.Catalog();

    public void addDocument(Document doc) throws DocumentAlreadyExistsException, InvalidDocumentException {
        catalog.addDocument(doc);
    }

    public homework.Catalog getCatalog() {
        return catalog;
    }

    public void saveCatalogToJsonFile(String filename) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(new File(filename), catalog);
    }

    public homework.Catalog loadCatalogFromJsonFile(String filename) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        homework.Catalog loadedCatalog = mapper.readValue(new File(filename), Catalog.class);
        catalog = loadedCatalog;
        return loadedCatalog;
    }
}