package com.employeeManagement.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import com.employeeManagement.dao.EmployeeDAO;
import com.employeeManagement.model.Employee;
import com.employeeManagement.service.EmployeeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootTest
@RunWith(SpringRunner.class)
public class EmployeeControllerTest {

    @Autowired
    private EmployeeService employeeService;

    @MockBean
    private EmployeeDAO employeeDAO;

    @Test
    public void testSaveEmployee() {
        Employee employee = new Employee();
        when(employeeDAO.save(employee)).thenReturn(1);
        assertEquals(1,employeeService.saveEmployee(employee));
    }

    @Test
    public void testGetAllEmployees() {
        when(employeeDAO.getAll()).thenReturn(Stream.of(new Employee(1,"Dave", "dave234@gamil.com", "Corporate"),
                new Employee(2, "Sasha", "sash14@gmail.com","Treasury")).collect(Collectors.toList()));
        assertEquals(2, employeeService.getAll().stream().count());
    }
}
