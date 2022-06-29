package com.employeeManagement.service;

import com.employeeManagement.dao.EmployeeDAO;
import com.employeeManagement.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    EmployeeDAO employeeDAO;

    public List<Employee> getAll() {
        return employeeDAO.getAll();
    }

    public Employee getEmployeeById(int id) {
        return employeeDAO.getById(id);
    }

    public List<Employee> getEmployeesByName(String name) {
        return employeeDAO.getByName(name);
    }

    public int saveEmployee(Employee employee) {
        return employeeDAO.save(employee);
    }

    public int deleteEmployee(int id) {
        return employeeDAO.delete(id);
    }

    public int updateEmployee(Employee employee, int id) {
        return employeeDAO.update(employee, id);
    }
}
