package com.team.controller;

import com.team.bean.Employee;
import com.team.bean.ResponseOV;
import com.team.service.EmployeeService;
import com.team.util.ControllerUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @PostMapping("get_data")
    @ResponseBody
    public List<Employee> getData() {
        return employeeService.getEmployees();
    }

    @RequestMapping("get/{id}")
    @ResponseBody
    public Employee getEmployee(@PathVariable("id")String id) {
        return employeeService.getEmployeeById(id);
    }

    //编辑
    @RequestMapping("edit")
    public String edit(){
        return "/WEB-INF/jsp/employee_edit.jsp";
    }
    @GetMapping("edit_judge")
    @ResponseBody
    public void editJudge() {

    }

    @PostMapping("update_all")
    @ResponseBody
    public Map<String, String> updateAll(@Validated Employee employee , BindingResult bindingResult) {
        boolean b = employeeService.updateEmployee(employee);
        HashMap<String, String> hashMap = new HashMap<>();
        if (b && !bindingResult.hasErrors()){
            hashMap.put("status" , "200");
            hashMap.put("msg" , "OK");
        }else {
            hashMap.put("status" , "100");
            hashMap.put("msg" , "请输入正确的身份证号");
        }
        return hashMap;
    }

    //删除
    @RequestMapping("delete_judge")
    @ResponseBody
    public String deletejudge(){
        return "";
    }
    @RequestMapping("delete_batch")
    @ResponseBody
    public Map<String ,String> deleteBatch(String[] ids){
        boolean b = false;
        for (String id : ids) {
            b = employeeService.deleteByPrimaryKey(id);
        }
        return ControllerUtil.returnMsg(b);
    }
    @RequestMapping("find")
    public String material(){
        return "/WEB-INF/jsp/employee_list.jsp";
    }

    @RequestMapping("list")
    @ResponseBody
    public ResponseOV<Employee> list(int page, int rows) {
        ResponseOV<Employee> pageEmployee = employeeService.getPageEmployee(page, rows);
        return pageEmployee;
    }

    //新增
    @RequestMapping("add_judge")
    @ResponseBody
    public String addJudge(){
        return "";
    }
    @RequestMapping("add")
    public String add(){
        return "/WEB-INF/jsp/employee_add.jsp";
    }
@RequestMapping("insert")
@ResponseBody
public Map<String , String> insert(@Validated Employee employee , BindingResult bindingResult){
    boolean insert = employeeService.insert(employee);
    HashMap<String, String> hashMap = new HashMap<>();
    if (insert && !bindingResult.hasErrors()){
        hashMap.put("status" , "200");
        hashMap.put("msg" , "OK");
    }else {
        hashMap.put("status" , "100");
        hashMap.put("msg" , "请输入正确的身份证号");
    }
    return hashMap;
}

    //模糊查询
    @RequestMapping(value = {"search_employee_by_employeeId" , "search_employee_by_employeeName"
            ,"search_employee_by_departmentName"})
    @ResponseBody
    public ResponseOV<Employee> searchCondition(HttpServletRequest request , String searchValue , int page , int rows){
        int flag;
        if (request.getRequestURI().endsWith("search_employee_by_employeeId")){
            flag =1;
        }else if (request.getRequestURI().endsWith("search_employee_by_employeeName")){
            flag = 2;
        }else {
            flag = 3;
        }
        return employeeService.searchEmployeeByCondition(flag , searchValue  ,page , rows);
    }

}
