package Homework;

/**
 * The BaseEntity class is an abstract class that represents an entity with an ID.
 */
public abstract class BaseEntity {
    protected Integer id;

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }
}
