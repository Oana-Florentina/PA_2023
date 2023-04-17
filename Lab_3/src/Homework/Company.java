package Homework;

import java.util.HashMap;
import java.util.Map;

public class Company implements  Node {
    private String name;
    private Map<Node, String> relationships = new HashMap<>();
    public Company(String name) {
        this.name = name;
        this.relationships = new HashMap<>();
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Company: ");
        sb.append("name='");
        sb.append(name);
        sb.append("', relationships: [");
        boolean first = true;
        for (Map.Entry<Node, String> entry : relationships.entrySet()) {
            Node node = entry.getKey();
            String position = entry.getValue();
            if (!first) {
                sb.append(", ");
            }
            sb.append(node.getName());
            sb.append(" (");
            sb.append(position);
            sb.append(")");
            first = false;
        }
        sb.append("]");
        return sb.toString();
    }
    @Override
    public void addRelationship(Person person, String relationshipType) {
        relationships.put(person, relationshipType);
        person.getRelationships().put(this, relationshipType);
    }

    public Map<Node, String> getRelationships() {
        return relationships;
    }
    @Override
    public int getImportance() {
        return relationships.size();
    }
    @Override
    public int computeImportance() {
        return relationships.size();
    }

}
