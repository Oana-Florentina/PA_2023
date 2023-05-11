package Repositories;

import factory.EntityManagerHibernate;

import java.util.List;
import java.io.Serializable;

/**
 * The Repository class is an abstract class that defines the operations
 * that can be performed on entities. Each entity class will have a corresponding Repository class that extends this
 * class to provide the specific implementation for that entity.
 *
 * @param <T>  The entity type that this Repository works with.
 * @param <ID> The type of the ID field for the entity.
 */
public abstract class Repository<T, ID extends Serializable> {
    protected EntityManagerHibernate session;

    /**
     * Constructs a new Repository object with a new EntityManagerHibernate session.
     *
     * @throws Exception If there is an error creating the EntityManagerHibernate object.
     */
    public Repository() throws Exception {
        this.session = this.session = new EntityManagerHibernate();
    }

    /**
     * Finds an entity by its ID.
     *
     * @param id The ID of the entity to find.
     * @return The entity with the specified ID, or null if no such entity exists.
     */
    public abstract T findById(ID id);

    public abstract List<T> findAll();

    public abstract void deleteById(ID id);

    public abstract void deleteAll();

    public abstract void save(T IEntity);

    public abstract void saveAll(List<T> entities);
}
