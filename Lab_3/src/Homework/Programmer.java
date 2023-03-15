package Homework;

import java.util.Date;

public class Programmer extends Person {
    private String programmingLanguage;

    public Programmer(String name, String birthDate, String programmingLanguage) {
        super(name, birthDate);
        this.programmingLanguage = programmingLanguage;
    }

    public String getProgrammingLanguage() {
        return programmingLanguage;
    }
}