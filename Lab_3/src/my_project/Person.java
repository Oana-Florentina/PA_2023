package my_project;

public  class Person implements Comparable<Person>, Node {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person " +
                "name: " + name + '\'' ;
    }

    public Person(String name) {
        this.name = name;
    }
    @Override
    public int compareTo(Person other) {
        return this.name.compareTo(other.getName());
    }
}
