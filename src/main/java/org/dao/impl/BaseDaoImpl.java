package org.dao.impl;

import org.dao.exception.DaoException;
import org.dto.BaseDto;
import util.jdbc.JdbcConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class BaseDaoImpl<T extends BaseDto> {

    public BaseDaoImpl() {
    }

    abstract T convertRStoDto(ResultSet rs) throws DaoException;

    protected abstract String getAllRowsQuery();

    protected abstract String getInsertQuery();

    protected abstract String getDeleteQuery();

    protected abstract String getUpdateQuery();

    protected abstract String getPrimaryKey();

    protected abstract T getDto();

    public T get(Integer id) throws DaoException {
        List<T> all = getMultipleRows(getPrimaryKey(), id);
        if (all.isEmpty()) {
            throw new RuntimeException("Data with id: " + id + " not found!");
        }
        return all.get(0);
    }

    public T getRow(String field, Object value) throws DaoException {
        List<T> all = getMultipleRows(field, value);
        if (all.isEmpty()) {
            throw new RuntimeException("Data with " + field + " = " + value + " not found!");
        }
        return all.get(0);
    }

    public List<T> getRows(String field, Object value) throws DaoException {
        return getMultipleRows(field, value);
    }

    public List<T> getAll() throws DaoException {
        return getMultipleRows(null, null);
    }

    private List<T> getMultipleRows(String field, Object value) throws DaoException {
        List<T> all = new ArrayList<>();
        PreparedStatement stmt = null;
        ResultSet result = null;

        try {
            Connection conn = JdbcConnection.getConnection();
            String allRowsQuery = Objects.requireNonNull(getAllRowsQuery(),
                    "Query not found for getAllRowsQuery() for class: " + this.getClass().getName());
            if (field != null) {
                allRowsQuery += " WHERE " + field + " = ?";
            }

            stmt = conn.prepareStatement(allRowsQuery);
            if (field != null) {
                stmt.setObject(1, value);
            }

            result = stmt.executeQuery();
            while (result.next()) {
                T dto = convertRStoDto(result);
                all.add(dto);
            }
        } catch (SQLException se) {
            throw new DaoException(se);
        } finally {
            if (result != null) try {
                result.close();
            } catch (SQLException ignored) {
            }
            if (stmt != null) try {
                stmt.close();
            } catch (SQLException ignored) {
            }
        }

        return all;
    }

    public boolean deleteById(Integer id) throws DaoException {
        PreparedStatement stmt = null;
        try {
            Connection conn = JdbcConnection.getConnection();
            String sql = Objects.requireNonNull(getDeleteQuery(),
                    "Delete query not defined for class: " + this.getClass().getName());
            stmt = conn.prepareStatement(sql);
            stmt.setObject(1, id);
            return stmt.executeUpdate() == 1;
        } catch (SQLException se) {
            throw new DaoException(se);
        } finally {
            if (stmt != null) try {
                stmt.close();
            } catch (SQLException ignored) {
            }
        }
    }
}
