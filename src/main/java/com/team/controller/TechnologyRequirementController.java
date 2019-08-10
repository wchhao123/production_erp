package com.team.controller;

import com.team.bean.ResponseOV;
import com.team.bean.Technology;
import com.team.bean.TechnologyRequirement;
import com.team.service.ITechnologyRequirementService;
import com.team.service.ITechnologyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("technologyRequirement")
public class TechnologyRequirementController {
    @Autowired
    private ITechnologyRequirementService iTechnologyRequirementService;

    @RequestMapping("get/{id}")
    @ResponseBody
    public TechnologyRequirement getTechnologyRequirement(@PathVariable("id") String id) {
        return iTechnologyRequirementService.getTechnologyRequirementById(id);
    }

    @GetMapping("find")
    public String find() {
        return "/WEB-INF/jsp/technologyRequirement_list.jsp";
    }

    @GetMapping("list")
    @ResponseBody
    public ResponseOV<TechnologyRequirement> list(int page, int rows) {
        return iTechnologyRequirementService.getTechnologyRequirementsById(page, rows);
    }

}
