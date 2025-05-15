package org.dao;

import org.dao.exception.DaoException;
import util.jdbc.JdbcConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SqlInjection {

    public SqlInjection() {
    }

    public List<EmployeeDto> sqlInjectionExample() {
        List<EmployeeDto> all = new ArrayList<EmployeeDto>();
        //String value = "2";
        //String value = "0 OR 1 = 1";
        String value = "0; drop table importantTable";
        EmployeeDto dto = null;
        Statement stmt = null;
        ResultSet result = null;

        try {
            Connection conn = JdbcConnection.getConnection();
            String query = "SELECT * FROM Employee WHERE employee_id = " + value + ";";

            System.out.println("Query: " + query);

            stmt = conn.createStatement();
            result = stmt.executeQuery(query);
            while (result.next()) {
                dto = new EmployeeDto();
                all.add(dto);
                convertRStoDto(result, dto);
            }
        } catch (Exception se) {
            throw new RuntimeException(se);
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

    /**
     * convertRStoDto
     * <p>
     * Utility method that copies the values in the ResultSet into the DTO.
     * Needed specific implementation for the method getMultipleRows in the
     * BaseDaoImpl.
     *
     * @param ResultSet result - the source values from a query to the DB
     * @param BaseDto   dto - the destination Data Transfer Object
     */
    void convertRStoDto(ResultSet result, BaseDto dto) throws DaoException {
        EmployeeDto empl = (EmployeeDto) dto;
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
    }
}
