package org.dao.impl;

import org.dao.TransitReportsDao;
import org.dao.exception.DaoException;
import org.dto.TransitReportsDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TransitReportsDaoImpl extends BaseDaoImpl<TransitReportsDto> implements TransitReportsDao {

    private final Connection conn;

    public TransitReportsDaoImpl(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void saveReport(TransitReportsDto report) throws Exception {
        try (PreparedStatement stmt = conn.prepareStatement(getInsertQuery())) {
            stmt.setInt(1, report.getUserId());
            stmt.setInt(2, report.getCategoryId());
            stmt.setString(3, report.getDetails());
            stmt.executeUpdate();
        }
    }

    @Override
    public List<TransitReportsDto> getReportsByUser(int userId) throws Exception {
        List<TransitReportsDto> reports = new ArrayList<>();
        String sql = getAllRowsQuery() + " WHERE user_id = ?";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, userId);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    reports.add(convertRStoDto(rs));
                }
            }
        }

        return reports;
    }

    @Override
    protected String getTableName() {
        return "transit_reports";
    }

    @Override
    protected String getAllRowsQuery() {
        return "SELECT id, user_id, category_id, details FROM " + getTableName();
    }

    @Override
    protected String getDeleteQuery() {
        return "DELETE FROM " + getTableName() + " WHERE " + getPrimaryKey() + " = ?";
    }

    @Override
    protected String getInsertQuery() {
        return "INSERT INTO " + getTableName() + " (user_id, category_id, details) VALUES (?, ?, ?)";
    }

    @Override
    protected String getUpdateQuery() {
        return "UPDATE " + getTableName() + " SET user_id = ?, category_id = ?, details = ? WHERE " + getPrimaryKey() + " = ?";
    }

    @Override
    protected String getPrimaryKey() {
        return "id";
    }

    @Override
    protected TransitReportsDto getDto() {
        return new TransitReportsDto();
    }

    @Override
    protected TransitReportsDto convertRStoDto(ResultSet rs) throws DaoException {
        try {
            TransitReportsDto dto = new TransitReportsDto();
            dto.setId(rs.getInt("id"));
            dto.setUserId(rs.getInt("user_id"));
            dto.setCategoryId(rs.getInt("category_id"));
            dto.setDetails(rs.getString("details"));
            return dto;
        } catch (SQLException e) {
            throw new DaoException("Error converting ResultSet to DTO", e);
        }
    }
}
