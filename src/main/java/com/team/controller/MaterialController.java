package com.team.controller;

import com.team.bean.Material;
import com.team.bean.MaterialExample;
import com.team.service.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class MaterialController {
    @Autowired
    MaterialService materialService;


    @RequestMapping("material/find")
    public String material(){
        return "material_list";
    }
    @RequestMapping("material/list")
    @ResponseBody
    public List<Material> material1(){
        MaterialExample example = new MaterialExample();
        long l = materialService.countByExample(example);
        List<Material> materials = materialService.selectByExample(example);
        return materials;
    }
}
