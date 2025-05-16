package org.dao;

import org.dao.exception.DaoException;
import org.dto.DepartmentDto;
import org.dto.ListDto;

public interface DepartmentDao {

    /**
     * DepartmentDao
     * <p>
     * Interface for Data Access Object, DepartmentDao
     * <p>
     * Modifications:
     * <p>
     * 04/20/2024 - jhui - Created
     */
    DepartmentDto get(Integer id) throws DaoException;

    DepartmentDto getRow(String field, Object value) throws DaoException;

    ListDto getRows(String field, Object value) throws DaoException;

    ListDto getAll() throws DaoException;

    void save(DepartmentDto t) throws DaoException;

    void update(DepartmentDto t, String[] params) throws DaoException;

    void delete(DepartmentDto t) throws DaoException;

}
