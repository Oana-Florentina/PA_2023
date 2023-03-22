package homework;
import java.util.*;
import java.util.stream.Collectors;
import com.github.javafaker.Faker;

public class StudentProjectAllocationProblem {

    private List<Student> students;
    private Set<Project> projects;

    public StudentProjectAllocationProblem(int numStudents, int numProjects) {
       generateRandomNames(numStudents,numProjects);
    }

    public List<Student> getStudents() {
        return students;
    }

    public Set<Project> getProjects() {
        return projects;
    }
    public void generateRandomNames(int numStudents, int numProjects) {
        Faker faker = new Faker();

        // Generate random names for students
        List<Student> newStudents = new ArrayList<>();
        for (int i = 0; i < numStudents; i++) {
            String name = faker.name().fullName();
            Student student = new Student(name);
            newStudents.add(student);
        }
        students = newStudents;

        // Generate random names for projects
        Set<Project> newProjects = new HashSet<>();
        for (int i = 0; i < numProjects; i++) {
            String name = faker.harryPotter().spell();
            Project project = new Project(name);
            newProjects.add(project);
        }
        projects = newProjects;
    }
    public Set<Pair<Student, Project>> findMaximumMatching(List<Student> students,Set<Project> projects) {
        Set<Pair<Student, Project>> matching = new HashSet<>();
        List<Student> sortedStudents = students.stream()
                .sorted(Comparator.comparingInt(student -> -student.getAdmissibleProjects().size()))
                .collect(Collectors.toList());

        Set<Project> assignedProjects = new HashSet<>();

        for (Student student : sortedStudents) {
            for (Project project : student.getAdmissibleProjects()) {
                if (!assignedProjects.contains(project)) {
                    matching.add(new Pair<>(student, project));
                    assignedProjects.add(project);
                    break;
                }
            }
        }

        return matching;
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
    public List<Student> findStudentsWithFewerPreferences() {
        int numPreferencesSum = students.stream()
                .mapToInt(student -> student.getAdmissibleProjects().size())
                .sum();
        double numPreferencesAvg = numPreferencesSum / (double) students.size();

        List<Student> studentsWithFewerPreferences = students.stream()
                .filter(student -> student.getAdmissibleProjects().size() < numPreferencesAvg)
                .collect(Collectors.toList());

        return studentsWithFewerPreferences;
    }


}