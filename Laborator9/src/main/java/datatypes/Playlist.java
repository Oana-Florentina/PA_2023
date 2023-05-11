package datatypes;

import jakarta.persistence.*;

import java.util.*;
import java.time.LocalDate;

@Entity
@Table(name = "playlist")
@NamedQuery(name = "Playlist.findAll", query = "select e from Playlist e order by e.name")
@NamedQuery(name = "Playlist.findById", query = "select e from Playlist e where e.id=?1")
@NamedQuery(name = "Playlist.deleteById", query = "delete from Playlist e where e.id=?1")
@NamedQuery(name = "Playlist.deleteAll", query = "delete from Playlist")
public class Playlist implements IEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "creation_date")
    private LocalDate creationDate;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "playlist_albums",
            joinColumns = @JoinColumn(name = "id_playlist"),
            inverseJoinColumns = @JoinColumn(name = "id_album")
    )
    private Set<Album> albums;

    @Override
    public String toString() {
        return "Playlist{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", creationDate=" + creationDate +
                ", albums=" + albums +
                '}';
    }

    public Playlist() {

    }

    public Playlist(String name, LocalDate creationDate, Set<Album> playlistAlbums) {
        this.name = name;
        this.creationDate = creationDate;
        this.albums = playlistAlbums;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public Set<Album> getAlbums() {
        return albums;
    }

    public void setAlbums(Set<Album> albums) {
        this.albums = albums;
    }
}