package homework;
import java.util.*;
public class StudentProjectAllocationProblem {

    private List<Student> students;
    private Set<Project> projects;

    public StudentProjectAllocationProblem(List<Student> students, Set<Project> projects) {
        this.students = students;
        this.projects = projects;
    }

    public List<Student> getStudents() {
        return students;
    }

    public Set<Project> getProjects() {
        return projects;
    }

    public Set<Project> getAdmissibleProjectsForStudent(Student student) {
        Set<Project> admissibleProjects = new HashSet<>();
        for (Project project : projects) {
            if (student.isAdmissibleProject(project)) {
                admissibleProjects.add(project);
            }
        }
        return admissibleProjects;
    }

    public Set<Student> getAdmissibleStudentsForProject(Project project) {
        Set<Student> admissibleStudents = new HashSet<>();
        for (Student student : students) {
            if (project.isAdmissibleStudent(student)) {
                admissibleStudents.add(student);
            }
        }
        return admissibleStudents;
    }

    public Set<Pair<Student, Project>> findMaximumMatching() {
        // TODO: implement maximum matching algorithm
        return null;
    }

}