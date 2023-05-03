package Homework;


import java.sql.Connection;
import java.sql.SQLException;

/**
 * The GenericDAO class is an abstract class that defines a generic interface for performing CRUD (Create, Read, Update, Delete) operations on entities in a database.
 *
 * @param <T> the type of the entity to perform operations on, must extend the BaseEntity class
 */
public abstract class GenericDAO<T extends BaseEntity> {
    protected final Connection connection;

    public GenericDAO(Connection connection) {
        this.connection = connection;
    }

    public abstract void create(T entity) throws SQLException;

    public abstract T findById(int id) throws SQLException;

    public abstract T findByName(String name) throws SQLException;

}
