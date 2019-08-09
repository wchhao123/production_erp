package com.team.service;

import com.team.bean.Department;
import com.team.bean.ResponseOV;

public interface IDepartmentService {
    ResponseOV<Department> getDepartmentlist();
}
