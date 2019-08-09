package com.team.controller;

import com.team.bean.Custom;
import com.team.bean.ResponseOV;
import com.team.service.ICustomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("custom")
public class CustomController {

    @Autowired
    private ICustomService customService;

    @RequestMapping("get/{id}")
    @ResponseBody
    public Custom getCustom(@PathVariable("id") String id) {
        return customService.getCustomById(id);
    }

    @GetMapping("find")
    public String find() {
        return "/WEB-INF/jsp/custom_list.jsp";
    }

    @GetMapping("list")
    @ResponseBody
    public ResponseOV<Custom> list(int page, int rows) {
        return customService.getCustoms(page, rows);
    }
}
