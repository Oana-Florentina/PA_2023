package homework;




import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Student implements Comparable<Student> {
    private String name;
    private List<Project> admissibleProjects;

    public Student(String name) {
        this.name = name;
        this.admissibleProjects = new ArrayList<Project>();
    }
    @Override
    public int compareTo(Student other) {
        return this.name.compareTo(other.getName());
    }
    public String getName() {
        return name;
    }

    public List<Project> getAdmissibleProjects() {
        return admissibleProjects;
    }

    public void addAdmissibleProject(Project project) {
        admissibleProjects.add(project);
    }


    public boolean isAdmissibleProject(Project project) {
        for (Project admissibleProject : admissibleProjects) {
            if (admissibleProject.equals(project)) {
                return true;
            }
        }
        return false;
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

    @Override
    public int hashCode() {
        return Objects.hash(this.name, this.admissibleProjects);
    }
}
