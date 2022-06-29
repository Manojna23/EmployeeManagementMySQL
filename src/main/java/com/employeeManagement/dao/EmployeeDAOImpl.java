package com.employeeManagement.dao;

import com.employeeManagement.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO{

    @Autowired
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    private static final String SELECT_ALL="SELECT * FROM COMPANY.EMPLOYEE";
    private static final String SELECT_EMP_BY_ID="SELECT * FROM EMPLOYEE WHERE EMPID=:empId";
    private static final String SELECT_EMP_BY_NAME="SELECT * FROM EMPLOYEE WHERE NAME=:name";
    private static final String INSERT_INTO_EMPLOYEE = "INSERT INTO EMPLOYEE (NAME, EMAIL, DEPARTMENT) VALUES (:name, :email, :department)";
    private static final String DELETE_FROM_EMPLOYEE = "DELETE FROM EMPLOYEE WHERE EMPID=:empId";
    private static final String UPDATE_EMPLOYEE = "UPDATE EMPLOYEE SET NAME=:name, EMAIL=:mail, Department=:department WHERE EMPID=:empId";

    @Override
    public int save(Employee employee) {
        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
        mapSqlParameterSource.addValue("name", employee.getName());
        mapSqlParameterSource.addValue("email", employee.getEmail());
        mapSqlParameterSource.addValue("department", employee.getDepartment());
        return namedParameterJdbcTemplate.update(INSERT_INTO_EMPLOYEE, mapSqlParameterSource);
    }

    @Override
    public int update(Employee employee, int id) {
        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
        mapSqlParameterSource.addValue("name", employee.getName());
        mapSqlParameterSource.addValue("mail", employee.getEmail());
        mapSqlParameterSource.addValue("department", employee.getDepartment());
        mapSqlParameterSource.addValue("empId", id);
        return namedParameterJdbcTemplate.update(UPDATE_EMPLOYEE, mapSqlParameterSource);
    }

    @Override
    public int delete(int id) {
        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
        mapSqlParameterSource.addValue("empId", id);
        return namedParameterJdbcTemplate.update(DELETE_FROM_EMPLOYEE, mapSqlParameterSource);
    }

    @Override
    public List<Employee> getAll() {
        return namedParameterJdbcTemplate.query(SELECT_ALL, new BeanPropertyRowMapper<Employee>(Employee.class));
    }

    @Override
    public Employee getById(int id) {
        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
        mapSqlParameterSource.addValue("empId", id);
        return namedParameterJdbcTemplate.query(SELECT_EMP_BY_ID, mapSqlParameterSource, new BeanPropertyRowMapper<Employee>(Employee.class)).get(0);
    }

    @Override
    public List<Employee> getByName(String name) {
        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
        mapSqlParameterSource.addValue("name", name);
        return namedParameterJdbcTemplate.query(SELECT_EMP_BY_NAME, mapSqlParameterSource, new BeanPropertyRowMapper<Employee>(Employee.class));
    }
}
