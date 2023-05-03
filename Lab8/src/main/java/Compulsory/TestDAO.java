package Compulsory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestDAO {
    public static void main(String[] args) {
    try {
        Connection connection = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/db",
                "postgres",
                "student");
        var artists = new ArtistDAO(connection);
        artists.create("Pink Floyd");
        artists.create("Michael Jackson");

        Database.getConnection().close();
    } catch (SQLException e) {
        System.err.println(e);
       // Database.rollback();
    }
}
}
