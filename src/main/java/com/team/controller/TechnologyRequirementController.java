package com.team.controller;

import com.team.bean.ResponseOV;
import com.team.bean.TechnologyRequirement;
import com.team.service.TechnologyRequirementService;
import com.team.util.ControllerUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("technologyRequirement")
public class TechnologyRequirementController {
    @Autowired
    private TechnologyRequirementService technologyRequirementService;

    @RequestMapping("get/{id}")
    @ResponseBody
    public TechnologyRequirement getTechnologyRequirement(@PathVariable("id") String id) {
        return technologyRequirementService.getTechnologyRequirementById(id);
    }

    @RequestMapping("find")
    public String find() {
        return "/WEB-INF/jsp/technologyRequirement_list.jsp";
    }

    @GetMapping("list")
    @ResponseBody
    public ResponseOV<TechnologyRequirement> list(int page, int rows) {
        return technologyRequirementService.getTechnologyRequirementsById(page, rows);
    }

    @GetMapping("add_judge")
    @ResponseBody
    public String insertJudge() {
        return "";
    }
    @GetMapping("add")
    public String addPage() {
        return "/WEB-INF/jsp/technologyRequirement_add.jsp";
    }
    @PostMapping("insert")
    @ResponseBody
    public Map<String, String> insert(TechnologyRequirement technologyRequirement) {
        boolean b = technologyRequirementService.insertTechnologyRequirement(technologyRequirement);
        return ControllerUtil.returnMsg(b);
    }

    @GetMapping("delete_judge")
    @ResponseBody
    public void deleteJudge() {
    }
    @PostMapping("delete_batch")
    @ResponseBody
    public Map<String, String> deleteBatch(String[] ids) {
        boolean b = technologyRequirementService.deleteByIds(ids);
        return ControllerUtil.returnMsg(b);
    }

    @PostMapping("get_data")
    @ResponseBody
    public List<TechnologyRequirement> getData() {
        return technologyRequirementService.getTechnologyRequirements();
    }
    @GetMapping("edit_judge")
    @ResponseBody
    public void editJudge() {
    }
    @GetMapping("edit")
    public String editPage() {
        return "/WEB-INF/jsp/technologyRequirement_edit.jsp";
    }
    @PostMapping("update_all")
    @ResponseBody
    public Map<String, String> updateAll(TechnologyRequirement technologyRequirement) {
        boolean b = technologyRequirementService.updateTechnologyRequirement(technologyRequirement);
        return ControllerUtil.returnMsg(b);
    }
    @PostMapping("update_note")
    @ResponseBody
    public Map<String, String> updateNote(String technologyRequirementId, String note) {
        boolean b = technologyRequirementService.updateTechnologyRequirementNoteById(technologyRequirementId, note);
        return ControllerUtil.returnMsg(b);
    }


    @GetMapping(value = {"search_technologyRequirement_by_technologyRequirementId","search_technologyRequirement_by_technologyRequirementName"})
    @ResponseBody
    public ResponseOV<TechnologyRequirement> searchTechnologyRequirementById(HttpServletRequest request,
                                                 String searchValue, int page, int rows) {
        int flag;
        if (request.getRequestURI().endsWith("search_technologyRequirement_by_technologyRequirementId")) {
            flag = 1;
        } else {
            flag= 2;
        }
        return technologyRequirementService.searchTechnologyRequirementByCondition(flag,searchValue, page, rows);
    }

}
