package homework;


import java.util.ArrayList;
import java.util.List;

public class Matching {
    private List<homework.Pair<homework.Student, homework.Project>> pairs;

    public Matching() {
        pairs = new ArrayList<homework.Pair<homework.Student, homework.Project>>();
    }

    public List<homework.Pair<homework.Student, homework.Project>> getPairs() {
        return pairs;
    }

    public void addPair(homework.Student student, homework.Project project) {
        pairs.add(new Pair<Student, Project>(student, project));
    }
}