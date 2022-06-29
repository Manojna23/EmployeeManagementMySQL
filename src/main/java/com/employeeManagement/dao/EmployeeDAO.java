package com.employeeManagement.dao;

import com.employeeManagement.model.Employee;

import java.util.List;

public interface EmployeeDAO {

    int save(Employee employee);

    int update(Employee employee, int id);

    int delete(int id);

    List<Employee> getAll();

    Employee getById(int id);

    List<Employee> getByName(String name);
}
