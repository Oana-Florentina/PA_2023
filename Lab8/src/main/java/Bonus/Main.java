package Bonus;

import Homework.AlbumDAO;
import Compulsory.ArtistDAO;
import Compulsory.Database;
import Homework.GenreDAO;
import Homework.Album;
import Homework.Artist;
import Homework.Genre;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        try (Connection connection = Database.getConnection()) {

            // Create instances of DAOs
            ArtistDAO artistDAO = new ArtistDAO(connection);
            AlbumDAO albumDAO = new AlbumDAO(connection);
            GenreDAO genreDAO = new GenreDAO(connection);
            PlaylistDAO playlistDAO = new PlaylistDAO(connection);

            // Create a new artist, album and genre
            Genre genre1 = new Genre("Rock");
            Genre genre2 = new Genre("Pop");
            genreDAO.create(genre1);
            genreDAO.create(genre2);

            Artist artist = new Artist("The Beatles");
            artistDAO.create(artist);

            Album album1 = new Album(1967, "Sgt. Pepper's Lonely Hearts Club Band", "The Beatles", "Rock");
            Album album2 = new Album(1969, "Abbey Road", "The Beatles", "Rock");
            albumDAO.create(album1);
            albumDAO.create(album2);
            connection.commit();

            // Create a new playlist and add the album to it
            Playlist playlist1 = new Playlist("Playlist manele");
            playlist1.addAlbum(album1);
            playlist1.addAlbum(album2);

            playlistDAO.create(playlist1);
            playlistDAO.addAlbumToPlaylist(playlist1, album1);
            playlistDAO.addAlbumToPlaylist(playlist1, album2);
            connection.commit();
            Database.printTables(connection);
            Database.resetTables(connection);
            connection.commit();

            List<Album> albums = new ArrayList<>();
            albums.add(new Album(2001, "Album 1", "Artist 1", "Rock,Pop"));
            albums.add(new Album(2002, "Album 2", "Artist 1", "Pop"));
            albums.add(new Album(2003, "Album 3", "Artist 2", "Electronic"));
            albums.add(new Album(2004, "Album 4", "Artist 3", "Rock"));
            albums.add(new Album(2005, "Album 5", "Artist 4", "Jazz,Blues"));
            albums.add(new Album(2006, "Album 6", "Artist 5", "Classical"));

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
