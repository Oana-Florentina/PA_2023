package homework;

import com.github.javafaker.Faker;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class Student implements Comparable<Student> {
    private String name;
    private List<Project> admissibleProjects;
    Faker faker = new Faker();
    public Student() {
        this.name = faker.name().fullName();;
        this.admissibleProjects = new ArrayList<>();
    }

    @Override
    public int compareTo(Student other) {
        return this.name.compareTo(other.getName());
    }

    public String getName() {
        return name;
    }

    public void getMatching(Set<Pair<Student, Project>> matching) {
        System.out.print("Student " + this.getName() + " has matching projects: ");
        matching.stream()
                .filter(pair -> pair.getFirst().equals(this))
                .forEach(pair -> System.out.print(pair.getSecond().getName() + ", "));
        System.out.println();
    }
    public List<Project> getAdmissibleProjects() {
        return admissibleProjects;
    }

    public void addAdmissibleProject(Project project) {
        admissibleProjects.add(project);
    }


    public boolean isAdmissibleProject(Project project) {
        return admissibleProjects.contains(project);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Student)) {
            return false;
        }
        Student other = (Student) obj;
        return Objects.equals(this.name, other.getName()) &&
                Objects.equals(this.admissibleProjects, other.getAdmissibleProjects());
    }


}
