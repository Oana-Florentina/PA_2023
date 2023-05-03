package Compulsory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ArtistDAO {
    private Connection connection;

    public ArtistDAO(Connection connection) {
        this.connection = connection;
    }

    public void create(String name) throws SQLException {
        try (PreparedStatement pstmt = connection.prepareStatement(
                "insert into artists (name) values (?)")) {
            pstmt.setString(1, name);
            pstmt.executeUpdate();
        }
    }

    public Integer findByName(String name) throws SQLException {
        try (PreparedStatement pstmt = connection.prepareStatement(
                "select id from artists where name=?")) {
            pstmt.setString(1, name);
            try (ResultSet rs = pstmt.executeQuery()) {
                return rs.next() ? rs.getInt(1) : null;
            }
        }
    }

    public String findById(int id) throws SQLException {
        try (PreparedStatement pstmt = connection.prepareStatement(
                "select name from artists where id=?")) {
            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                return rs.next() ? rs.getString(1) : null;
            }
        }
    }

}

