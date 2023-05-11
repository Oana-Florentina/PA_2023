package Repositories;

import datatypes.Playlist;
import factory.EntityManagerHibernate;
import jakarta.persistence.EntityManager;

import java.util.*;

public class PlaylistRepository extends Repository<Playlist, Integer> {
    private EntityManagerHibernate session;

    public PlaylistRepository() throws Exception {
        this.session = new EntityManagerHibernate();
    }

    @Override
    public Playlist findById(Integer integer) {
        return (Playlist) session.getEntityManager().createNamedQuery("Playlist.findById").setParameter(1, integer).
                getSingleResult();
    }

    @Override
    public List<Playlist> findAll() {
        return session.getEntityManager().createNamedQuery("Playlist.findAll").getResultList();
    }

    @Override
    public void deleteById(Integer integer) {
        EntityManager currentSession = session.getEntityManager();
        currentSession.getTransaction().begin();
        currentSession.createNamedQuery("Playlist.deleteById").setParameter(1, integer).executeUpdate();
        currentSession.getTransaction().commit();
    }

    @Override
    public void deleteAll() {
        EntityManager currentSession = session.getEntityManager();
        currentSession.getTransaction().begin();
        currentSession.createNamedQuery("Playlist.deleteAll").executeUpdate();
        currentSession.getTransaction().commit();
    }

    @Override
    public void save(Playlist obj) {
        EntityManager currentSession = session.getEntityManager();
        currentSession.getTransaction().begin();
        currentSession.persist(obj);
        currentSession.getTransaction().commit();
    }

    @Override
    public void saveAll(List<Playlist> entities) {
        EntityManager currentSession = session.getEntityManager();
        currentSession.getTransaction().begin();
        for (var obj : entities) {
            currentSession.persist(obj);
        }
        currentSession.getTransaction().commit();
    }

}