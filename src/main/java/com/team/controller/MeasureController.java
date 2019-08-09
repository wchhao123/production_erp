package com.team.controller;

import com.team.bean.FinalMeasuretCheck;
import com.team.bean.ResponseOV;
import com.team.service.MeasureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller()
@RequestMapping("measure")
public class MeasureController {
    @Autowired
    private MeasureService measureService;

    @RequestMapping("find")
    public String find(){
        return "/WEB-INF/jsp/measurement_list.jsp";
    }

    @RequestMapping("list")
    @ResponseBody
    public ResponseOV<FinalMeasuretCheck> getPageFinalMeasureCheck(int page, int rows){
        return measureService.getPageFinalMeasureCheck(page, rows);
    }
}

