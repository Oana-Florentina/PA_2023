package org.compulsory;

import java.util.ArrayList;
import java.util.List;

public class Matching {
    private List<Pair<Student, Project>> pairs;

    public Matching() {
        pairs = new ArrayList<Pair<Student, Project>>();
    }

    public List<Pair<Student, Project>> getPairs() {
        return pairs;
    }

    public void addPair(Student student, Project project) {
        pairs.add(new Pair<Student, Project>(student, project));
    }
}