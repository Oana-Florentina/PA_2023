package Repositories;

import factory.EntityManagerHibernate;
import java.util.List;
import java.io.Serializable;
public abstract class Repository  <T, ID extends Serializable> {
    protected EntityManagerHibernate session;
    public Repository() throws Exception {
        this.session=this.session=new EntityManagerHibernate();
    }
    public abstract T findById(ID id);
    public abstract List<T> findAll();
    public abstract void deleteById(ID id);
    public abstract void deleteAll();
    public abstract void save(T IEntity);
    public abstract void saveAll(List<T> entities);
}
