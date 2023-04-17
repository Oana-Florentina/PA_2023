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
        Set<Project> assignedProjects = new HashSet<>();

        List<Student> sortedStudents = students.stream()
                .sorted(Comparator.comparingInt(student -> -student.getAdmissibleProjects().size()))
                .collect(Collectors.toList());

        for (Student student : sortedStudents) {
            for (Project project : projects) {
                if (!assignedProjects.contains(project) && project.isAdmissibleStudent(student)) {
                    matching.add(new Pair<>(student, project));
                    addMatching(student, project);
                    assignedProjects.add(project);
                    break;
                }
            }
        }

        return matching;
    }
    public  String pairSetToString(Set<Pair<Student, Project>> pairSet) {
        StringBuilder sb = new StringBuilder();
        for (Pair<Student, Project> pair : pairSet) {
            sb.append(pair.getFirst().getName())
                    .append(" - ")
                    .append(pair.getSecond().getName())
                    .append("\n");
        }
        return sb.toString();
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