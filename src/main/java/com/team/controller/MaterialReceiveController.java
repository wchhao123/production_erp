package com.team.controller;

import com.team.bean.MaterialExample;
import com.team.bean.MaterialReceive;
import com.team.bean.MaterialReceiveExample;
import com.team.service.MaterialReceiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class MaterialReceiveController {
    @Autowired
    MaterialReceiveService materialReceiveService;

    @RequestMapping("materialReceive/find")
    public String materialReceive(){
        return "/WEB-INF/jsp/materialReceive_list.jsp";
    }

    @RequestMapping("materialReceive/list")
    @ResponseBody
    public List<MaterialReceive> materialReceives(){
        MaterialReceiveExample materialReceiveExample = new MaterialReceiveExample();
        List<MaterialReceive> materialReceives = materialReceiveService.selectByExample(materialReceiveExample);
        return materialReceives;
    }

}
