package com.team.controller;

import com.team.bean.ResponseOV;
import com.team.bean.Work;
import com.team.service.IWorkService;
import com.team.util.ControllerUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
@RequestMapping("Work")
public class WorkController {

    @Autowired
    private IWorkService workService;

    @GetMapping("find")
    public String find() {
        return "/WEB-INF/jsp/work_list.jsp";
    }

    @GetMapping("list")
    @ResponseBody
    public ResponseOV<Work> list(int page, int rows) {
        return workService.getWorks(page, rows);
    }

    @PostMapping("get_data")
    @ResponseBody
    public List<Work> getData() {
        return workService.selectByExample();
    }

    @GetMapping("edit_judge")
    @ResponseBody
    public void editJudge() {

    }

    @GetMapping("edit")
    public String editPage() {
        return "/WEB-INF/jsp/work_edit.jsp";
    }

    @PostMapping("update_all")
    @ResponseBody
    public Map<String, String> updateAll(Work work) {

        boolean b = workService.updateWork(work);
        return ControllerUtil.returnMsg(b);
    }

    @GetMapping("delete_judge")
    @ResponseBody
    public void deleteJudge() {

    }

    @PostMapping("delete_batch")
    @ResponseBody
    public Map<String, String> deleteBatch(String[] ids) {
        boolean b = workService.deleteWorksByIds(ids);
        return ControllerUtil.returnMsg(b);
    }

    @GetMapping("add_judge")
    @ResponseBody
    public String insertJudge() {
        return "";
    }

    @GetMapping("add")
    public String addPage() {
        return "/WEB-INF/jsp/work_add.jsp";

    }

    @PostMapping("insert")
    @ResponseBody
    public Map<String, String> insert(Work work) {
        boolean b = workService.insertWork(work);
        return ControllerUtil.returnMsg(b);
    }

    @GetMapping(value = {"search_work_by_workId", "search_work_by_workProduct",
            "search_work_by_workDevice","search_work_by_workProcess"})
    @ResponseBody
    public ResponseOV<Work> searchOrderById(HttpServletRequest request,
                                            String searchValue, int page, int rows) {
        int flag;
        if (request.getRequestURI().endsWith("search_work_by_workId")) {
            flag = 1;
        } else if (request.getRequestURI().endsWith("search_work_by_workProduct")) {
            flag= 2;
        } else if (request.getRequestURI().endsWith("search_work_by_workDevice")) {
            flag = 3;
        } else {
            flag = 4;
        }
        return workService.searchWorkByCondition(flag,searchValue, page, rows);
    }
}
