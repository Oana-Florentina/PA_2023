package Compulsory;

import Homework.Artist;
import Homework.GenericDAO;

import java.sql.*;

/**
 * Artist Data Access Object (DAO) class to interact with the "artists" table in the database.
 * Provides methods to create and find artists by ID and name.
 */
public class ArtistDAO extends GenericDAO<Artist> {
    /**
     * Constructor that takes a database connection as a parameter.
     *
     * @param connection The connection to the database.
     */
    public ArtistDAO(Connection connection) {
        super(connection);
    }

    /**
     * Create a new artist record in the "artists" table, if it doesn't already exist.
     * If the artist already exists in the database, the artist object will have its ID set to the existing artist's ID.
     *
     * @param artist The artist object to insert into the database or to update its ID if it already exists.
     * @throws SQLException If there is an issue with the SQL statements.
     */
    @Override
    public void create(Artist artist) throws SQLException {
        // Check if the artist already exists in the database
        Artist existingArtist = findByName(artist.getName());

        // If the artist doesn't exist, insert it
        if (existingArtist == null) {
            try (PreparedStatement stmt = connection.prepareStatement("INSERT INTO artists (name) VALUES (?)", Statement.RETURN_GENERATED_KEYS)) {
                stmt.setString(1, artist.getName());
                stmt.executeUpdate();

                try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        artist.setId(generatedKeys.getInt(1));
                    }
                }
            }
        } else {
            // If the artist already exists, set the ID of the artist object
            artist.setId(existingArtist.getId());
        }
    }


    /**
     * Finds an artist in the "artists" table by its ID.
     *
     * @param id The ID of the artist to search for.
     * @return The found Artist object or null if not found.
     * @throws SQLException If there is an issue with the SQL statement.
     */
    @Override
    public Artist findById(int id) throws SQLException {
        try (PreparedStatement stmt = connection.prepareStatement("SELECT * FROM artists WHERE id = ?")) {
            stmt.setInt(1, id);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Artist artist = new Artist();
                    artist.setId(rs.getInt("id"));
                    artist.setName(rs.getString("name"));
                    return artist;
                }
            }
        }

        return null;
    }

    /**
     * Finds an artist in the "artists" table by its name.
     *
     * @param name The name of the artist to search for.
     * @return The found Artist object or null if not found.
     * @throws SQLException If there is an issue with the SQL statement.
     */
    @Override
    public Artist findByName(String name) throws SQLException {
        try (PreparedStatement stmt = connection.prepareStatement("SELECT * FROM artists WHERE name = ?")) {
            stmt.setString(1, name);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Artist artist = new Artist();
                    artist.setId(rs.getInt("id"));
                    artist.setName(rs.getString("name"));
                    return artist;
                }
            }
        }
        return null;
    }
}
