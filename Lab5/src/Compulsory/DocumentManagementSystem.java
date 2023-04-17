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

public class DocumentManagementSystem {
    public static void main(String[] args) {
        CatalogManager manager = new CatalogManager();

        try {
            Map<String, String> tags = new HashMap<String, String>();
            tags.put("author", "John Doe");
            tags.put("year", "2022");
            manager.addDocument(new Document("id2", "document2", null, "https://example.com/document2.html", tags));

            manager.saveCatalogToJsonFile("catalog.json");
            Catalog loadedCatalog = manager.loadCatalogFromJsonFile("catalog.json");
            System.out.println(loadedCatalog);
        } catch (DocumentAlreadyExistsException e) {
            System.err.println("Error: " + e.getMessage());
        } catch (JsonParseException e) {
            System.err.println("Error parsing JSON: " + e.getMessage());
        } catch (JsonMappingException e) {
            System.err.println("Error mapping JSON to object: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Error reading or writing file: " + e.getMessage());
        } catch (InvalidDocumentException e) {
            System.err.println("Error adding document: " + e.getMessage());
        }
    }
}
