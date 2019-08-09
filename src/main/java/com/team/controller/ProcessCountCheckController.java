package com.team.controller;

import com.github.pagehelper.PageInfo;
import com.team.bean.ProcessCountCheck;
import com.team.bean.ResponseOV;
import com.team.service.ProcessCountCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("p_count_check")
public class ProcessCountCheckController {
    @Autowired
    private ProcessCountCheckService processCountCheckService;

    @RequestMapping("find")
    public String find(){
        return "/WEB-INF/jsp/p_count_check_list.jsp";
    }

    @RequestMapping("list")
    @ResponseBody
    public ResponseOV<ProcessCountCheck> getPageProcessCountCheck(int page, int rows){
        List<ProcessCountCheck> processCountChecks = processCountCheckService.getPageProcessCountCheck(page, rows);
        PageInfo<ProcessCountCheck> pageInfo = new PageInfo<>(processCountChecks);
        ResponseOV<ProcessCountCheck> responseOV = new ResponseOV<>((int)pageInfo.getTotal(), processCountChecks);
        return responseOV;
    }
}
