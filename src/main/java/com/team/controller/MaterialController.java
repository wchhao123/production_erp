package com.team.controller;

import com.team.bean.COrder;
import com.team.bean.Material;
import com.team.bean.MaterialExample;
import com.team.bean.ResponseOV;
import com.team.service.MaterialService;
import com.team.util.ControllerUtil;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

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
    //新增
 @RequestMapping("material/add_judge")
 @ResponseBody
 public String material2(){
        return "";
 }
 @RequestMapping("material/add")
 public String material3(){
        return "/WEB-INF/jsp/material_add.jsp";
 }
 @RequestMapping("material/insert")
 @ResponseBody
 public Map<String , String> insert(Material material){
     boolean insert = materialService.insert(material);
     return ControllerUtil.returnMsg(insert);
 }
//删除
    @RequestMapping("material/delete_judge")
    @ResponseBody
    public String deletejudge(){
        return "";
    }
    @RequestMapping("material/delete_batch")
    @ResponseBody
    public Map<String ,String> deleteBatch(String[] ids){
        boolean b = false;
        for (String id : ids) {
             b = materialService.deleteByPrimaryKey(id);
        }
        return ControllerUtil.returnMsg(b);
    }
//编辑
    @RequestMapping("material/edit_judge")
    @ResponseBody
    public String editJudge(){
        return "";
    }
    @RequestMapping("material/edit")
    public String edit(){
        return "/WEB-INF/jsp/material_edit.jsp";
    }

    @RequestMapping("material/update_all")
    @ResponseBody
    public Map<String , String> updateAll(Material material){
        boolean b = materialService.updateByPrimaryKey(material);
        return ControllerUtil.returnMsg(b);
    }

    @RequestMapping("material/list")
    @ResponseBody
    public ResponseOV<Material> list(int page, int rows) {
        ResponseOV<Material> pageMaterial = materialService.getPageMaterial(page, rows);
        return pageMaterial;
    }

    @RequestMapping("material/get_data")
    @ResponseBody
    public List<Material>getData(){
       return materialService.selectByExample();
    }

    //查询
    @RequestMapping(value = {"material/search_material_by_materialId" , "material/search_material_by_materialType"})
    @ResponseBody
    public ResponseOV<Material> searchCondition(HttpServletRequest request , String searchValue , int page , int rows){
        int flag;
            if (request.getRequestURI().endsWith("material/search_material_by_materialId")){
                flag = 1;
            }else {
                flag = 2;
            }
            return materialService.searchMaterialByCondition(flag ,searchValue , page , rows);
    }
}
