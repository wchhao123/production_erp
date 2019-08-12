package com.team.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.team.bean.Employee;
import com.team.bean.MaterialReceive;
import com.team.bean.ResponseOV;
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

    @Override
    public ResponseOV<Employee> getPageEmployee(int page, int rows) {
        PageHelper.startPage(page  ,  rows);
        List<Employee> employees = employeeMapper.queryEmployee();
        PageInfo<Employee> pageInfo = new PageInfo<>(employees);
        long total = pageInfo.getTotal();
        ResponseOV<Employee> ov = new ResponseOV<>();
        ov.setTotal((int) total);
        ov.setRows(employees);
        return ov;
    }

    @Override
    public boolean deleteByPrimaryKey(String id) {
        int i = employeeMapper.deleteByPrimaryKey(id);
        return i == 1;
    }

    @Override
    public ResponseOV<Employee> searchEmployeeByCondition(int flag, String searchValue, int page, int rows) {
        PageHelper.startPage(page , rows);
        List<Employee> employees = employeeMapper.searchEmployeeByCondition(flag, "%"+searchValue+"%");
        PageInfo<Employee> info = new PageInfo<>(employees);
        ResponseOV<Employee> ov = new ResponseOV<>();
        ov.setRows(employees);
        ov.setTotal((int) info.getTotal());
        return ov;
    }
}
