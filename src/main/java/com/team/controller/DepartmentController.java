package com.team.controller;

import com.team.bean.Department;
import com.team.bean.Device;
import com.team.bean.ResponseOV;
import com.team.service.IDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("department")
public class DepartmentController {
    @Autowired
    private IDepartmentService departmentService;

    @RequestMapping("get_data")
    @ResponseBody
    public ResponseOV<Department> getDepartmentlist() {
        return departmentService.getDepartmentlist();
    }

}
