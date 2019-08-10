package com.team.service;

import com.team.bean.Department;
import com.team.bean.ResponseOV;
import com.team.mapper.DepartmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements IDepartmentService {
    @Autowired
    private DepartmentMapper departmentMapper;
    @Override
    public ResponseOV<Department> getDepartmentlist() {
        ResponseOV<Department> responseOV=new ResponseOV<>();
        List<Department> departments = departmentMapper.selectByExample(null);
        responseOV.setTotal(0);
        responseOV.setRows(departments);
        return responseOV;
    }

    @Override
    public List<Department> getDepartmentData() {
        return departmentMapper.selectByExample(null);
    }
}
