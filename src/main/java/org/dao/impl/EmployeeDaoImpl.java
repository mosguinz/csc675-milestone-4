package org.dao.impl;

import org.dao.BaseDto;
import org.dao.EmployeeDao;
import org.dao.EmployeeDto;
import org.dao.exception.DaoException;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

/**
 * EmployeeDaoImpl
 * <p>
 * Implementation for EmployeeDao (Data Access Object)
 * <p>
 * Modifications:
 * <p>
 * 04/20/2024 - jhui - Created
 */


public class EmployeeDaoImpl extends BaseDaoImpl implements EmployeeDao {
    String _tableName = "employee2";
    String _primaryKey = "employee_id";
    Properties _empQueries = null;

    public EmployeeDaoImpl() {
        super();

        _empQueries = new Properties();
        try {
            _empQueries.load(this.getClass().getClassLoader().getResourceAsStream("org/sql/sql.properties"));
            //String query = _empQueries.getProperty("EMP_UPDATE");
            //System.out.println("Update query: \n" + query);
        } catch (IOException io) {
            System.out.println("Exception during sql.properties load: " + io);
        }
    }

    public EmployeeDto get(Integer id) throws DaoException {
        return (EmployeeDto) super.get(id);
    }

    public EmployeeDto getRow(String field, Object value) throws DaoException {
        return (EmployeeDto) super.getRow(field, value);
    }


    /**
     * save
     * <p>
     * Convert the DTO into a SQL row and INSERT into the table
     *
     * @param EmployeeDto t - DTO that contains the values for the new row
     */
    public void save(EmployeeDto t) throws DaoException {
        // write to DB

        return;
    }

    /**
     * update
     * <p>
     * Update the corresponding row in the database for the DTO with the
     * values in params
     *
     * @param EmployeeDto t - pull the primary key out of t
     * @param String[]    params - values to update the row
     */
    public void update(EmployeeDto t, String[] params) throws DaoException {
        // update DB

        return;
    }

    /**
     * delete
     * <p>
     * Delete the corresponding row in the database for the DTO
     *
     * @param EmployeeDto t - pull the primary key out of t
     */
    public void delete(EmployeeDto t) throws DaoException {
        // delete from DB

        return;
    }

    /**
     * convertRStoDto
     * <p>
     * Utility method that copies the values in the ResultSet into the DTO.
     * Needed specific implementation for the method getMultipleRows in the
     * BaseDaoImpl.
     *
     * @param ResultSet result - the source values from a query to the DB
     * @return EmployeeDto
     */
    EmployeeDto convertRStoDto(ResultSet result) throws DaoException {
        EmployeeDto empl = new EmployeeDto();
        try {
            empl.setEmployeeId(result.getInt(1));
            empl.setLastName(result.getString(2));
            empl.setFirstName(result.getString(3));
            empl.setEmail(result.getString(4));
            empl.setStreetAddress(result.getString(5));
            empl.setCity(result.getString(6));
            empl.setState(result.getString(7));
            empl.setCountry(result.getString(8));
            empl.setDepartmentId(result.getInt(9));
        } catch (SQLException se) {
            throw new DaoException(se.getMessage());
        }

        return empl;
    }

    /**
     * getAllRowsQuery
     * <p>
     * Returns the query for retrieving all rows for this table
     *
     * @return String - equivalent to "select * from tableName"
     */
    String getAllRowsQuery() {
        return _empQueries.getProperty("EMP_GET_ALL");
    }

    /**
     * getInsertQuery
     * <p>
     * Returns the INSERT query for this table
     *
     * @return String - INSERT query
     */
    String getInsertQuery() {
        return _empQueries.getProperty("EMP_INSERT");
    }

    /**
     * getDeleteQuery
     * <p>
     * Returns the DELETE query for this table
     *
     * @return String - DELETE query
     */
    String getDeleteQuery() {
        return _empQueries.getProperty("EMP_DELETE_ID");
    }

    /**
     * getUpdateQuery
     * <p>
     * Returns the UPDATE query for this table
     *
     * @return String - UPDATE query
     */
    String getUpdateQuery() {
        return _empQueries.getProperty("EMP_UPDATE_ID");
    }

    /**
     * getPrimaryKey
     * <p>
     * Returns the Primary Key for this table
     *
     * @return String - Primary Key
     */
    String getPrimaryKey() {
        return _primaryKey;
    }


    /**
     * getDto
     * <p>
     * Returns the appropriate Data Transfer Object for this Data Access Object.
     *
     * @return appropriate DTO
     */
    BaseDto getDto() {
        return new EmployeeDto();
    }
}
