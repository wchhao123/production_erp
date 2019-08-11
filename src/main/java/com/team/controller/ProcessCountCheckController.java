package com.team.controller;

import com.github.pagehelper.PageInfo;
import com.team.bean.ProcessCountCheck;
import com.team.bean.ResponseOV;
import com.team.service.ProcessCountCheckService;
import com.team.util.ControllerUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping({"p_count_check", "pCountCheck"})
public class ProcessCountCheckController {
    @Autowired
    private ProcessCountCheckService processCountCheckService;

    @RequestMapping("find")
    public String find(){
        return "/WEB-INF/jsp/p_count_check_list.jsp";
    }

    @RequestMapping("list")
    @ResponseBody
    public ResponseOV<ProcessCountCheck> getPageProcessCountCheck(int page, int rows){
        List<ProcessCountCheck> processCountChecks = processCountCheckService.getPageProcessCountCheck(page, rows);
        PageInfo<ProcessCountCheck> pageInfo = new PageInfo<>(processCountChecks);
        ResponseOV<ProcessCountCheck> responseOV = new ResponseOV<>((int)pageInfo.getTotal(), processCountChecks);
        return responseOV;
    }

    @GetMapping("add_judge")
    @ResponseBody
    public void addJudge() {

    }
    @GetMapping("add")
    public String add() {
        return "/WEB-INF/jsp/p_count_check_add.jsp";
    }
    @PostMapping("insert")
    @ResponseBody
    public Map<String, String> insert(ProcessCountCheck processCountCheck) {
        boolean b = processCountCheckService.insertProcessCountCheck(processCountCheck);
        return ControllerUtil.returnMsg(b);
    }

    @GetMapping("edit_judge")
    @ResponseBody
    public void editJudge() {

    }
    @GetMapping("edit")
    public String edit() {
        return "/WEB-INF/jsp/p_count_check_edit.jsp";
    }
    @PostMapping("update_all")
    @ResponseBody
    public Map<String, String> updateAll(ProcessCountCheck processCountCheck) {
        boolean b = processCountCheckService.updateProcessCountCheck(processCountCheck);
        return ControllerUtil.returnMsg(b);
    }

    @GetMapping("delete_judge")
    @ResponseBody
    public void deleteJudge() {

    }
    @PostMapping("delete_batch")
    @ResponseBody
    public Map<String, String> deleteBatch(String[] ids) {
        boolean b = processCountCheckService.deleteByIds(ids);
        return ControllerUtil.returnMsg(b);
    }

    @GetMapping("search_pCountCheck_by_pCountCheckId")
    @ResponseBody
    public ResponseOV<ProcessCountCheck> searchProcessCountCheckById(String searchValue, int page, int rows) {
        return processCountCheckService.searchProcessCountCheckByCondition(searchValue, page, rows);
    }

    @PostMapping("update_note")
    @ResponseBody
    public Map<String, String> updateNote(ProcessCountCheck processCountCheck){
        boolean b = processCountCheckService.updateProcessCountCheck(processCountCheck);
        return ControllerUtil.returnMsg(b);
    }
}
