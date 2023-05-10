package datatypes;

import jakarta.persistence.*;

@Entity
@Table(name = "playlist_albums")
@NamedQuery(name ="PlaylistAlbum.findAll", query = "select e from PlaylistAlbum e")
public class PlaylistAlbum implements IEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_playlist")
    private Playlist playlist;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_album")
    private Album album;

    public PlaylistAlbum(Playlist playlist, Album album) {
        this.playlist = playlist;
        this.album = album;
    }

    public PlaylistAlbum() {

    }

    @Override
    public String toString() {
        return "PlaylistAlbum{" +
                "id=" + id +
                ", playlist=" + playlist +
                ", album=" + album +
                '}';
    }
}