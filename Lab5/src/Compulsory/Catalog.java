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
public class Catalog {
    private List<Document> documents = new ArrayList<Document>();

    public void addDocument(Document doc) throws DocumentAlreadyExistsException {
        if (documents.contains(doc)) {
            throw new DocumentAlreadyExistsException("Document with ID " + doc.getId() + " already exists");
        }

        documents.add(doc);
    }

    public List<Document> getDocuments() {
        return documents;
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

