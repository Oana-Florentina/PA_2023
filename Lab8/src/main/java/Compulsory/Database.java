package Compulsory;

import java.sql.*;

public class Database {
    private static final String URL = "jdbc:postgresql://localhost:5432/db";
    private static final String USER = "postgres";
    private static final String PASSWORD = "student";
    private static Connection connection = null;

    private Database() {}

    public static Connection getConnection() throws SQLException{
        if (connection == null) {
            createConnection();
        }
        else if (connection.isClosed()) {
            createConnection();
        }
        return connection;
    }

    private static void createConnection() {
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            connection.setAutoCommit(false);
        } catch (SQLException e) {
            System.err.println(e);
        }
    }

    public static void closeConnection() {
        try {
            if (connection != null) {
                connection.close();
                connection = null;
            }
        } catch (SQLException e) {
            System.err.println(e);
        }
    }
    public static void rollback() {
        try {
            Connection connection = getConnection();
            if (connection != null) {
                connection.rollback();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Prints the content of all tables in the database.
     *
     * @param connection The database connection.
     * @throws SQLException If a database access error occurs.
     */
    public static void printTables(Connection connection) throws SQLException {
        DatabaseMetaData metaData = connection.getMetaData();
        String[] tableTypes = {"TABLE"};
        ResultSet tables = metaData.getTables(null, null, null, tableTypes);
        while (tables.next()) {
            String tableName = tables.getString("TABLE_NAME");
            System.out.printf("Table: %s\n", tableName);
            try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery("SELECT * FROM " + tableName)) {
                while (rs.next()) {
                    ResultSetMetaData rsMetaData = rs.getMetaData();
                    int columnCount = rsMetaData.getColumnCount();
                    for (int i = 1; i <= columnCount; i++) {
                        String columnName = rsMetaData.getColumnName(i);
                        String value = rs.getString(columnName);
                        System.out.printf("- %s: %s\n", columnName, value);
                    }
                }
            }
            System.out.println();
        }
    }
    /**
     * Resets all tables in the database, clearing their contents.
     *
     * @param connection The database connection.
     * @throws SQLException If a database access error occurs.
     */
    public static void resetTables(Connection connection) throws SQLException {
        try (Statement stmt = connection.createStatement()) {
            stmt.executeUpdate("TRUNCATE TABLE artists CASCADE;");
            stmt.executeUpdate("TRUNCATE TABLE albums CASCADE;");
            stmt.executeUpdate("TRUNCATE TABLE genres CASCADE;");
            stmt.executeUpdate("TRUNCATE TABLE playlists CASCADE;");
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            rollback();
        }
        restartAllSequences(connection);
    }

    /**
     * Restarts all sequences in the database, resetting their values.
     *
     * @param connection The database connection.
     */
    public static void restartAllSequences(Connection connection) {
        try (Statement stmt = connection.createStatement()) {
            stmt.executeUpdate("ALTER SEQUENCE artists_id_seq RESTART WITH 1;");
            stmt.executeUpdate("ALTER SEQUENCE albums_id_seq RESTART WITH 1;");
            stmt.executeUpdate("ALTER SEQUENCE genres_id_seq RESTART WITH 1;");
            stmt.executeUpdate("ALTER SEQUENCE playlists_id_seq RESTART WITH 1;");
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            rollback();
        }
    }
}
