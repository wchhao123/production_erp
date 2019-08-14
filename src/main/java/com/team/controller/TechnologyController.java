package com.team.controller;

import com.team.bean.ResponseOV;
import com.team.bean.Technology;
import com.team.bean.TechnologyRequirement;
import com.team.service.TechnologyService;
import com.team.util.ControllerUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("technology")
public class TechnologyController {
    @Autowired
    private TechnologyService technologyService;

    @RequestMapping("get/{id}")
    @ResponseBody
    public Technology getTechnology(@PathVariable("id") String id) {
        return technologyService.getTechnologyById(id);
    }

    @GetMapping("find")
    public String find() {
        return "/WEB-INF/jsp/technology_list.jsp";
    }

    @GetMapping("list")
    @ResponseBody
    public ResponseOV<Technology> list(int page, int rows) {
        return technologyService.getTechnologies(page, rows);
    }

    @PostMapping("get_data")
    @ResponseBody
    public List<Technology> getData() {
        return technologyService.getTechnologies();
    }
    @GetMapping("add_judge")
    @ResponseBody
    public String insertJudge() {
        return "";
    }
    @GetMapping("add")
    public String addPage() {
        return "/WEB-INF/jsp/technology_add.jsp";
    }
    @PostMapping("insert")
    @ResponseBody
    public Map<String, String> insert(Technology technology) {
        boolean b = technologyService.insertTechnology(technology);
        return ControllerUtil.returnMsg(b);
    }

    @GetMapping("delete_judge")
    @ResponseBody
    public void deleteJudge() {
    }
    @PostMapping("delete_batch")
    @ResponseBody
    public Map<String, String> deleteBatch(String[] ids) {
        boolean b = technologyService.deleteByIds(ids);
        return ControllerUtil.returnMsg(b);
    }

    @GetMapping("edit_judge")
    @ResponseBody
    public void editJudge() {
    }
    @GetMapping("edit")
    public String editPage() {
        return "/WEB-INF/jsp/technology_edit.jsp";
    }
    @PostMapping("update_all")
    @ResponseBody
    public Map<String, String> updateAll(Technology technology) {
        boolean b = technologyService.updateTechnology(technology);
        return ControllerUtil.returnMsg(b);
    }
    @PostMapping("update_note")
    @ResponseBody
    public Map<String, String> updateNote(String technologyId, String note) {
        boolean b = technologyService.updateTechnologyNoteById(technologyId, note);
        return ControllerUtil.returnMsg(b);
    }

    @GetMapping(value = {"search_technology_by_technologyId","search_technology_by_technologyName"})
    @ResponseBody
    public ResponseOV<Technology> searchTechnologyById(HttpServletRequest request,
                                                                             String searchValue, int page, int rows) {
        int flag;
        if (request.getRequestURI().endsWith("search_technology_by_technologyId")) {
            flag = 1;
        } else {
            flag= 2;
        }
        return technologyService.searchTechnologyByCondition(flag,searchValue, page, rows);
    }
}
