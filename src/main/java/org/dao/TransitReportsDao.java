package org.dao;

import java.util.List;

public interface TransitReportsDao {
    void saveReport(TransitReportsDto report) throws Exception;

    List<TransitReportsDto> getReportsByUser(int userId) throws Exception;
}
