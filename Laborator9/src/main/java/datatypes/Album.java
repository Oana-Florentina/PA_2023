package datatypes;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Set;

/**
 * The Album class represents an album entity that can be stored and retrieved from a database.
 * It has fields for the release date, title, artist, and genres of the album.
 */
@Entity
@Table(name = "albums")
@NamedQuery(name = "Album.findAll", query = "select e from Album e order by e.title")
@NamedQuery(name = "Album.findById", query = "select e from Album e where e.id=?1")
@NamedQuery(name = "Album.deleteById", query = "delete from Album e where e.id=?1")
@NamedQuery(name = "Album.deleteAll", query = "delete from Album")
public class Album implements IEntity {
    /**
     * The unique identifier of the album.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    int id;
    @Column(name = "release_date")
    private LocalDate releaseDate;
    @Column(name = "title")
    private String title;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "artists")
    private Artist artist;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "genres_albums",
            joinColumns = @JoinColumn(name = "id_album"),
            inverseJoinColumns = @JoinColumn(name = "id_genre")
    )
    private Set<Genre> genres;

    public Album() {
    }

    /**
     * Creates an Album object with the given release date, title, artist, and genres.
     *
     * @param releaseDate the release date of the album
     * @param title       the title of the album
     * @param artist      the artist who created the album
     * @param genres      the set of genres associated with the album
     */
    public Album(LocalDate releaseDate, String title, Artist artist, Set<Genre> genres) {
        this.releaseDate = releaseDate;
        this.title = title;
        this.artist = artist;
        this.genres = genres;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public Set<Genre> getGenres() {
        return genres;
    }

    public void setGenres(Set<Genre> genres) {
        this.genres = genres;
    }

    @Override
    public String toString() {
        return "Album{" +
                "id=" + id +
                ", releaseDate=" + releaseDate +
                ", title='" + title + '\'' +
                ", artist=" + artist +
                ", genres=" + genres +
                '}';
    }
}
