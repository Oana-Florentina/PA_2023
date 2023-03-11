package my_project;

import java.util.ArrayList;
import java.util.List;

public class Lab3 {
    public static void main(String[] args) {
        Lab3 lab3 = new Lab3();
        lab3.compulsory();
    }
    public void compulsory() {
        // create some my_project.Person and my_project.Company objects
        Person alice = new Person("Alice");
        Person bob = new Person("Bob");
        Company acme = new Company("Acme");
        Company beta = new Company("Beta");

        // create a List<my_project.Node> and add the objects to it
        List<Node> nodesList = new ArrayList<Node>();
        nodesList.add(alice);
        nodesList.add(bob);
        nodesList.add(acme);
        nodesList.add(beta);

        // print the List on the screen
        System.out.println("Nodes List: "+ nodesList );
    }
}
