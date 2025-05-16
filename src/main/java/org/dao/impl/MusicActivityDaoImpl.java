package org.dao.impl;

import org.dao.MusicActivityDao;
import org.dao.exception.DaoException;
import org.dto.MusicActivityDto;
import org.dto.TracksDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MusicActivityDaoImpl extends BaseDaoImpl<MusicActivityDto> implements MusicActivityDao {

    public MusicActivityDaoImpl(Connection conn) {
        super(conn);
    }

    @Override
    public List<MusicActivityDto> getAllByUserId(int userId) throws DaoException {
        return getRows("user_id", userId);
    }

    @Override
    public List<MusicActivityDto> getAllByTrackId(int trackId) throws DaoException {
        return getRows("track_id", trackId);
    }

    @Override
    public List<TracksDto> getPopularMusicByRoute(int routeId) throws DaoException {
        List<TracksDto> results = new ArrayList<>();

        String sql = """
                    SELECT 
                        t.id,
                        t.title,
                        t.duration,
                        t.album_id,
                        COUNT(*) AS play_count
                    FROM music_activity ma
                    JOIN users u ON ma.user_id = u.id
                    JOIN transit_routes_users tru ON u.id = tru.user_id
                    JOIN tracks t ON ma.track_id = t.id
                    WHERE tru.route_id = ?
                    GROUP BY t.id, t.title, t.duration, t.album_id
                    ORDER BY play_count DESC
                    LIMIT 5
                """;

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, routeId);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    TracksDto track = new TracksDto();
                    track.setId(rs.getInt("id"));
                    track.setTitle(rs.getString("title"));
                    track.setDuration(rs.getInt("duration"));
                    track.setAlbumId(rs.getInt("album_id"));
                    results.add(track);
                }
            }
        } catch (SQLException e) {
            throw new DaoException("Failed to get popular music by route", e);
        }

        return results;
    }


    @Override
    protected String getTableName() {
        return "music_activity";
    }

    @Override
    protected String getAllRowsQuery() {
        return "SELECT id, user_id, track_id, timestamp FROM " + getTableName();
    }

    @Override
    protected String getInsertQuery() {
        return "INSERT INTO " + getTableName() + " (user_id, track_id, timestamp) VALUES (?, ?, ?)";
    }

    @Override
    protected String getDeleteQuery() {
        return "DELETE FROM " + getTableName() + " WHERE id = ?";
    }

    @Override
    protected String getUpdateQuery() {
        return "UPDATE " + getTableName() + " SET user_id = ?, track_id = ?, timestamp = ? WHERE id = ?";
    }

    @Override
    protected String getPrimaryKey() {
        return "id";
    }

    @Override
    protected MusicActivityDto getDto() {
        return new MusicActivityDto();
    }

    @Override
    protected MusicActivityDto convertRStoDto(ResultSet rs) throws DaoException {
        try {
            MusicActivityDto dto = new MusicActivityDto();
            dto.setId(rs.getInt("id"));
            dto.setUserId(rs.getInt("user_id"));
            dto.setTrackId(rs.getInt("track_id"));
            dto.setTimestamp(rs.getTimestamp("timestamp").toLocalDateTime());
            return dto;
        } catch (SQLException e) {
            throw new DaoException("Failed to convert ResultSet to DTO", e);
        }
    }

}
