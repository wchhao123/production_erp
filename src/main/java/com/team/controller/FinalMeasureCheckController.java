package com.team.controller;

import com.team.bean.FinalMeasuretCheck;
import com.team.bean.ResponseOV;
import com.team.service.FinalMeasureCheckService;
import com.team.util.ControllerUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller()
@RequestMapping({"measure","fMeasureCheck"})
public class FinalMeasureCheckController {
    @Autowired
    private FinalMeasureCheckService finalMeasureCheckService;

    @RequestMapping("find")
    public String find(){
        return "/WEB-INF/jsp/measurement_list.jsp";
    }

    @RequestMapping("list")
    @ResponseBody
    public ResponseOV<FinalMeasuretCheck> getPageFinalMeasureCheck(int page, int rows){
        return finalMeasureCheckService.getPageFinalMeasureCheck(page, rows);
    }

    @GetMapping("add_judge")
    @ResponseBody
    public void addJudge() {

    }
    @GetMapping("add")
    public String add() {
        return "/WEB-INF/jsp/measurement_add.jsp";
    }
    @PostMapping("insert")
    @ResponseBody
    public Map<String, String> insert(FinalMeasuretCheck finalMeasuretCheck) {
        boolean b = finalMeasureCheckService.insertFinalMeasuretCheck(finalMeasuretCheck);
        return ControllerUtil.returnMsg(b);
    }

    @GetMapping("edit_judge")
    @ResponseBody
    public void editJudge() {

    }
    @GetMapping("edit")
    public String edit() {
        return "/WEB-INF/jsp/measurement_edit.jsp";
    }
    @PostMapping("update_all")
    @ResponseBody
    public Map<String, String> updateAll(FinalMeasuretCheck finalMeasuretCheck) {
        boolean b = finalMeasureCheckService.updateFinalMeasuretCheck(finalMeasuretCheck);
        return ControllerUtil.returnMsg(b);
    }

    @GetMapping("delete_judge")
    @ResponseBody
    public void deleteJudge() {

    }
    @PostMapping("delete_batch")
    @ResponseBody
    public Map<String, String> deleteBatch(String[] ids) {
        boolean b = finalMeasureCheckService.deleteByIds(ids);
        return ControllerUtil.returnMsg(b);
    }

    @GetMapping({"search_fMeasureCheck_by_fMeasureCheckId", "search_fMeasureCheck_by_orderId"})
    @ResponseBody
    public ResponseOV<FinalMeasuretCheck> searchFinalMeasuretCheckById(HttpServletRequest request,
                                                                       String searchValue, int page, int rows) {
        int flag = 0;
        if (request.getRequestURI().endsWith("search_fMeasureCheck_by_fMeasureCheckId")) {
            flag = 1;
        }
        if(request.getRequestURI().endsWith("search_fMeasureCheck_by_orderId")){
            flag= 2;
        }
        return finalMeasureCheckService.searchFinalMeasureCheckByCondition(flag, searchValue, page, rows);
    }

    @PostMapping("update_note")
    @ResponseBody
    public Map<String, String> updateNote(FinalMeasuretCheck finalMeasureCheck){
        boolean b = finalMeasureCheckService.updateFinalMeasuretCheck(finalMeasureCheck);
        return ControllerUtil.returnMsg(b);
    }
}

