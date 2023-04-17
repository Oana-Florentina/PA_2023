package org.compulsory;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        CatalogManager catalogManager = new CatalogManager();

        // add some documents to the catalog
        try {
           // Map<String, String> tags = new HashMap<>();
            Map<String, String> tags = new HashMap<>();
            tags.put("title", "Article 1");
            tags.put("author", "John Doe");
            tags.put("year", "2022");
            Document article = new Document("article", "Article 1", "idk", "http://example.com/article1",tags );
            catalogManager.addDocument(article);


        } catch (DocumentAlreadyExistsException | InvalidDocumentException e) {
            System.err.println("Error adding document to catalog: " + e.getMessage());
            return;
        }

        // print the catalog
        System.out.println(catalogManager.getCatalog().toString());

        // save the catalog to a file
        try {
            catalogManager.saveCatalogToJsonFile("catalog.json");
            System.out.println("Catalog saved to catalog.json");
        } catch (IOException e) {
            System.err.println("Error saving catalog to file: " + e.getMessage());
            return;
        }

        // load the catalog from the file
        try {
            Catalog loadedCatalog = catalogManager.loadCatalogFromJsonFile("catalog.json");
            System.out.println("Catalog loaded from catalog.json:");
            System.out.println(loadedCatalog.toString());
        } catch (IOException e) {
            System.err.println("Error loading catalog from file: " + e.getMessage());
            return;
        }
    }
}