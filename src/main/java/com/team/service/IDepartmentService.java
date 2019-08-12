package com.team.service;

import com.team.bean.Department;
import com.team.bean.ResponseOV;

import java.util.List;

public interface IDepartmentService {
    ResponseOV<Department> getDepartmentlist();

    List<Department> getDepartmentData();

    List<Department> getPageDepartment(int page, int rows);

    boolean insertDepartment(Department department);

    boolean deleteByIds(String[] ids);

    boolean updateAllById(Department department);

    boolean updateNoteById(String departmentId, String note);

    ResponseOV<Department> searchDepartmentByCondition(int flag, String searchValue, int page, int rows);
}
