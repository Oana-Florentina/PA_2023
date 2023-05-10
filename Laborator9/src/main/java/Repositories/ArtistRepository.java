package Repositories;

import datatypes.Artist;
import factory.EntityManagerHibernate;
import jakarta.persistence.EntityManager;

import java.util.List;

public class ArtistRepository extends Repository<Artist, Integer> {
    private EntityManagerHibernate session;

    public ArtistRepository() throws Exception {
        this.session=new EntityManagerHibernate();
    }

    @Override
    public Artist findById(Integer integer) {
        return (Artist)session.getEntityManager().createNamedQuery("Artist.findById").setParameter(1, integer).getSingleResult();

    }

    @Override
    public List<Artist> findAll() {
        return session.getEntityManager().createNamedQuery("Artist.findAll").getResultList();
    }

    @Override
    public void deleteById(Integer integer) {
        EntityManager currentSession = session.getEntityManager();
        currentSession.getTransaction().begin();
        currentSession.createNamedQuery("Artist.deleteById").setParameter(1, integer).executeUpdate();
        currentSession.getTransaction().commit();
    }

    @Override
    public void deleteAll() {
        EntityManager currentSession = session.getEntityManager();
        currentSession.getTransaction().begin();
        currentSession.createNamedQuery("Artist.deleteAll").executeUpdate();
        currentSession.getTransaction().commit();
    }

    @Override
    public void save(Artist obj) {
        EntityManager currentSession = session.getEntityManager();
        currentSession.getTransaction().begin();
        currentSession.persist(obj);
        currentSession.getTransaction().commit();
    }

    @Override
    public void saveAll(List<Artist> entities) {
        EntityManager currentSession = session.getEntityManager();
        currentSession.getTransaction().begin();
        for(var obj:entities) {
            currentSession.persist(obj);
        }
        currentSession.getTransaction().commit();
    }

}
