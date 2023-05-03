package Homework;


import java.sql.*;

/**
 * Album Data Access Object (DAO) class to interact with the "albums" table in the database.
 * Provides methods to create and find albums by ID and title.
 */
public class AlbumDAO extends GenericDAO<Album> {
    /**
     * Constructor that takes a database connection as a parameter.
     *
     * @param connection The connection to the database.
     */
    public AlbumDAO(Connection connection) {
        super(connection);
    }

    /**
     * Create a new album record in the "albums" table and the related album-genre associations in the "album_genres" table.
     *
     * @param album The album object to insert into the database.
     * @throws SQLException If there is an issue with the SQL statements.
     */
    @Override
    public void create(Album album) throws SQLException {
        String[] genreNames = album.getGenres();
        try (PreparedStatement stmt = connection.prepareStatement("INSERT INTO albums (year, title, artist_name) VALUES (?, ?, ?)", Statement.RETURN_GENERATED_KEYS)) {
            stmt.setInt(1, album.getYear());
            stmt.setString(2, album.getTitle());
            stmt.setString(3, album.getArtistName());
            stmt.executeUpdate();

            // Get the generated album ID
            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                int albumId = rs.getInt(1);
                album.setId(albumId);
                rs.close();

                // Insert the album-genre associations into the junction table
                try (PreparedStatement stmt2 = connection.prepareStatement("INSERT INTO album_genres (album_id, genre_id) SELECT ?, ? WHERE NOT EXISTS (SELECT 1 FROM album_genres WHERE album_id = ? AND genre_id = ?)")) {
                    for (String genreName : genreNames) {
                        Integer genreId = findGenreIdByName(genreName);
                        if (genreId != null) {
                            stmt2.setInt(1, albumId);
                            stmt2.setInt(2, genreId);
                            stmt2.setInt(3, albumId);
                            stmt2.setInt(4, genreId);
                            stmt2.executeUpdate();
                        }
                    }
                }
            }
        }
    }

    /**
     * A private helper method to find the genre ID by its name.
     *
     * @param name The name of the genre to search for.
     * @return The found genre ID or null if not found.
     * @throws SQLException If there is an issue with the SQL statement.
     */
    private Integer findGenreIdByName(String name) throws SQLException {
        try (PreparedStatement stmt = connection.prepareStatement("SELECT id FROM genres WHERE name = ?")) {
            stmt.setString(1, name);
            try (ResultSet rs = stmt.executeQuery()) {
                return rs.next() ? rs.getInt(1) : null;
            }
        }
    }

    /**
     * Finds an album in the "albums" table by its ID.
     *
     * @param id The ID of the album to search for.
     * @return The found Album object or null if not found.
     * @throws SQLException If there is an issue with the SQL statement.
     */
    @Override
    public Album findById(int id) throws SQLException {
        try (PreparedStatement stmt = connection.prepareStatement("SELECT * FROM albums WHERE id = ?")) {
            stmt.setInt(1, id);

            Album album = getAlbum(stmt);
            if (album != null) return album;
        }

        return null;
    }

    /**
     * Finds an album in the "albums" table by its title.
     *
     * @param title The title of the album to search for.
     * @return The found Album object or null if not found.
     * @throws SQLException If there is an issue with the SQL statement.
     */
    @Override
    public Album findByName(String title) throws SQLException {
        try (PreparedStatement stmt = connection.prepareStatement("SELECT * FROM albums WHERE title = ?")) {
            stmt.setString(1, title);

            Album album = getAlbum(stmt);
            if (album != null) return album;
        }

        return null;
    }

    /**
     * A private helper method to retrieve the Album object from a ResultSet.
     *
     * @param stmt The PreparedStatement object with the executed query.
     * @return The found Album object or null if not found.
     * @throws SQLException If there is an issue with the SQL statement.
     */
    private Album getAlbum(PreparedStatement stmt) throws SQLException {
        try (ResultSet rs = stmt.executeQuery()) {
            if (rs.next()) {
                Album album = new Album();
                album.setId(rs.getInt("id"));
                album.setYear(rs.getInt("year"));
                album.setTitle(rs.getString("title"));
                album.setArtistName(rs.getString("artist_name"));
                return album;
            }
        }
        return null;
    }
}

