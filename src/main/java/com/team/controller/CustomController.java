package com.team.controller;

import com.team.bean.Custom;
import com.team.service.ICustomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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


}
