package homework;
import java.util.ArrayList;
import java.util.List;
/**
 * The Catalog class represents a collection of documents.
 */
public class Catalog {
    private List<Document> documents = new ArrayList<>();
    /**
     * Adds a document to the catalog.
     *
     * @param doc the document to be added
     * @throws DocumentAlreadyExistsException if a document with the same ID already exists in the catalog
     */
    public void addDocument(Document doc) throws DocumentAlreadyExistsException {
        if (documents.contains(doc)) {
            throw new DocumentAlreadyExistsException("Document with ID " + doc.getId() + " already exists");
        }

        documents.add(doc);
    }
    /**
     * Returns a list of all documents in the catalog.
     *
     * @return a list of all documents in the catalog
     */
    public List<Document> getDocuments() {
        return documents;
    }

    /**
     * Returns the document with the specified ID.
     *
     * @param documentId the ID of the document to retrieve
     * @return the document with the specified ID
     * @throws IllegalArgumentException if the document with the specified ID is not found
     */
    public Document getDocument(String documentId) {
        for (Document doc : documents) {
            if (doc.getId().equals(documentId)) {
                return doc;
            }
        }
        throw new IllegalArgumentException("Document with ID " + documentId + " not found.");
    }
    /**
     * Returns a string representation of the catalog.
     *
     * @return a string representation of the catalog
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (Document doc : documents) {
            sb.append(doc.toString());
            sb.append("\n");
        }
        return sb.toString();
    }
}

