package Homework;

import java.util.Map;

public interface Node extends Comparable<Node>{
    public String getName();
    int computeImportance();

    void addRelationship(Person person, String relationshipType);

    Map<Node, String> getRelationships();


    int getImportance();
    @Override
    default int compareTo(Node other) {
        return Integer.compare(this.computeImportance(), other.computeImportance());
    }
}
