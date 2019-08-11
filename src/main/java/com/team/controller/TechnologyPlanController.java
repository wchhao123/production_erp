package com.team.controller;

import com.team.bean.Custom;
import com.team.bean.ResponseOV;
import com.team.bean.Technology;
import com.team.bean.TechnologyPlan;
import com.team.service.TechnologyPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
}
