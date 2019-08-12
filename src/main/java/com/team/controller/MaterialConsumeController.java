package com.team.controller;

import com.team.bean.MaterialConsume;
import com.team.bean.ResponseOV;
import com.team.service.MaterialConsumeService;
import com.team.util.ControllerUtil;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
public class MaterialConsumeController {

    @Autowired
    MaterialConsumeService materialConsumeService;


    @RequestMapping("materialConsume/find")
    public String materialConsume(){
        return "/WEB-INF/jsp/materialConsume_list.jsp";
    }

    @RequestMapping("materialConsume/list")
    @ResponseBody
    public ResponseOV<MaterialConsume> materialConsumes(int page , int rows){
        ResponseOV<MaterialConsume> materialConsume = materialConsumeService.getMaterialConsume(page, rows);
        return materialConsume;
    }

    //新增
    @RequestMapping("materialConsume/add_judge")
    @ResponseBody
    public String material2(){
        return "";
    }
    @RequestMapping("materialConsume/add")
    public String material3(){
        return "/WEB-INF/jsp/materialConsume_add.jsp";
    }
    @RequestMapping("materialConsume/insert")
    @ResponseBody
    public Map<String , String> insert(MaterialConsume material){
        boolean insert = materialConsumeService.insert(material);
        return ControllerUtil.returnMsg(insert);
    }
//删除
@RequestMapping("materialConsume/delete_judge")
@ResponseBody
public String deletejudge(){
    return "";
}
    @RequestMapping("materialConsume/delete_batch")
    @ResponseBody
    public Map<String ,String> deleteBatch(String[] ids){
        boolean b = false;
        for (String id : ids) {
            b = materialConsumeService.deleteByPrimaryKey(id);
        }
        return ControllerUtil.returnMsg(b);
    }
    //编辑
    @RequestMapping("materialConsume/edit_judge")
    @ResponseBody
    public String editJudge(){
        return "";
    }
    @RequestMapping("materialConsume/edit")
    public String edit(){
        return "/WEB-INF/jsp/materialConsume_edit.jsp";
    }
    @RequestMapping("materialConsume/update_all")
    @ResponseBody
    public Map<String , String> updateAll(MaterialConsume materialConsume){
        boolean b = materialConsumeService.updateByPrimaryKey(materialConsume);
        return ControllerUtil.returnMsg(b);
    }
    //查询
    @RequestMapping(value = {"materialConsume/search_materialConsume_by_consumeId" , "materialConsume/search_materialConsume_by_materialId"
    ,"materialConsume/search_materialConsume_by_workId"})
    @ResponseBody
    public ResponseOV<MaterialConsume> searchCondition(HttpServletRequest request , String searchValue , int page , int rows){
        int flag;
        if (request.getRequestURI().endsWith("materialConsume/search_materialConsume_by_consumeId")){
            flag =1;
        }else if (request.getRequestURI().endsWith("materialConsume/search_materialConsume_by_materialId")){
            flag = 2;
        }else {
            flag = 3;
        }
        return materialConsumeService.searchMaterialConsumeByCondition(flag , searchValue  ,page , rows);
    }
}
