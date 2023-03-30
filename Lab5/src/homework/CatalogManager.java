package homework;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
/**
 * The CatalogManager class manages the Catalog object and provides methods to add documents to the catalog,
 * save the catalog to a JSON file, and load a catalog from a JSON file.
 */
class CatalogManager {
    private homework.Catalog catalog = new homework.Catalog();
    /**
     * Adds a document to the catalog.
     *
     * @param doc the document to be added to the catalog
     * @throws DocumentAlreadyExistsException if the document already exists in the catalog
     * @throws InvalidDocumentException if the document is invalid
     */
    public void addDocument(Document doc) throws DocumentAlreadyExistsException, InvalidDocumentException {
        catalog.addDocument(doc);
    }

    public homework.Catalog getCatalog() {
        return catalog;
    }
    /**
     * Saves the catalog to a JSON file.
     *
     * @param filename the name of the file to save the catalog to
     * @throws IOException if there is an error writing to the file
     */
    public void saveCatalogToJsonFile(String filename) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(new File(filename), catalog);
    }
    /**
     * Loads a catalog from a JSON file and sets it as the catalog managed by the CatalogManager.
     *
     * @param filename the name of the file to load the catalog from
     * @return the loaded catalog
     * @throws IOException if there is an error reading from the file
     */
    public homework.Catalog loadCatalogFromJsonFile(String filename) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        homework.Catalog loadedCatalog = mapper.readValue(new File(filename), Catalog.class);
        catalog = loadedCatalog;
        return loadedCatalog;
    }
}