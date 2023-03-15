package Homework;

import java.time.LocalDate;
import java.util.Date;

public class Designer extends Person {
    private String designSoftware;

    public Designer(String name, String birthDate, String designSoftware) {
        super(name, birthDate);
        this.designSoftware = designSoftware;
    }

    public String getDesignSoftware() {
        return designSoftware;
    }
}
