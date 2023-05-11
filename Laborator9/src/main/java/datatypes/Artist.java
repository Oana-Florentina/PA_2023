package datatypes;


import jakarta.persistence.*;

/**
 * This class represents an artist entity in the system.
 */
@Entity
@Table(name = "artists")
@NamedQuery(name = "Artist.findAll", query = "select e from Artist e order by e.name")
@NamedQuery(name = "Artist.findById", query = "select e from Artist e where e.id = ?1")
@NamedQuery(name = "Artist.deleteById", query = "delete from Artist e where e.id=?1")
@NamedQuery(name = "Artist.deleteAll", query = "delete from Artist")
public class Artist implements IEntity {
    /**
     * The ID of the artist.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")

    private int id;
    @Column(name = "name")
    private String name;

    public Artist() {

    }

    public Artist(String name) {
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
        return "Artist{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
