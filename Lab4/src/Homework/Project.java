package homework;
import java.util.ArrayList;
import java.util.List;
public class Project implements Comparable<Project> {
    private String name;
    private List<Student> admissibleStudents;

    public Project(String name) {
        this.name = name;
        this.admissibleStudents = new ArrayList<Student>();

    }

    public String getName() {
        return name;
    }

    public List<Student> getAdmissibleStudents() {
        return admissibleStudents;
    }

    public void addAdmissibleStudent(Student student) {
        admissibleStudents.add(student);
    }

    @Override
    public int compareTo(Project other) {
        return this.name.compareTo(other.getName());
    }

    public boolean isAdmissibleStudent(Student student) {
        for (Student admissibleStudent : admissibleStudents) {
            if (admissibleStudent.equals(student)) {
                return true;
            }
        }
        return false;
    }
}
