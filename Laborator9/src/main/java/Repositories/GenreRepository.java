package Repositories;

import datatypes.Genre;
import factory.EntityManagerHibernate;
import jakarta.persistence.EntityManager;

import java.util.List;

public class GenreRepository extends Repository<Genre, Integer> {

    public GenreRepository() throws Exception {
        this.session=new EntityManagerHibernate();
    }
    @Override
    public Genre findById(Integer integer) {
        return (Genre)session.getEntityManager().createNamedQuery("Genre.findById").setParameter(1, integer).getSingleResult();

    }

    @Override
    public List<Genre> findAll() {
        return session.getEntityManager().createNamedQuery("Genre.findAll").getResultList();

    }

    @Override
    public void deleteById(Integer integer) {
        EntityManager currentSession = session.getEntityManager();
        currentSession.getTransaction().begin();
        currentSession.createNamedQuery("Genre.deleteById").setParameter(1, integer).executeUpdate();
        currentSession.getTransaction().commit();
    }

    @Override
    public void deleteAll() {
        EntityManager currentSession = session.getEntityManager();
        currentSession.getTransaction().begin();
        currentSession.createNamedQuery("Genre.deleteAll").executeUpdate();
        currentSession.getTransaction().commit();
    }

    @Override
    public void save(Genre IEntity) {
        EntityManager currentSession = session.getEntityManager();
        currentSession.getTransaction().begin();
        currentSession.persist(IEntity);
        currentSession.getTransaction().commit();
    }

    @Override
    public void saveAll(List<Genre> entities) {
        EntityManager currentSession = session.getEntityManager();
        currentSession.getTransaction().begin();
        for(var obj:entities) {
            currentSession.persist(obj);
        }
        currentSession.getTransaction().commit();
    }
}
