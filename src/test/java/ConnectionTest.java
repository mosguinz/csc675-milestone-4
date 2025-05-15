import org.junit.jupiter.api.Test;
import util.jdbc.JdbcConnection;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ConnectionTest {
    private static final Logger LOGGER = Logger.getLogger(ConnectionTest.class.getName());

    @Test
    public void testStatementExecution() throws SQLException {
        Connection conn = null;
        try {
            // Get the JDBC connection
            conn = JdbcConnection.getConnection();
            assertNotNull(conn);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, e.getMessage(), e);
            throw new AssertionError("Test failed due to exception: " + e.getMessage());
        } finally {
            conn.close();
        }
    }
}