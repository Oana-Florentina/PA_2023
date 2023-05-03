package Homework;
import Compulsory.ArtistDAO;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;

/**
 * CSVImporter is a utility class for importing data from a CSV file into a database.
 */
public class CSVImporter {
    /**
     * Imports data from a CSV file into a database.
     * The CSV file must have the following headers: "Artist", "Album", "Year", "Genre", "Subgenre".
     * The "Genre" and "Subgenre" columns should contain comma-separated values.
     * For each row in the CSV file, new Artist and Album object are created and inserted into the database,
     * along with any new Genres and Album-Genre associations.
     *
     * @param filePath   The path to the CSV file to import.
     * @param connection A Connection object representing the database connection.
     * @throws IOException  If an error occurs while reading the CSV file.
     * @throws SQLException If an error occurs while executing the SQL queries.
     */
    public static void importCSV(String filePath, Connection connection) throws IOException, SQLException {
        try (FileReader fileReader = new FileReader(filePath, StandardCharsets.UTF_8)) {
            CSVParser parser = CSVFormat.DEFAULT.withHeader().withFirstRecordAsHeader().parse(fileReader);

            ArtistDAO artistDAO = new ArtistDAO(connection);
            GenreDAO genreDAO = new GenreDAO(connection);
            AlbumDAO albumDAO = new AlbumDAO(connection);

            for (CSVRecord record : parser) {
                String artistName = record.get("Artist");
                String albumTitle = record.get("Album");
                int year = Integer.parseInt(record.get("Year"));
                String genreName = record.get("Genre");
                String subgenres = record.get("Subgenre");

                // Combine genreName and subgenres into a single string and split it
                String[] allGenres = (genreName + ", " + subgenres).split(",\\s*");

                Artist artist = new Artist(artistName);
                Album album = new Album(year, albumTitle, artistName, Arrays.toString(allGenres));

                artistDAO.create(artist);
                albumDAO.create(album);
                int albumId = album.getId();

                // Insert genre and album-genre associations
                for (String genreStr : allGenres) {
                    Genre genre = new Genre(genreStr);
                    genreDAO.create(genre);
                    int genreId = genre.getId();
                    // Check if the album-genre association already exists
                    try (PreparedStatement checkStmt = connection.prepareStatement("SELECT COUNT(*) FROM album_genres WHERE album_id = ? AND genre_id = ?")) {
                        checkStmt.setInt(1, albumId);
                        checkStmt.setInt(2, genreId);
                        ResultSet rs = checkStmt.executeQuery();
                        if (rs.next() && rs.getInt(1) == 0) {
                            // Insert album-genre association if it does not exist
                            try (PreparedStatement stmt = connection.prepareStatement("INSERT INTO album_genres (album_id, genre_id) VALUES (?, ?)")) {
                                stmt.setInt(1, albumId);
                                stmt.setInt(2, genreId);
                                stmt.executeUpdate();
                            }
                        }
                    }
                }
            }
        }
    }
}


