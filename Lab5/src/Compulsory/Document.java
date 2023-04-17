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
public class Document {
    private String id;
    private String name;
    private String path;
    private String url;
    private Map<String, String> tags;

    public Document(String id, String name, String location,String url, Map<String, String> tags) {
        this.id = id;
        this.name = name;
        this.path = location;
        this.url=url;
        this.tags = tags;
    }
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
