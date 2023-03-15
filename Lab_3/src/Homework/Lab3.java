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
        Person name1 = new Person("Florentina", "13/03/2003");
        Programmer name2 = new Programmer("Alex", "23/01/2002", "Java");
        Designer name3 = new Designer("Bianca", "22/02/2001", "Photoshop");
        Company company1 = new Company("Amazon");
        List<Homework.Node> nodesList = new ArrayList<Node>();

        name1.addRelationship(name2, "Friends");
        company1.addRelationship(name3, "boss");
        company1.addRelationship(name2, "employee");
        name1.addRelationship(name3, "Friends");
        network.addNode(name1);
        network.addNode(name2);
        network.addNode(name3);
        network.addNode(company1);
        List<Node> nodes = network.getNodes();
        for (Node node : nodes) {
            System.out.println(node.toString());
        }
    }
}