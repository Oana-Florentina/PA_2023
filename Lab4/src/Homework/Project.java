package homework;
import com.github.javafaker.Faker;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Project implements Comparable<Project> {
    private String name;
    private List<Student> admissibleStudents;
    Faker faker = new Faker();

    public Project() {
        this.name = faker.color().name() + " Project";
        ;
        this.admissibleStudents = new ArrayList<Student>();

    }

    public String getName() {
        return name;
    }

    public List<Student> getAdmissibleStudents() {
        return admissibleStudents;
    }


    public boolean isAdmissibleStudent(Student student) {
        for (Student admissibleStudent : admissibleStudents) {
            if (admissibleStudent.equals(student)) {
                return true;
            }
        }
        return false;
    }
    @Override
    public int compareTo(Project other) {
        return this.name.compareTo(other.getName());
    }
    @Override
    public int hashCode() {
        return Objects.hash(this.name);
    }

    public void addAdmissibleStudent(Student student) {
        admissibleStudents.add(student);
    }
}
