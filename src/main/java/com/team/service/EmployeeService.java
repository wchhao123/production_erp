package com.team.service;

import com.team.bean.Employee;
import com.team.bean.ResponseOV;

import java.util.List;

public interface EmployeeService {
    List<Employee> getEmployees();

    Employee getEmployeeById(String id);

    boolean updateEmployee(Employee employee);

    ResponseOV<Employee> getPageEmployee(int page, int rows);
}
