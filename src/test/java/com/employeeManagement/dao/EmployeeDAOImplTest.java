package com.employeeManagement.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

public class EmployeeDAOImplTest {
    @Autowired
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;
}
