package com.team.controller;

import com.team.bean.Employee;
import com.team.bean.Employee;
import com.team.service.EmployeeService;
import com.team.util.ControllerUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @PostMapping("get_data")
    @ResponseBody
    public List<Employee> getData() {
        return employeeService.getEmployees();
    }

    @RequestMapping("get/{id}")
    @ResponseBody
    public Employee getEmployee(@PathVariable("id")String id) {
        return employeeService.getEmployeeById(id);
    }

    @GetMapping("edit_judge")
    @ResponseBody
    public void editJudge() {

    }

    @PostMapping("update_all")
    @ResponseBody
    public Map<String, String> updateAll(Employee employee) {
        boolean b = employeeService.updateEmployee(employee);
        return ControllerUtil.returnMsg(b);
    }

}
