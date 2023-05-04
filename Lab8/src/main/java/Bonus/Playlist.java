package Bonus;

import Homework.Album;
import Homework.BaseEntity;

import java.sql.Timestamp;
import java.util.ArrayList;

/**
 * This class represents a playlist containing a list of Albums.
 */
public class Playlist extends BaseEntity {
    private final String name;
    private Timestamp creationTimestamp;
    private final ArrayList<Album> albums;

    /**
     * Constructs a new Playlist with the given name.
     * Initializes an empty list of Albums and sets the creation timestamp to the current time.
     *
     * @param name the name of the playlist
     */
    public Playlist(String name) {
        this.name = name;
        this.creationTimestamp = new Timestamp(System.currentTimeMillis());
        this.albums = new ArrayList<>();
    }

    public ArrayList<Album> getAlbums() {
        return albums;
    }

    public String getName() {
        return name;
    }

    public Timestamp getCreationTimestamp() {
        return creationTimestamp;
    }

    public void setCreationTimestamp(Timestamp creationTimestamp) {
        this.creationTimestamp = creationTimestamp;
    }

    public void addAlbum(Album album) {
        this.albums.add(album);
    }
}
