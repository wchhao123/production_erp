package com.team.controller;

import com.team.bean.MaterialConsume;
import com.team.bean.ResponseOV;
import com.team.service.MaterialConsumeService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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

}
