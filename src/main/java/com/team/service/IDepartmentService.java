package com.team.service;

import com.team.bean.Department;
import com.team.bean.ResponseOV;

import java.util.List;

public interface IDepartmentService {
    ResponseOV<Department> getDepartmentlist();

    List<Department> getDepartmentData();
}
