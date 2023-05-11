package Repositories;

import datatypes.Album;
import factory.EntityManagerHibernate;
import jakarta.persistence.EntityManager;

import java.util.List;

/**
 * A repository class for managing albums in the database.
 */
public class AlbumRepository extends Repository<Album, Integer> {
    /**
     * Initializes a new instance of the {@link AlbumRepository} class.
     *
     * @throws Exception if there was an error initializing the entity manager.
     */
    public AlbumRepository() throws Exception {
        this.session = new EntityManagerHibernate();
    }

    /**
     * Finds an album by its ID.
     *
     * @param integer the ID of the album to find.
     * @return the album with the specified ID.
     */
    @Override
    public Album findById(Integer integer) {
        return (Album) session.getEntityManager().createNamedQuery("Album.findById").setParameter(1, integer).getSingleResult();
    }

    /**
     * Finds all albums in the database.
     *
     * @return a list of all albums in the database.
     */
    @Override
    public List<Album> findAll() {
        return session.getEntityManager().createNamedQuery("Album.findAll").getResultList();
    }

    /**
     * Deletes an album by its ID.
     *
     * @param integer the ID of the album to delete.
     */
    @Override
    public void deleteById(Integer integer) {
        EntityManager currentSession = session.getEntityManager();
        currentSession.getTransaction().begin();
        currentSession.createNamedQuery("Album.deleteById").setParameter(1, integer).executeUpdate();
        currentSession.getTransaction().commit();

    }

    @Override
    public void deleteAll() {
        EntityManager currentSession = session.getEntityManager();
        currentSession.getTransaction().begin();
        currentSession.createNamedQuery("Album.deleteAll").executeUpdate();
        currentSession.getTransaction().commit();
    }

    /**
     * Saves an album to the database.
     *
     * @param obj the album to save.
     */
    @Override
    public void save(Album obj) {
        EntityManager currentSession = session.getEntityManager();
        currentSession.getTransaction().begin();
        currentSession.persist(obj);
        currentSession.getTransaction().commit();
    }

    /**
     * Saves a list of albums to the database.
     *
     * @param entities the list of albums to save.
     */
    @Override
    public void saveAll(List<Album> entities) {

        EntityManager currentSession = session.getEntityManager();
        currentSession.getTransaction().begin();
        for (var obj : entities) {
            currentSession.persist(obj);
        }
        currentSession.getTransaction().commit();
    }
}
