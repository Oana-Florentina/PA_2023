package datatypes;

import jakarta.persistence.*;

@Entity
@Table(name = "genres")
@NamedQuery(name = "Genre.findAll", query = "select e from Genre e order by e.name")
@NamedQuery(name = "Genre.findById", query = "select e from Genre e where e.id=?1")
@NamedQuery(name = "Genre.deleteById", query = "delete from Genre e where e.id=?1")
@NamedQuery(name = "Genre.deleteAll", query = "delete from Genre")

public class Genre implements IEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;

    public Genre() {

    }

    public Genre(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Genre{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
