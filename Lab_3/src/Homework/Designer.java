package Homework;

import java.util.Date;

public class Designer extends Person {
    private String designSoftware;

    public Designer(String name, Date birthDate, String designSoftware) {
        super(name, birthDate);
        this.designSoftware = designSoftware;
    }

    public String getDesignSoftware() {
        return designSoftware;
    }
}
