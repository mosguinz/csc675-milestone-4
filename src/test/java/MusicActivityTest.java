import org.dao.MusicActivityDao;
import org.dao.impl.MusicActivityDaoImpl;
import org.dto.TracksDto;
import org.junit.jupiter.api.Test;
import util.jdbc.JdbcConnection;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class MusicActivityTest {
    private static final Logger LOGGER = Logger.getLogger(MusicActivityTest.class.getName());

    @Test
    public void testPopularMusicByRoute() {
        try (Connection conn = JdbcConnection.getConnection()) {
            MusicActivityDao dao = new MusicActivityDaoImpl(conn);
            int testRouteId = 1;

            System.out.println("Fetching most popular music on route ID: " + testRouteId);
            List<TracksDto> tracks = dao.getPopularMusicByRoute(testRouteId);

            assertNotNull(tracks, "Expected non-null track list.");
            assertFalse(tracks.isEmpty(), "Expected at least one popular track on the route.");

            int count = 0;
            for (TracksDto t : tracks) {
                count++;
                System.out.printf("  #%d: \"%s\" (Track ID: %d, Duration: %ds, Album ID: %d)%n",
                        count, t.getTitle(), t.getId(), t.getDuration(), t.getAlbumId());
            }

            System.out.println("Verification successful. Tracks data retrieved.");
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "SQL exception occurred", e);
            throw new AssertionError("Test failed due to SQL error: " + e.getMessage());
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Unexpected exception occurred", e);
            throw new AssertionError("Test failed due to unexpected error: " + e.getMessage());
        }
    }

}
