package com.team.controller;

import com.github.pagehelper.PageHelper;
import com.team.bean.Custom;
import com.team.bean.ResponseOV;
import com.team.bean.Technology;
import com.team.mapper.TechnologyMapper;
import com.team.service.ICustomService;
import com.team.service.ITechnologyService;
import com.team.service.ProcessService;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("technology")
public class TechnologyController {
    @Autowired
    private ITechnologyService technologyService;

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
}
