package com.team.controller;

import com.team.bean.COrder;
import com.team.bean.Process;
import com.team.bean.ResponseOV;
import com.team.bean.TechnologyPlan;
import com.team.service.ProcessService;
import com.team.service.TechnologyPlanService;
import com.team.util.ControllerUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
    /*@PostMapping("insert")
    @ResponseBody
    public Map<String, String> insert(Process process) {
        int b = processService.insertProcess(process);
        return ControllerUtil.returnMsg(b);
    }*/
    @PostMapping("insert")
    @ResponseBody
    public int insert(Process process) {
        int b = processService.insertProcess(process);
        return b;
    }

}
