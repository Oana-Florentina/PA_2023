package Compulsory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestDAO {
    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/albums",
                "postgres",
                "password")) {

            // create a new artist
            ArtistDAO artistDAO = new ArtistDAO(connection);
            artistDAO.create("The Beatles");

            // retrieve the artist by name
            Integer id = artistDAO.findByName("The Beatles");
            System.out.println("Artist found with id: " + id);

            // retrieve the artist by id
            String name = artistDAO.findById(id);
            System.out.println("Artist found with name: " + name);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
