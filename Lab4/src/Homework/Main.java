package homework;
import com.github.javafaker.Faker;
import java.util.*;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        StudentProjectAllocationProblem problem = new StudentProjectAllocationProblem(5,8);
        TreeSet<Project> projectSet = new TreeSet<>(Arrays.asList(problem.getProjects().toArray(new Project[0])));


        LinkedList<Student> studentList = new LinkedList<>(problem.getStudents());

        System.out.println("Students:");
        studentList.forEach(student -> System.out.println(student.getName()));

        System.out.println("Projects:");
        projectSet.forEach(project -> System.out.println(project.getName()));


        List<Student> students = problem.getStudents();

        students.get(0).addAdmissibleProject(projectSet.ceiling(new Project("Project 3")));
        students.get(0).addAdmissibleProject(projectSet.ceiling(new Project("Project 4")));
        students.get(1).addAdmissibleProject(projectSet.ceiling(new Project("Project 3")));
        students.get(1).addAdmissibleProject(projectSet.ceiling(new Project("Project 4")));
        students.get(1).addAdmissibleProject(projectSet.ceiling(new Project("Project 5")));
        students.get(1).addAdmissibleProject(projectSet.ceiling(new Project("Project 6")));
        students.get(2).addAdmissibleProject(projectSet.ceiling(new Project("Project 1")));
        students.get(2).addAdmissibleProject(projectSet.ceiling(new Project("Project 4")));

        List<Student> studentsWithFewerPreferences = problem.findStudentsWithFewerPreferences();
        System.out.println("Students with fewer preferences than the average:");
        studentsWithFewerPreferences.forEach(student -> System.out.println(student.getName()));
        Set<Pair<Student, Project>> matching= problem.findMaximumMatching(students,projectSet);
        // Print the matching
        System.out.println("Matchings:");
        for (Pair<Student, Project> pair : matching) {
            System.out.println(pair.getFirst().getName() + " is assigned to project " + pair.getSecond().getName());
        }
        System.out.println("Matching size: " + matching.size());
    }
}