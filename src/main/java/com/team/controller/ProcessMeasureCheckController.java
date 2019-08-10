package com.team.controller;

import com.github.pagehelper.PageInfo;
import com.team.bean.ProcessMeasureCheck;
import com.team.bean.ResponseOV;
import com.team.service.ProcessMeasureCheckService;
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
@RequestMapping({"p_measure_check", "pMeasureCheck"})
public class ProcessMeasureCheckController {
    @Autowired
    private ProcessMeasureCheckService processMeasureCheckService;

    @RequestMapping("find")
    public String find(){
        return "/WEB-INF/jsp/p_measure_check_list.jsp";
    }

    @RequestMapping("list")
    @ResponseBody
    public ResponseOV<ProcessMeasureCheck> getPageProcessMeasureCheck(int page, int rows){
        List<ProcessMeasureCheck> processMeasureChecks = processMeasureCheckService.getPageProcessMeasureCheck(page, rows);
        PageInfo<ProcessMeasureCheck> pageInfo = new PageInfo<>(processMeasureChecks);
        ResponseOV<ProcessMeasureCheck> responseOV = new ResponseOV<>((int)pageInfo.getTotal(), processMeasureChecks);
        return responseOV;
    }

    @GetMapping("add_judge")
    @ResponseBody
    public void addJudge() {

    }
    @GetMapping("add")
    public String add() {
        return "/WEB-INF/jsp/p_measure_check_add.jsp";
    }
    @PostMapping("insert")
    @ResponseBody
    public Map<String, String> insert(ProcessMeasureCheck processMeasureCheck) {
        boolean b = processMeasureCheckService.insertProcessMeasureCheck(processMeasureCheck);
        return ControllerUtil.returnMsg(b);
    }

    @GetMapping("edit_judge")
    @ResponseBody
    public void editJudge() {

    }
    @GetMapping("edit")
    public String edit() {
        return "/WEB-INF/jsp/p_measure_check_edit.jsp";
    }
    @PostMapping("update_all")
    @ResponseBody
    public Map<String, String> updateAll(ProcessMeasureCheck processMeasureCheck) {
        boolean b = processMeasureCheckService.updateProcessMeasureCheck(processMeasureCheck);
        return ControllerUtil.returnMsg(b);
    }

    @GetMapping("delete_judge")
    @ResponseBody
    public void deleteJudge() {

    }
    @PostMapping("delete_batch")
    @ResponseBody
    public Map<String, String> deleteBatch(String[] ids) {
        boolean b = processMeasureCheckService.deleteByIds(ids);
        return ControllerUtil.returnMsg(b);
    }

    @GetMapping("search_pMeasureCheck_by_pMeasureCheckId")
    @ResponseBody
    public ResponseOV<ProcessMeasureCheck> searchProcessMeasureCheckById(String searchValue, int page, int rows) {
        return processMeasureCheckService.searchProcessMeasureCheckByCondition(searchValue, page, rows);
    }

    @PostMapping("update_note")
    @ResponseBody
    public Map<String, String> updateNote(ProcessMeasureCheck processMeasureCheck){
        boolean b = processMeasureCheckService.updateProcessMeasureCheck(processMeasureCheck);
        return ControllerUtil.returnMsg(b);
    }
}
