package Homework;

import java.util.Map;

public interface Node {
    public String getName();
    int computeImportance();

    void addRelationship(Person person, String relationshipType);

    Map<Node, String> getRelationships();


    int getImportance();
}
