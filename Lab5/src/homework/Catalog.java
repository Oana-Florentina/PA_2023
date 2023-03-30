package homework;
import homework.Document;
import homework.DocumentAlreadyExistsException;

import java.util.ArrayList;
import java.util.List;

public class Catalog {
    private List<Document> documents = new ArrayList<>();

    public void addDocument(Document doc) throws DocumentAlreadyExistsException {
        if (documents.contains(doc)) {
            throw new DocumentAlreadyExistsException("Document with ID " + doc.getId() + " already exists");
        }

        documents.add(doc);
    }

    public List<Document> getDocuments() {
        return documents;
    }
    public Document getDocument(String documentId) {
        for (Document doc : documents) {
            if (doc.getId().equals(documentId)) {
                return doc;
            }
        }
        throw new IllegalArgumentException("Document with ID " + documentId + " not found.");
    }


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

