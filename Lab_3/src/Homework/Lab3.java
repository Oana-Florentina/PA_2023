package Homework;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Lab3 {
    public static void main(String[] args) {
        Homework.Lab3 lab3 = new Homework.Lab3();
        lab3.homework();
    }

    public void homework() {
        Network network = new Network();
        List<Homework.Node> nodesList = new ArrayList<Node>();
        Person name1 = new Person("Florentina", "13/03/2003");
        Programmer name2 = new Programmer("Alex", "23/01/2002", "Java");
        Designer name3 = new Designer("Bianca", "22/02/2001", "Photoshop");
        Person name4 = new Person("Emima", "03/03/2000");
        Company company1 = new Company("Amazon");


        name1.addRelationship(name2, "Friends");
        company1.addRelationship(name3, "boss");
        company1.addRelationship(name2, "employee");
        name1.addRelationship(name3, "Friends");
        name2.addRelationship(name3, "Friends");
        name4.addRelationship(name2, "Friends");
        company1.addRelationship(name4, "employee");
        network.addNode(name1);
        network.addNode(name2);
        network.addNode(name3);
        network.addNode(name4);
        network.addNode(company1);
        network.printNetwork();

    }
}