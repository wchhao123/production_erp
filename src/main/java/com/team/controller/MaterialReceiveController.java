package com.team.controller;

import com.team.bean.MaterialExample;
import com.team.bean.MaterialReceive;
import com.team.bean.MaterialReceiveExample;
import com.team.bean.ResponseOV;
import com.team.service.MaterialReceiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
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
    public ResponseOV<MaterialReceive> responseOV(int page , int rows){
        return materialReceiveService.getMaterialReceive(page , rows);
 }

}
