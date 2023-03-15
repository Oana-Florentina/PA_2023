package Homework;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

public  class Person implements  Node {
    private String name;
    private LocalDate birthDate;



    private Map<Node, String> relationships = new HashMap<>();
    @Override
    public void addRelationship(Person person, String relationshipType) {
        relationships.put(person, relationshipType);
        person.getRelationships().put(this, relationshipType);
    }

    public Map<Node, String> getRelationships() {
        return relationships;
    }
    public void printRelationships() {
        for (Map.Entry<Node, String> entry : relationships.entrySet()) {
            Node node = entry.getKey();
            String relationshipType = entry.getValue();
            System.out.println(node.toString() + " - " + relationshipType);
        }
    }
    public Person(String name, String birthDate) {
        this.name = name;
        this.birthDate = LocalDate.parse(birthDate, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        this.relationships = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Person ");
        sb.append("name: ");
        sb.append(name);
        sb.append(", birthDate: ");
        sb.append(birthDate);
        sb.append(", relationships: [");
        boolean first = true;
        for (Map.Entry<Node, String> entry : relationships.entrySet()) {
            Node node = entry.getKey();
            String relationshipType = entry.getValue();
            if (node instanceof Person) {
                if (!first) {
                    sb.append(", ");
                }
                sb.append(((Person) node).getName());
                sb.append(" (");
                sb.append(relationshipType);
                sb.append(")");
                first = false;
            }
        }
        for (Map.Entry<Node, String> entry : relationships.entrySet()) {
            Node node = entry.getKey();
            String relationshipType = entry.getValue();
            if (node instanceof Company) {
                if (!first) {
                    sb.append(", ");
                }
                sb.append(((Company) node).getName());
                sb.append(" (");
                sb.append(relationshipType);
                sb.append(")");
                first = false;
            }
        }
        sb.append("]");
        return sb.toString();
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
