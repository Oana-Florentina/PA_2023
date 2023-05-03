package Homework;

/**
 * The Artist class represents an artist with a name.
 */
public class Artist extends BaseEntity {
    private String name;

    /**
     * Constructs an empty artist with default values for all fields.
     */
    public Artist() {
        this.name = null;
        this.id = null;
    }

    /**
     * Constructs an artist with the specified name.
     *
     * @param name the name of the artist
     */
    public Artist(String name) {
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
