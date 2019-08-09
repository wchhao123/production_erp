package com.team.controller;

import com.team.bean.ResponseOV;
import com.team.bean.UnqualifyApply;
import com.team.service.UnqualifyApplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("unqualify")
public class UnqualifyApplyController {
    @Autowired
    private UnqualifyApplyService unqualifyApplyService;

    @RequestMapping("find")
    public String find(){
        return "/WEB-INF/jsp/unqualify_list.jsp";
    }

    @RequestMapping("list")
    @ResponseBody
    public ResponseOV<UnqualifyApply> list(int page, int rows){
        return unqualifyApplyService.getPageUnqualifyApply(page, rows);
    }
}
