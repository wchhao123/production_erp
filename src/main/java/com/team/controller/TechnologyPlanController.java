package com.team.controller;

import com.team.bean.*;
import com.team.service.TechnologyPlanService;
import com.team.util.ControllerUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("technologyPlan")
public class TechnologyPlanController {

    @Autowired
    private TechnologyPlanService technologyPlanService;

    @RequestMapping("get/{id}")
    @ResponseBody
    public TechnologyPlan getTechnologyPlan(@PathVariable("id") String id) {
        return technologyPlanService.getTechnologyPlanById(id);
    }

    @PostMapping("get_data")
    @ResponseBody
    public List<TechnologyPlan> getData() {
        return technologyPlanService.getTechnologyPlans();
    }


    @GetMapping("find")
    public String find() {
        return "/WEB-INF/jsp/technologyPlan_list.jsp";
    }

    @RequestMapping("list")
    @ResponseBody
    public ResponseOV<TechnologyPlan> list(int page, int rows) {
        return technologyPlanService.getPageTechnologyPlan(page, rows);
    }

    @GetMapping("add_judge")
    @ResponseBody
    public String insertJudge() {
        return "";
    }
    @GetMapping("add")
    public String addPage() {
        return "/WEB-INF/jsp/technologyPlan_add.jsp";
    }
    @PostMapping("insert")
    @ResponseBody
    public Map<String, String> insert(TechnologyPlan technologyPlan) {
        boolean b = technologyPlanService.insertTechnologyPlan(technologyPlan);
        return ControllerUtil.returnMsg(b);
    }

    @GetMapping("delete_judge")
    @ResponseBody
    public void deleteJudge() {
    }
    @PostMapping("delete_batch")
    @ResponseBody
    public Map<String, String> deleteBatch(String[] ids) {
        boolean b = technologyPlanService.deleteByIds(ids);
        return ControllerUtil.returnMsg(b);
    }

    @GetMapping("edit_judge")
    @ResponseBody
    public void editJudge() {
    }
    @GetMapping("edit")
    public String editPage() {
        return "/WEB-INF/jsp/technologyPlan_edit.jsp";
    }
    @PostMapping("update_all")
    @ResponseBody
    public Map<String, String> updateAll(TechnologyPlan technologyPlan) {
        boolean b = technologyPlanService.updateTechnologyPlan(technologyPlan);
        return ControllerUtil.returnMsg(b);
    }
    @PostMapping("update_note")
    @ResponseBody
    public Map<String, String> updateNote(String technologyPlanId, String note) {
        boolean b = technologyPlanService.updateTechnologyPlanNoteById(technologyPlanId, note);
        return ControllerUtil.returnMsg(b);
    }

    @GetMapping(value = {"search_technologyPlan_by_technologyPlanId","search_technologyPlan_by_technologyPlanName"})
    @ResponseBody
    public ResponseOV<TechnologyPlan> searchTechnologyPlanById(HttpServletRequest request,
                                                                             String searchValue, int page, int rows) {
        int flag;
        if (request.getRequestURI().endsWith("search_technologyPlan_by_technologyPlanId")) {
            flag = 1;
        } else {
            flag= 2;
        }
        return technologyPlanService.searchTechnologyPlanByCondition(flag,searchValue, page, rows);
    }
}
