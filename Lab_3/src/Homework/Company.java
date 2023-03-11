package Homework;

public class Company implements Comparable<Company>, Node {
    private String name;
    public Company(String name) {
        this.name = name;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(Company other) {
        return this.name.compareTo(other.getName());
    }

    @Override
    public String toString() {
        return "Company:" +
                "name='" + name + '\'' ;
    }
}
