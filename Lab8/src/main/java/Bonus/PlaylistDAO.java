package Bonus;

import Homework.Album;
import Homework.GenericDAO;

import java.sql.*;

/**
 * The PlaylistDAO class is a subclass of GenericDAO that provides specific methods for creating, finding,
 * and adding an album to a playlist in the database.
 * It uses a connection to communicate with the database.
 */
public class PlaylistDAO extends GenericDAO<Playlist> {
    /**
     * Constructs a PlaylistDAO object with the specified database connection.
     *
     * @param connection the database connection to use
     */
    public PlaylistDAO(Connection connection) {
        super(connection);
    }

    /**
     * Creates a new playlist in the database.
     *
     * @param playlist the playlist to create
     * @throws SQLException if a database access error occurs
     */
    @Override
    public void create(Playlist playlist) throws SQLException {
        String insertPlaylist = "INSERT INTO playlists (name, creation_timestamp) VALUES (?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(insertPlaylist, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, playlist.getName());
            stmt.setTimestamp(2, playlist.getCreationTimestamp());
            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                playlist.setId(rs.getInt(1));
            }
        }
    }

    /**
     * Finds a playlist in the database by ID.
     *
     * @param id the ID of the playlist to find
     * @return the found playlist, or null if the playlist does not exist
     * @throws SQLException if a database access error occurs
     */
    @Override
    public Playlist findById(int id) throws SQLException {
        try (PreparedStatement stmt = connection.prepareStatement("SELECT * FROM playlists WHERE id = ?")) {
            stmt.setInt(1, id);
            ResultSet resultSet = stmt.executeQuery();

            if (resultSet.next()) {
                String name = resultSet.getString("name");
                Timestamp creationTimestamp = resultSet.getTimestamp("creation_timestamp");
                Playlist playlist = new Playlist(name);
                playlist.setId(id);
                playlist.setCreationTimestamp(creationTimestamp);
                return playlist;
            } else {
                return null;
            }
        }
    }

    /**
     * Finds a playlist in the database by name.
     *
     * @param name the name of the playlist to find
     * @return the found playlist, or null if the playlist does not exist
     * @throws SQLException if a database access error occurs
     */
    @Override
    public Playlist findByName(String name) throws SQLException {
        try (PreparedStatement stmt = connection.prepareStatement("SELECT * FROM playlists WHERE name = ?")) {
            stmt.setString(1, name);
            ResultSet resultSet = stmt.executeQuery();

            if (resultSet.next()) {
                int id = resultSet.getInt("id");
                Timestamp creationTimestamp = resultSet.getTimestamp("creation_timestamp");
                Playlist playlist = new Playlist(name);
                playlist.setId(id);
                playlist.setCreationTimestamp(creationTimestamp);
                return playlist;
            } else {
                return null;
            }
        }
    }

    /**
     * Adds an album to a playlist in the database.
     *
     * @param playlist the playlist to add the album to
     * @param album    the album to add to the playlist
     * @throws SQLException if a database access error occurs
     */
    public void addAlbumToPlaylist(Playlist playlist, Album album) throws SQLException {
        String insertPlaylistAlbum = "INSERT INTO playlist_albums (playlist_id, album_id) VALUES (?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(insertPlaylistAlbum)) {
            stmt.setInt(1, playlist.getId());
            stmt.setInt(2, album.getId());
            stmt.executeUpdate();
        }
    }
}
