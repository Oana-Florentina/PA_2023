package Homework;

/**
 * The Genre class represents a genre with a name.
 */
public class Genre extends BaseEntity {
    private String name;

    public Genre() {
        this.name = null;
        this.id = null;
    }

    public Genre(String name) {
        this.name = name;
        this.id = null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}