package Homework;

import Compulsory.Node;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Lab3 {
    public static void main(String[] args) {
        Homework.Lab3 lab3 = new Homework.Lab3();
        lab3.homework();
    }

    public void homework() {
        Date date1 = new Date(103, 2, 13);
        Person name1 = new Person("Florentina", date1);
        Programmer name2 = new Programmer("Alex", new Date(), "Java");
        Designer  name3= new Designer("Bianca", new Date(), "Photoshop");
        Company company1 = new Company("Amazon");
        List<Compulsory.Node> nodesList = new ArrayList<Node>();
        nodesList.add(name1);
        nodesList.add(name2);
        System.out.println("Nodes List: "+ nodesList );
    }
}