package homework;

import java.util.Map;
/**
 * The Catalog class represents a document.
 */
public class Document {
    private String id;
    private String name;
    private String path;
    private String url;
    private Map<String, String> tags;
    /**
     * Constructor for creating a new Document instance.
     *
     * @param id      the ID of the document
     * @param name    the name of the document
     * @param location    the location of the document
     * @param url     the URL of the document
     * @param tags    the tags associated with the document
     */
    public Document(String id, String name, String location, String url, Map<String, String> tags) {
        this.id = id;
        this.name = name;
        this.path = location;
        this.url=url;
        this.tags = tags;
    }
    /**
     * Default constructor required for deserialization from JSON.
     */
    public Document() {
        // default constructor required for deserialization from JSON
    }
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPath() {
        return path;
    }

    public String getUrl() {
        return url;
    }

    public Map<String, String> getTags() {
        return tags;
    }

    public void setTags(Map<String, String> tags) {
        this.tags = tags;
    }
    /**
     * Returns a string representation of the document.
     *
     * @return a string representation of the document
     */
    @Override
    public String toString() {
        return "Document{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", location='" + path + '\'' +
                ", url='" + url + '\'' +
                ", tags=" + tags +
                '}';
    }

}
