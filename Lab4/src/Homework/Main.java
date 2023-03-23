package homework;
import java.util.*;


public class Main {
    public static void main(String[] args) {

        List<Student> students = new ArrayList<>();
        TreeSet<Project> projects = new TreeSet<>();
        StudentProjectAllocationProblem problem = new StudentProjectAllocationProblem(students, projects);

        Student student0 = new Student();
        students.add(student0);
        Student student1 = new Student();
        students.add(student1);
        Student student2 = new Student();
        students.add(student2);

        Project project0 = new Project();
        projects.add(project0);
        Project project1 = new Project();
        projects.add(project1);
        Project project2 = new Project();
        projects.add(project2);
        Project project3 = new Project();
        projects.add(project3);


        System.out.println("Students: ");
        for (Student student : students) {
            System.out.println(student.getName());
        }

        Set<Pair<Student, Project>> matching = problem.findMaximumMatchingGreedy(students, projects);

        matching.add(new Pair<>(student1, project1));
        problem.addMatching(student1, project1);

        matching.add(new Pair<>(student1, project0));
        problem.addMatching(student1, project0);

        matching.add(new Pair<>(student0, project0));
        problem.addMatching(student0, project0);

        matching.add(new Pair<>(student0, project1));
        problem.addMatching(student0, project1);

        matching.add(new Pair<>(student0, project2));
        problem.addMatching(student0, project2);

        matching.add(new Pair<>(student2, project2));
        problem.addMatching(student2, project2);


        System.out.println("Matching size: " + matching.size());


        problem.getMatching();
        problem.getProjects();
        problem.getAdmissibleProjectList();
        problem.findStudentsWithFewerPreferences();
    }

}
