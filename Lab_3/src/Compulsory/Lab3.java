package Compulsory;

import java.util.ArrayList;
import java.util.List;

public class Lab3 {
    public static void main(String[] args) {
        Lab3 lab3 = new Lab3();
        lab3.compulsory();
    }
    public void compulsory() {

        Person alice = new Person("Flory");
        Person bob = new Person("Bianca");
        Company acme = new Company("Yonder");
        Company beta = new Company("Maxcode");

        List<Node> nodesList = new ArrayList<Node>();
        nodesList.add(alice);
        nodesList.add(bob);
        nodesList.add(acme);
        nodesList.add(beta);

        System.out.println("Nodes List: "+ nodesList );
    }
}
