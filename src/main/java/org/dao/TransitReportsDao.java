package org.dao;

import org.dto.TransitReportsDto;

import java.util.List;

public interface TransitReportsDao {
    void saveReport(TransitReportsDto report) throws Exception;

    List<TransitReportsDto> getReportsByUser(int userId) throws Exception;
}
