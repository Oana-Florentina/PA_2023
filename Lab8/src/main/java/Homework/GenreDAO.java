package Homework;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GenreDAO {
    private Connection connection;

    public GenreDAO(Connection connection) {
        this.connection = connection;
    }

    public void create(String name) throws SQLException {
        try (PreparedStatement pstmt = connection.prepareStatement(
                "insert into genres (name) values (?)")) {
            pstmt.setString(1, name);
            pstmt.executeUpdate();
        }
    }

    public Integer findByName(String name) throws SQLException {
        try (PreparedStatement pstmt = connection.prepareStatement(
                "select id from genres where name=?")) {
            pstmt.setString(1, name);
            try (ResultSet rs = pstmt.executeQuery()) {
                return rs.next() ? rs.getInt(1) : null;
            }
        }
    }

    // Implement other methods for managing genres (update, delete, getById, getAll, etc.) as needed
}

