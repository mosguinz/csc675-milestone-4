package org.dao.impl;

import org.dao.BaseDto;
import org.dao.ListDto;
import org.dao.exception.DaoException;
import util.jdbc.JdbcConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;


/**
 * BaseDaoImpl
 * <p>
 * Base class for Data Access Object implementations.
 * <p>
 * Modifications:
 * <p>
 * 04/20/2024 - jhui - Created
 */


public abstract class BaseDaoImpl {

    public BaseDaoImpl() {
        // TODO Auto-generated constructor stub
    }

    abstract BaseDto convertRStoDto(ResultSet results) throws DaoException;

    abstract String getAllRowsQuery();

    abstract String getInsertQuery();

    abstract String getDeleteQuery();

    abstract String getUpdateQuery();

    abstract String getPrimaryKey();

    abstract BaseDto getDto();

    /**
     * get
     * <p>
     * Given a primary key value, will return the corresponding row in DTO
     * format.
     *
     * @param Integer id - the primary key value
     * @return the DTO that corresponds to the row with the pKey of id
     */
    public BaseDto get(Integer id) throws DaoException {
        ListDto all = null;

        all = getMultipleRows(getPrimaryKey(), id);
        if (all.size() == 0) {
            throw new RuntimeException("Data with id: " + id + " not found!");
        }

        return (BaseDto) all.get(0);
    }

    /**
     * getRow
     * <p>
     * Given a field and value for a WHERE clause, this method will return
     * the first row that matches the condition.
     *
     * @param String field - database column name to filter on
     * @param Object value - value for the filter
     * @return first DTO that matches "field = value"
     */
    public BaseDto getRow(String field, Object value) throws DaoException {
        ListDto all = null;

        all = getMultipleRows(field, value);
        if (all.size() == 0) {
            throw new RuntimeException("Data with " + field + " = " + value + " not found!");
        }

        return (BaseDto) all.get(0);
    }

    /**
     * getRows
     * <p>
     * Given a field and value for a WHERE clause, this method will return
     * all the rows that matches the condition.
     *
     * @param String field - database column name to filter on
     * @param Object value - value for the filter
     * @return List of DTOs that match "field = value"
     */
    public ListDto getRows(String field, Object value) throws DaoException {
        ListDto all = null;

        all = getMultipleRows(field, value);

        return all;
    }

    /**
     * getAll
     * <p>
     * Retrieve all the rows for this table and convert the rows into a List
     * of DTOs
     *
     * @return List of DTOs for all the rows in the table
     */
    public ListDto getAll() throws DaoException {
        ListDto all = null;

        all = getMultipleRows(null, null);

        return all;
    }

    /**
     * getMultipleRows
     * <p>
     * General purpose method to retrieve rows from the database and convert them
     * into Data Transfer Objects (DTOs).
     *
     * @return List of the DTOs
     */
    ListDto getMultipleRows(String field, Object value) throws DaoException {
        ListDto all = new ListDto();
        ;
        BaseDto dto = null;
        PreparedStatement stmt = null;
        ResultSet result = null;

        try {
            Connection conn = JdbcConnection.getConnection();
            //String allRowsQuery = getAllRowsQuery();
            String allRowsQuery = Objects.requireNonNull(getAllRowsQuery(), "Query not found for getAllRowsQuery() for class, " + this.getClass().getName());
            if (field != null) {
                allRowsQuery = allRowsQuery + " WHERE " + field + " = ?";
            }

            stmt = conn.prepareStatement(allRowsQuery);
            if (field != null) {
                stmt.setObject(1, value);
            }


            result = stmt.executeQuery();
            while (result.next()) {
                dto = convertRStoDto(result);
                all.add(dto);
            }
        } catch (SQLException se) {
            throw new DaoException(se);
        } finally {
            if (result != null) {
                try {
                    result.close();
                } catch (SQLException se) {
                    System.out.println("Error closing ResultSet: " + se.getMessage());
                }
            }

            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException se) {
                    System.out.println("Error closing Statement: " + se.getMessage());
                }
            }
        }

        return all;
    }
}
