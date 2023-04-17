package org.compulsory;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
class CatalogManager {
    private Catalog catalog = new Catalog();

    public void addDocument(Document doc) throws DocumentAlreadyExistsException, InvalidDocumentException {
        catalog.addDocument(doc);
    }

    public Catalog getCatalog() {
        return catalog;
    }

    public void saveCatalogToJsonFile(String filename) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(new File(filename), catalog);
    }

    public Catalog loadCatalogFromJsonFile(String filename) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        Catalog loadedCatalog = mapper.readValue(new File(filename), Catalog.class);
        catalog = loadedCatalog;
        return loadedCatalog;
    }
}