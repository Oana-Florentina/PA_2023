package Compulsory;

import java.util.ArrayList;
import java.util.List;

public class Lab3 {
    public static void main(String[] args) {
        Lab3 lab3 = new Lab3();
        lab3.compulsory();
    }
    public void compulsory() {

        Person name1 = new Person("Flory");
        Person name2 = new Person("Bianca");
        Company comp1 = new Company("Yonder");
        Company comp2 = new Company("Continental");

        List<Node> nodesList = new ArrayList<Node>();
        nodesList.add(name1);
        nodesList.add(name2);
        nodesList.add(comp1);
        nodesList.add(comp2);

        System.out.println("Nodes List: "+ nodesList );
    }
}
