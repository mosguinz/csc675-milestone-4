import org.dao.TransitReportsDto;
import org.dao.impl.TransitReportsDaoImpl;
import org.junit.jupiter.api.Test;
import util.jdbc.JdbcConnection;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.*;

public class TransitReportsTest {
    private static final Logger LOGGER = Logger.getLogger(TransitReportsTest.class.getName());

    @Test
    public void testSaveAndQueryTransitReport() {
        try (Connection conn = JdbcConnection.getConnection()) {
            TransitReportsDaoImpl dao = new TransitReportsDaoImpl(conn);

            // Create test data
            int testUserId = 1;           // Must exist
            int testCategoryId = 3;       // Assume 'Technical problem'
            String randomToken = generateRandomToken();
            String details = "Mechanical issue at station - ref " + randomToken;

            System.out.println("Inserting transit report:");
            System.out.println("  User ID: " + testUserId);
            System.out.println("  Category ID: " + testCategoryId);
            System.out.println("  Details: " + details);

            TransitReportsDto report = new TransitReportsDto();
            report.setUserId(testUserId);
            report.setCategoryId(testCategoryId);
            report.setDetails(details);

            // Write report
            dao.saveReport(report);
            System.out.println("Insert complete. Verifying...");

            // Retrieve it back
            List<TransitReportsDto> reports = dao.getReportsByUser(testUserId);
            assertNotNull(reports, "Expected non-null result from getReportsByUser()");
            assertFalse(reports.isEmpty(), "Expected at least one report for user");

            // Verify the contents -- mostly that generated string
            boolean matchFound = false;
            for (TransitReportsDto r : reports) {
                if (r.getCategoryId() == testCategoryId && r.getDetails().equals(details)) {
                    matchFound = true;
                    System.out.println("Found inserted report with ID: " + r.getId());
                    break;
                }
            }

            assertTrue(matchFound, "Inserted report with exact details was not found.");
            System.out.println("Verification successful.");

        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, e.getMessage(), e);
            throw new AssertionError("Test failed due to SQL exception: " + e.getMessage());
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, e.getMessage(), e);
            throw new AssertionError("Test failed due to exception: " + e.getMessage());
        }
    }

    private String generateRandomToken() {
        int token = new Random().nextInt(9000) + 1000; // Random 4-digit number
        return "RPT" + token;
    }
}
