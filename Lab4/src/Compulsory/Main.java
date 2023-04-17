package org.compulsory;

import java.util.*;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {

        var students = IntStream.rangeClosed(0, 3)
                .mapToObj(i -> new Student("S" + i) )
                .toArray(Student[]::new);
        var projects = IntStream.rangeClosed(0, 3)
                .mapToObj(i -> new Project("S" + i) )
                .toArray(Project[]::new);

        students[0].addAdmissibleProject(projects[0]);
        students[0].addAdmissibleProject(projects[1]);
        students[0].addAdmissibleProject(projects[2]);
        students[1].addAdmissibleProject(projects[0]);
        students[1].addAdmissibleProject(projects[1]);
        students[2].addAdmissibleProject(projects[0]);



        LinkedList<Student> studentList = new LinkedList<>(Arrays.asList(students));

        studentList.sort(Student::compareTo);

        System.out.println("Sorted Students:");
        studentList.forEach(student -> System.out.println(student.getName()));

        
        TreeSet<Project> projectSet = new TreeSet<>(Arrays.asList(projects));

        System.out.println("Sorted Projects:");
        projectSet.forEach(project -> System.out.println(project.getName()));
    }
}