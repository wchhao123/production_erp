package com.team.controller;

import com.github.pagehelper.PageInfo;
import com.team.bean.ProcessMeasureCheck;
import com.team.bean.ResponseOV;
import com.team.service.ProcessMeasureCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("p_measure_check")
public class ProcessMeasureCheckController {
    @Autowired
    private ProcessMeasureCheckService processMeasureCheckService;

    @RequestMapping("find")
    public String find(){
        return "/WEB-INF/jsp/p_measure_check_list.jsp";
    }

    @RequestMapping("list")
    @ResponseBody
    public ResponseOV<ProcessMeasureCheck> getPageProcessMeasureCheck(int page, int rows){
        List<ProcessMeasureCheck> processMeasureChecks = processMeasureCheckService.getPageProcessMeasureCheck(page, rows);
        PageInfo<ProcessMeasureCheck> pageInfo = new PageInfo<>(processMeasureChecks);
        ResponseOV<ProcessMeasureCheck> responseOV = new ResponseOV<>((int)pageInfo.getTotal(), processMeasureChecks);
        return responseOV;
    }
}
