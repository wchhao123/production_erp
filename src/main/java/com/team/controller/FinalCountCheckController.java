package com.team.controller;

import com.github.pagehelper.PageInfo;
import com.team.bean.FinalCountCheck;
import com.team.bean.ResponseOV;
import com.team.service.FinalCountCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("f_count_check")
public class FinalCountCheckController {
    @Autowired
    private FinalCountCheckService finalCountCheckService;

    @RequestMapping("find")
    public String find(){
        return "/WEB-INF/jsp/f_count_check_list.jsp";
    }

    @RequestMapping("list")
    @ResponseBody
    public ResponseOV<FinalCountCheck> getPageFinalCountCheck(int page, int rows){
        List<FinalCountCheck> finalCountChecks = finalCountCheckService.getPageFinalCountCheck(page, rows);
        PageInfo<FinalCountCheck> pageInfo = new PageInfo<>(finalCountChecks);
        ResponseOV<FinalCountCheck> responseOV = new ResponseOV<>((int) pageInfo.getTotal(), finalCountChecks);
        return responseOV;
    }
}
