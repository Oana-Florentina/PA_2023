package datatypes;

import jakarta.persistence.*;

@Entity
@Table(name = "playlist_albums")
@NamedQuery(name = "PlaylistAlbum.findAll", query = "select e from PlaylistAlbum e")
public class PlaylistAlbum implements IEntity {
    /**
     * The unique ID of this playlist-album relationship.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_playlist")
    private Playlist playlist;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_album")
    private Album album;

    /**
     * Constructs a new playlist-album relationship with the given playlist and album.
     *
     * @param playlist the playlist in this relationship
     * @param album    the album in this relationship
     */
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