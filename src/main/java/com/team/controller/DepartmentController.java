package com.team.controller;

import com.team.bean.Department;
import com.team.service.IDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("department")
public class DepartmentController {
    @Autowired
    private IDepartmentService departmentService;

    @RequestMapping("get_data")
    @ResponseBody
    //get_ata返回的应是list数据
    /*public ResponseOV<Department> getDepartmentlist() {
        return departmentService.getDepartmentlist();
    }*/

    public List<Department> getDepartmentData(){
        return departmentService.getDepartmentData();
    }

}
