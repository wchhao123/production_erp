package com.team.controller;

import com.team.bean.Task;
import com.team.bean.ResponseOV;
import com.team.bean.Task;
import com.team.service.ITaskService;
import com.team.util.ControllerUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("task")
public class TaskController {
    
    @Autowired
    private ITaskService service;

    @RequestMapping("get/{id}")
    @ResponseBody
    public Task getTask(@PathVariable("id")String id) {
        return service.getTaskById(id);
    }

    @GetMapping("find")
    public String find() {
        return "/WEB-INF/jsp/task_list.jsp";
    }

    @GetMapping("list")
    @ResponseBody
    public ResponseOV<Task> list(int page, int rows) {
        return service.getTasks(page, rows);
    }

    @PostMapping("get_data")
    @ResponseBody
    public List<Task> getData() {
        return service.getTasks();
    }

    @GetMapping("edit_judge")
    @ResponseBody
    public void editJudge() {

    }

    @GetMapping("edit")
    public String editPage() {
        return "/WEB-INF/jsp/Task_edit.jsp";
    }

    @PostMapping("update_all")
    @ResponseBody
    public Map<String, String> updateAll(Task Task) {

        boolean b = service.updateTask(Task);
        return ControllerUtil.returnMsg(b);
    }

   /* @PostMapping("update_note")
    @ResponseBody
    public Map<String, String> updateNote(String TaskId, String note) {

        boolean b = service.updateTaskNoteById(TaskId, note);
        return ControllerUtil.returnMsg(b);
    }*/

    @GetMapping("delete_judge")
    @ResponseBody
    public void deleteJudge() {

    }

    @PostMapping("delete_batch")
    @ResponseBody
    public Map<String, String> deleteBatch(String[] ids) {
        boolean b = service.deleteByIds(ids);
        return ControllerUtil.returnMsg(b);
    }

    @GetMapping("add_judge")
    @ResponseBody
    public String insertJudge() {
        return "";
    }

    @GetMapping("add")
    public String addPage() {
        return "/WEB-INF/jsp/Task_add.jsp";

    }

    @PostMapping("insert")
    @ResponseBody
    public Map<String, String> insert(Task Task) {
        boolean b = service.insertTask(Task);
        return ControllerUtil.returnMsg(b);
    }

    @GetMapping(value = {"search_task_by_taskId",
            "search_task_by_taskWorkId","search_task_by_taskManufactureSn"})
    @ResponseBody
    public ResponseOV<Task> searchOrderById(HttpServletRequest request,
                                               String searchValue, int page, int rows) {
        int flag;
        if (request.getRequestURI().endsWith("search_task_by_taskId")) {
            flag = 1;
        } else if (request.getRequestURI().endsWith("search_task_by_taskWorkId")) {
            flag= 2;
        } else {
            flag = 3;
        }
        return service.searchTaskByCondition(flag,searchValue, page, rows);
    }
}
