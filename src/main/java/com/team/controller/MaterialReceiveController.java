package com.team.controller;

import com.team.bean.MaterialExample;
import com.team.bean.MaterialReceive;
import com.team.bean.MaterialReceiveExample;
import com.team.bean.ResponseOV;
import com.team.service.MaterialReceiveService;
import com.team.util.ControllerUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

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
    public ResponseOV<MaterialReceive> responseOV(int page , int rows){
        return materialReceiveService.getMaterialReceive(page , rows);
 }
 //删除
    @RequestMapping("materialReceive/delete_judge")
    @ResponseBody
    public String deletejudge(){
        return "";
    }
    @RequestMapping("materialReceive/delete_batch")
    @ResponseBody
    public Map<String , String> deleteBatch(String ids){
        boolean b = materialReceiveService.deleteByPrimaryKey(ids);
        return ControllerUtil.returnMsg(b);
    }

    //增加
    @RequestMapping("materialReceive/add_judge")
    @ResponseBody
    public String addJudge(){
        return "";
    }
    @RequestMapping("materialReceive/add")
    public String add(){
        return "/WEB-INF/jsp/materialReceive_add.jsp";
    }

    @RequestMapping("materialReceive/insert")
    @ResponseBody
    public Map<String , String> insert(MaterialReceive materialReceive){
        boolean insert = materialReceiveService.insert(materialReceive);
        return ControllerUtil.returnMsg(insert);
    }

    //编辑
    @RequestMapping("materialReceive/edit_judge")
    @ResponseBody
    public String editJudge(){
        return "";
    }
    @RequestMapping("materialReceive/edit")
    public String edit(){
        return "/WEB-INF/jsp/materialReceive_edit.jsp";
    }

    @RequestMapping("materialReceive/update_all")
    @ResponseBody
    public Map<String , String> updateAll(MaterialReceive material){
        boolean b = materialReceiveService.updateByPrimaryKeySelective(material);
        return ControllerUtil.returnMsg(b);
    }
}
