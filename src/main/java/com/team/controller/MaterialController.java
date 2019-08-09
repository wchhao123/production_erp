package com.team.controller;

import com.team.bean.COrder;
import com.team.bean.Material;
import com.team.bean.MaterialExample;
import com.team.bean.ResponseOV;
import com.team.service.MaterialService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class MaterialController {
    @Autowired
    MaterialService materialService;
    @RequestMapping("material/get/{id}")
    @ResponseBody
    public Material material1(@PathVariable("id") String id){
        Material material = materialService.selectByPrimaryKey(id);
        return material;
    }

    @RequestMapping("material/find")
    public String material(){
        return "/WEB-INF/jsp/material_list.jsp";
    }
  /*  @RequestMapping("material/list")
    @ResponseBody
    public List<Material> material1(){
        MaterialExample example = new MaterialExample();
        long l = materialService.countByExample(example);
        List<Material> materials = materialService.selectByExample(example);
        return materials;
    }*/

    @RequestMapping("material/list")
    @ResponseBody
    public ResponseOV<Material> list(int page, int rows) {
        ResponseOV<Material> pageMaterial = materialService.getPageMaterial(page, rows);
        return pageMaterial;
    }
}
