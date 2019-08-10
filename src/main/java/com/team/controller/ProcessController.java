package com.team.controller;

import com.team.bean.*;
import com.team.bean.Process;
import com.team.service.ProcessService;
import com.team.service.TechnologyPlanService;
import com.team.util.ControllerUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("process")
public class ProcessController {

    @Autowired
    private ProcessService processService;

    @GetMapping("find")
    public String find() {
        return "/WEB-INF/jsp/process_list.jsp";
    }

    @RequestMapping("list")
    @ResponseBody
    public ResponseOV<Process> list(int page, int rows) {
        return processService.getPageProcess(page, rows);
    }

    @GetMapping("add_judge")
    @ResponseBody
    public String insertJudge() {
        return "";
    }
    @GetMapping("add")
    public String addPage() {
        return "/WEB-INF/jsp/process_add.jsp";
    }
    @PostMapping("insert")
    @ResponseBody
    public Map<String, String> insert(Process process) {
        boolean b = processService.insertProcess(process);
        return ControllerUtil.returnMsg(b);
    }

    @GetMapping("delete_judge")
    @ResponseBody
    public void deleteJudge() {
    }
    @PostMapping("delete_batch")
    @ResponseBody
    public Map<String, String> deleteBatch(String[] ids) {
        boolean b = processService.deleteByIds(ids);
        return ControllerUtil.returnMsg(b);
    }


    @RequestMapping("get/{id}")
    @ResponseBody
    public Process getProcess(@PathVariable("id") String id) {
        return processService.getProcessById(id);
    }
    @PostMapping("get_data")
    @ResponseBody
    public List<Process> getData() {
        return processService.getProcesses();
    }
    @GetMapping("edit_judge")
    @ResponseBody
    public void editJudge() {
    }
    @GetMapping("edit")
    public String editPage() {
        return "/WEB-INF/jsp/process_edit.jsp";
    }
    @PostMapping("update_all")
    @ResponseBody
    public Map<String, String> updateAll(Process process) {
        boolean b = processService.updateProcess(process);
        return ControllerUtil.returnMsg(b);
    }
    @PostMapping("update_note")
    @ResponseBody
    public Map<String, String> updateNote(String processId, String note) {
        boolean b = processService.updateProcessNoteById(processId, note);
        return ControllerUtil.returnMsg(b);
    }

    @GetMapping(value = {"search_process_by_processId","search_process_by_processName"})
    @ResponseBody
    public ResponseOV<Process> searchProcessById(HttpServletRequest request,
                                              String searchValue, int page, int rows) {
        int flag;
        if (request.getRequestURI().endsWith("search_process_by_processId")) {
            flag = 1;
        } else {
            flag= 2;
        }
        return processService.searchProcessByCondition(flag,searchValue, page, rows);
    }

}
