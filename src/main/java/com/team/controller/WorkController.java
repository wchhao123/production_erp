package com.team.controller;

import com.team.bean.Work;
import com.team.service.WorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
public class WorkController {
@Autowired
    WorkService workService;
    @RequestMapping("work/get_data")
    @ResponseBody
    public List<Work> getData(){
       return workService.selectByExample();
    }
}
