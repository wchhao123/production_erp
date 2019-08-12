package com.team.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.team.bean.Department;
import com.team.bean.DepartmentExample;
import com.team.bean.ResponseOV;
import com.team.mapper.DepartmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
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

    @Override
    public List<Department> getPageDepartment(int page, int rows) {
        PageHelper.startPage(page, rows);
        List<Department> departments = departmentMapper.selectByExample(null);
        return departments;
    }

    @Override
    public boolean insertDepartment(Department department) {
        return departmentMapper.insert(department) == 1;
    }

    @Override
    public boolean deleteByIds(String[] ids) {
        /*DepartmentExample e = new DepartmentExample();
        e.createCriteria().andDepartmentIdIn(new ArrayList<>(Arrays.asList(ids)));
        int i = departmentMapper.deleteByExample(e);*/
        int i = departmentMapper.batchDeleteByIds(ids);
        return i != 0;
    }

    @Override
    public boolean updateAllById(Department department) {
        return departmentMapper.updateByPrimaryKey(department) == 1;
    }

    @Override
    public boolean updateNoteById(String departmentId, String note) {
        Department department = new Department();
        department.setDepartmentId(departmentId);
        department.setNote(note);
        int i = departmentMapper.updateByPrimaryKeySelective(department);
        return i == 1;
    }

    @Override
    public ResponseOV<Department> searchDepartmentByCondition(int flag, String searchValue, int page, int rows) {
        DepartmentExample departmentExample = new DepartmentExample();
        String val = "%" + searchValue + "%";
        if (flag == 1) {
            departmentExample.createCriteria().andDepartmentIdLike(val);
        } else if (flag == 2) {
            departmentExample.createCriteria().andDepartmentNameLike(val);
        } else {
            departmentExample = null;
        }
        PageHelper.startPage(page, rows);
        List<Department> departments = departmentMapper.selectByExample(departmentExample);
        PageInfo<Department> info = new PageInfo<>(departments);

        ResponseOV<Department> ov = new ResponseOV<>();
        ov.setRows(departments);
        ov.setTotal((int) info.getTotal());
        return ov;
    }

}
