package Repositories;

import datatypes.Album;
import factory.EntityManagerHibernate;
import jakarta.persistence.EntityManager;

import java.util.List;

public class AlbumRepository extends Repository<Album, Integer> {


    public AlbumRepository() throws Exception {
        this.session=new EntityManagerHibernate();
    }

    @Override
    public Album findById(Integer integer) {
        return (Album)session.getEntityManager().createNamedQuery("Album.findById").setParameter(1, integer).getSingleResult();
    }

    @Override
    public List<Album> findAll() {
        return session.getEntityManager().createNamedQuery("Album.findAll").getResultList();
    }

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

    @Override
    public void save(Album obj) {
        EntityManager currentSession = session.getEntityManager();
        currentSession.getTransaction().begin();
        currentSession.persist(obj);
        currentSession.getTransaction().commit();
    }

    @Override
    public void saveAll(List<Album> entities) {

        EntityManager currentSession = session.getEntityManager();
        currentSession.getTransaction().begin();
        for(var obj:entities) {
            currentSession.persist(obj);
        }
        currentSession.getTransaction().commit();
    }



}
