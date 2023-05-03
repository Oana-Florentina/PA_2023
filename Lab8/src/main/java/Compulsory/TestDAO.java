package Compulsory;

import Homework.*;
import Homework.Album;
import Homework.Artist;

import java.sql.Connection;
import java.sql.SQLException;

public class TestDAO {
    public static void main(String[] args) {
        try {
            try (Connection connection = Database.getConnection()) {
                var artists = new ArtistDAO(connection);
                Artist artist1 = new Artist("Pink Floyd");
                Artist artist2 = new Artist("Michael Jackson");

                artists.create(artist1);
                artists.create(artist2);

                var genres = new GenreDAO(connection);
                Genre genre1 = new Genre("Rock");
                Genre genre2 = new Genre("Funk");
                Genre genre3 = new Genre("Soul");
                Genre genre4 = new Genre("Pop");
                Genre genre5 = new Genre("Classic");
                genres.create(genre1);
                genres.create(genre2);
                genres.create(genre3);
                genres.create(genre4);
                genres.create(genre5);

                connection.commit();

                System.out.println(artists.findById(1));
                System.out.println(artists.findByName("Pink Floyd"));
                System.out.println(genres.findById(1));
                System.out.println(genres.findByName("Rock"));
            }

            try (Connection connection = Database.getConnection()) {
                var albums = new AlbumDAO(connection);
                Album album1 = new Album(1979, "The Wall", "Pink Floyd", "Rock");
                Album album2 = new Album(1982, "Thriller", "Michael Jackson", "Funk,Soul,Pop");

                albums.create(album1);
                albums.create(album2);
                connection.commit();
                System.out.println(albums.findById(1));
                System.out.println(albums.findByName("The Wall"));
            }

            try (Connection connection = Database.getConnection()) {
                Database.printTables(connection);
                Database.resetTables(connection);
                connection.commit();
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            Database.rollback();
        }
    }
}
