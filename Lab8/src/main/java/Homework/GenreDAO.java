package Homework;
import java.sql.*;

/**
 * GenreDAO is a Data Access Object (DAO) class for interacting with the "genres" table in the database.
 * It extends the GenericDAO class and provides implementation for its abstract methods.
 */
public class GenreDAO extends GenericDAO<Genre> {
    /**
     * Constructs a GenreDAO object with a database connection.
     *
     * @param connection A Connection object representing the database connection.
     */

    public GenreDAO(Connection connection) {
        super(connection);
    }

    /**
     * Inserts a new genre into the database if it doesn't already exist.
     * If the genre already exists, sets the ID of the passed Genre object to the ID of the existing genre.
     *
     * @param genre A Genre object to be inserted into the database.
     * @throws SQLException If an error occurs while executing the SQL query.
     */
    @Override
    public void create(Genre genre) throws SQLException {
        // First, try to find the genre by name
        Genre existingGenre = findByName(genre.getName());

        if (existingGenre == null) {
            // If the genre doesn't exist, create a new one
            try (PreparedStatement stmt = connection.prepareStatement("INSERT INTO genres (name) VALUES (?)", Statement.RETURN_GENERATED_KEYS)) {
                stmt.setString(1, genre.getName());
                stmt.executeUpdate();

                try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        genre.setId(generatedKeys.getInt(1));
                    }
                }
            }
        } else {
            // If the genre already exists, set its ID to the existing genre's ID
            genre.setId(existingGenre.getId());
        }
    }

    /**
     * Retrieves a genre with the specified ID from the database.
     *
     * @param id The ID of the genre to retrieve.
     * @return A Genre object with the specified ID, or null if not found.
     * @throws SQLException If an error occurs while executing the SQL query.
     */
    @Override
    public Genre findById(int id) throws SQLException {
        try (PreparedStatement stmt = connection.prepareStatement("SELECT * FROM genres WHERE id = ?")) {
            stmt.setInt(1, id);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Genre genre = new Genre();
                    genre.setId(rs.getInt("id"));
                    genre.setName(rs.getString("name"));
                    return genre;
                }
            }
        }

        return null;
    }

    /**
     * Retrieves a genre with the specified name from the database.
     *
     * @param name The name of the genre to retrieve.
     * @return A Genre object with the specified name, or null if not found.
     * @throws SQLException If an error occurs while executing the SQL query.
     */
    @Override
    public Genre findByName(String name) throws SQLException {
        try (PreparedStatement stmt = connection.prepareStatement("SELECT * FROM genres WHERE name = ?")) {
            stmt.setString(1, name);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Genre genre = new Genre();
                    genre.setId(rs.getInt("id"));
                    genre.setName(rs.getString("name"));
                    return genre;
                }
            }
        }

        return null;
    }
}
