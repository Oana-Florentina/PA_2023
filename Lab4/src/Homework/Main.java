package homework;
import java.util.*;
import java.util.stream.IntStream;


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


        student0.addAdmissibleProject(project0);
        student0.addAdmissibleProject(project1);
        student0.addAdmissibleProject(project2);

        student1.addAdmissibleProject(project0);
        student1.addAdmissibleProject(project1);

        student2.addAdmissibleProject(project0);


        project0.addAdmissibleStudent(student0);
        project0.addAdmissibleStudent(student1);
        project0.addAdmissibleStudent(student2);

        project1.addAdmissibleStudent(student1);
        project1.addAdmissibleStudent(student0);

        project2.addAdmissibleStudent(student0);

        problem.getAdmissibleProjectList();
        problem.findStudentsWithFewerPreferences();
        problem.getProjects();

        Set<Pair<Student, Project>> matching = problem.findMaximumMatchingGreedy(students, projects);
        System.out.println("Matching size: " + matching.size());

        String output = problem.pairSetToString(matching);
        System.out.println(output);




    }

}
