package util.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * JdbcConnection
 * <p>
 * Helper class to get JDBC connection
 */
public class JdbcConnection {

    /**
     * Default Constructor
     */
    public JdbcConnection() {
        super();

    }

    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String databaseName = "csc675";
            String sourceURL = String.format("jdbc:mysql://localhost/%s?allowMultiQueries=true", databaseName);
            String user = "root";
            String password = "12345678";
            return DriverManager.getConnection(sourceURL, user, password);
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException("Failed to get JDBC connection", e);
        }
    }

}
