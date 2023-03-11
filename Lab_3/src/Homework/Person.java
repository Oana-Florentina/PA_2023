package Homework;

import Compulsory.Node;

import java.util.Date;

public  class Person implements Comparable<Homework.Person>, Node {
    private String name;
    private Date birthDate;

    public Person(String name, Date birthDate) {
        this.name = name;
        this.birthDate = birthDate;
    }

    public String getName() {
        return name;
    }

    public Date getBirthDate() {
        return birthDate;
    }
    @Override
    public String toString() {
        return "Person " +
                "name: " + name + ','+ birthDate+ '\'' ;
    }
    @Override
    public int compareTo(Person other) {
        return this.name.compareTo(other.getName());
    }
}
