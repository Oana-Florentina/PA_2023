/**
 * The EntityManagerHibernate class represents a factory for creating EntityManagers using Hibernate ORM.
 */
package factory;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityManager;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class EntityManagerHibernate {
    /**
     * The sessionFactory field represents the EntityManagerFactory used for creating EntityManagers.
     */
    private EntityManagerFactory sessionFactory;

    /**
     * Constructs a new EntityManagerHibernate instance and initializes the sessionFactory field with a Hibernate
     * EntityManagerFactory created from the Hibernate configuration file.
     *
     * @throws Exception if an error occurs during sessionFactory initialization.
     */
    public EntityManagerHibernate() throws Exception {
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure()
                .build();
        try {
            sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
        } catch (Exception e) {
            StandardServiceRegistryBuilder.destroy(registry);
        }

    }

    /**
     * Creates and returns a new EntityManager instance.
     *
     * @return a new EntityManager instance.
     */
    public EntityManager getEntityManager() {
        return sessionFactory.createEntityManager();
    }

    /**
     * Closes the EntityManagerFactory if it is not null.
     *
     * @throws Exception if an error occurs while closing the EntityManagerFactory.
     */
    public void tearDown() throws Exception {
        if (sessionFactory != null) {
            sessionFactory.close();
        }
    }


}
