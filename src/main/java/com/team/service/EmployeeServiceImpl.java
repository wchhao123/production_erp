package com.team.service;

import com.team.bean.Employee;
import com.team.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
    public List<Employee> getEmployees() {
        return employeeMapper.selectByExample(null);
    }

    @Override
    public Employee getEmployeeById(String id) {
        //返回的employee需要封装departmentBean，因此此方法需另写
        return employeeMapper.getEmployeeById(id);
    }

    @Override
    public boolean updateEmployee(Employee employee) {
        int update = employeeMapper.updateByPrimaryKeySelective(employee);
        return update == 1;
    }
}
