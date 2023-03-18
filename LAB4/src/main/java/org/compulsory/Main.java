package org.compulsory;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {

        Student[] students = Arrays.stream(new String[]{"S0", "S1", "S2"})
                .map(Student::new)
                .toArray(Student[]::new);


        Project[] projects = Arrays.stream(new String[]{"P0", "P1", "P2"})
                .map(Project::new)
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