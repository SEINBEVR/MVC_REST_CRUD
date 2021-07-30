package com.kirillvasilev.spring.rest.controller;

import com.kirillvasilev.spring.rest.entity.Employee;
import com.kirillvasilev.spring.rest.exception_handling.NoSuchEmployeeException;
import com.kirillvasilev.spring.rest.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MyRestController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    public List<Employee> showAllEmployees() {
        List<Employee> allEmployees = employeeService.getAllEmployees();
        return allEmployees;
    }

    @GetMapping("/employees/{id}")
    public Employee getEmployee(@PathVariable int id) {
        Employee employee = employeeService.getEmployee(id);

        if(employee==null) {
            throw new NoSuchEmployeeException("There is no employee with id = " + id + "in database");
        }

        return employee;
    }

}
