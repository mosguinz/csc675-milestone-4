package org.dao.impl;

import org.dao.TransitReportsDao;
import org.dto.TransitReportsDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class TransitReportsDaoImpl implements TransitReportsDao {

    private final Connection conn;

    public TransitReportsDaoImpl(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void saveReport(TransitReportsDto report) throws Exception {
        String sql = "INSERT INTO transit_reports (user_id, category_id, details) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, report.getUserId());
            stmt.setInt(2, report.getCategoryId());
            stmt.setString(3, report.getDetails());
            stmt.executeUpdate();
        }
    }

    @Override
    public List<TransitReportsDto> getReportsByUser(int userId) throws Exception {
        List<TransitReportsDto> reports = new ArrayList<>();
        String sql = "SELECT id, user_id, category_id, details FROM transit_reports WHERE user_id = ?";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, userId);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    TransitReportsDto report = new TransitReportsDto();
                    report.setId(rs.getInt("id"));
                    report.setUserId(rs.getInt("user_id"));
                    report.setCategoryId(rs.getInt("category_id"));
                    report.setDetails(rs.getString("details"));
                    reports.add(report);
                }
            }
        }

        return reports;
    }

}
