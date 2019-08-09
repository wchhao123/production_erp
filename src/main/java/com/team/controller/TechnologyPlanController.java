package com.team.controller;

import com.team.bean.ResponseOV;
import com.team.bean.TechnologyPlan;
import com.team.service.TechnologyPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("technologyPlan")
public class TechnologyPlanController {

    @Autowired
    private TechnologyPlanService technologyPlanService;

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
