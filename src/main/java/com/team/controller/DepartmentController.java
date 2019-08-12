package com.team.controller;

import com.github.pagehelper.PageInfo;
import com.team.bean.Department;
import com.team.bean.ResponseOV;
import com.team.service.IDepartmentService;
import com.team.util.ControllerUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
import java.util.Map;

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

    @GetMapping("find")
    public String find() {
        return "/WEB-INF/jsp/department_list.jsp";
    }

    @RequestMapping("list")
    @ResponseBody
    public ResponseOV<Department> list(int page, int rows) {
        List<Department> finalCountChecks = departmentService.getPageDepartment(page, rows);
        PageInfo<Department> pageInfo = new PageInfo<>(finalCountChecks);
        ResponseOV<Department> responseOV = new ResponseOV<>((int) pageInfo.getTotal(), finalCountChecks);
        return responseOV;
    }

    @GetMapping("add_judge")
    @ResponseBody
    public void insertJudge() {

    }

    @GetMapping("add")
    public String addPage() {
        return "/WEB-INF/jsp/department_add.jsp";

    }

    @PostMapping("insert")
    @ResponseBody
    public Map<String, String> insert(Department department) {
        boolean b = departmentService.insertDepartment(department);
        return ControllerUtil.returnMsg(b);
    }

    @GetMapping("delete_judge")
    @ResponseBody
    public void deleteJudge() {

    }

    @PostMapping("delete_batch")
    @ResponseBody
    public Map<String, String> deleteBatch(String[] ids) {
        boolean b = departmentService.deleteByIds(ids);
        System.out.println(b);
        return ControllerUtil.returnMsg(b);
    }

    @GetMapping("edit_judge")
    @ResponseBody
    public void editJudge() {

    }

    @GetMapping("edit")
    public String editPage() {
        return "/WEB-INF/jsp/department_edit.jsp";
    }

    @PostMapping("update_all")
    @ResponseBody
    public Map<String, String> updateAll(Department department) {
        boolean b = departmentService.updateAllById(department);
        return ControllerUtil.returnMsg(b);
    }

    @PostMapping("update_note")
    @ResponseBody
    public Map<String, String> updateNote(String departmentId, String note) {
        boolean b = departmentService.updateNoteById(departmentId, note);
        return ControllerUtil.returnMsg(b);
    }

    @GetMapping(value ={"search_department_by_departmentId",
    "search_department_by_departmentName"})
    @ResponseBody
    public ResponseOV<Department> searchOrderById(HttpServletRequest request,
                                            String searchValue, int page, int rows) {
        int flag;
        if (request.getRequestURI().endsWith("search_department_by_departmentId")) {
            flag = 1;
        } else {
            flag = 2;
        }
        return departmentService.searchDepartmentByCondition(flag, searchValue, page, rows);
    }

}
