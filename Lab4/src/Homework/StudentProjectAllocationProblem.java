package homework;
import java.util.*;
import java.util.stream.Collectors;

public class StudentProjectAllocationProblem {

    private List<Student> students;
    private Set<Project> projects;
    private Set<Pair<Student, Project>> matchings;

    public StudentProjectAllocationProblem(List<Student> students, Set<Project> projects) {
        this.students = students;
        this.projects = projects;
        this.matchings = new HashSet<>();

    }


    public List<Student> getStudents() {
        return students;
    }

    public void getProjects() {
        System.out.println("Projects: ");
        for (Project project : projects) {
            System.out.println(project.getName());
        }
    }

    public void addMatching(Student student, Project project) {
        Pair<Student, Project> pair = new Pair<>(student, project);
        matchings.add(pair);
        student.addAdmissibleProject(project);
    }

    public void getMatching() {
        for (Student student : students) {
            student.getMatching(matchings);
        }
    }

    public Set<Pair<Student, Project>> findMaximumMatchingGreedy(List<Student> students, TreeSet<Project> projects) {
        Set<Pair<Student, Project>> matching = new HashSet<>();

        // we need to sort students by decreasing order of admissible projects
        List<Student> sortedStudents = students.stream()
                .sorted(Comparator.comparingInt(student -> -student.getAdmissibleProjects().size()))
                .collect(Collectors.toList());

        for (Student student : sortedStudents) {
            for (Project project : projects) {// if a preferred project is still available, we assign it to the student
                if (project.isAdmissibleStudent(student)) {
                    matching.add(new Pair<>(student, project));
                    projects.remove(project);
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

    public void getAdmissibleProjectList() {
        for (Student student : students) {
            Set<Project> admissibleProjects = getAdmissibleProjectsForStudent(student);
            System.out.println("Admissible projects for " + student.getName() + ":");
            for (Project project : admissibleProjects) {
                System.out.println("\t" + project.getName());
            }
        }
    }

    public void findStudentsWithFewerPreferences() {
        double numPreferencesAvg = students.stream()
                .mapToInt(student -> student.getAdmissibleProjects().size())
                .average()
                .orElse(0);

        List<Student> studentsWithFewerPreferences = students.stream()
                .filter(student -> student.getAdmissibleProjects().size() < numPreferencesAvg)
                .collect(Collectors.toList());

        System.out.println("Students with fewer preferences than average:");
        studentsWithFewerPreferences.forEach(student -> System.out.println(student.getName()));
    }

}