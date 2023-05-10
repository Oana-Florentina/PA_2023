package datatypes;

import jakarta.persistence.*;

@Entity
@Table(name = "genres_albums")
@NamedQuery(name ="GenreAlbum.findAll", query = "select e from GenreAlbum e")
public class GenreAlbum {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_album")
    private Album album;

    @ManyToOne
    @JoinColumn(name = "id_genre")
    private Genre genre;

    public GenreAlbum() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }
}
