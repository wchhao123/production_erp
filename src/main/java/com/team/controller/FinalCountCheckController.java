package com.team.controller;

import com.github.pagehelper.PageInfo;
import com.team.bean.FinalCountCheck;
import com.team.bean.ResponseOV;
import com.team.service.FinalCountCheckService;
import com.team.util.ControllerUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping({"f_count_check","fCountCheck"})
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

    @GetMapping("add_judge")
    @ResponseBody
    public void addJudge() {

    }
    @GetMapping("add")
    public String add() {
        return "/WEB-INF/jsp/f_count_check_add.jsp";
    }
    @PostMapping("insert")
    @ResponseBody
    public Map<String, String> insert(FinalCountCheck finalCountCheck) {
        boolean b = finalCountCheckService.insertFinalCountCheck(finalCountCheck);
        return ControllerUtil.returnMsg(b);
    }

    @GetMapping("edit_judge")
    @ResponseBody
    public void editJudge() {

    }
    @GetMapping("edit")
    public String edit() {
        return "/WEB-INF/jsp/f_count_check_edit.jsp";
    }
    @PostMapping("update_all")
    @ResponseBody
    public Map<String, String> updateAll(FinalCountCheck finalCountCheck) {
        boolean b = finalCountCheckService.updateFinalCountCheck(finalCountCheck);
        return ControllerUtil.returnMsg(b);
    }

    @GetMapping("delete_judge")
    @ResponseBody
    public void deleteJudge() {

    }
    @PostMapping("delete_batch")
    @ResponseBody
    public Map<String, String> deleteBatch(String[] ids) {
        boolean b = finalCountCheckService.deleteByIds(ids);
        return ControllerUtil.returnMsg(b);
    }

    @GetMapping({"search_fCountCheck_by_fCountCheckId", "search_fCountCheck_by_orderId"})
    @ResponseBody
    public ResponseOV<FinalCountCheck> searchFinalCountCheckById(HttpServletRequest request,
                                                                       String searchValue, int page, int rows) {
        int flag = 0;
        if (request.getRequestURI().endsWith("search_fCountCheck_by_fCountCheckId")) {
            flag = 1;
        }
        if(request.getRequestURI().endsWith("search_fCountCheck_by_orderId")){
            flag= 2;
        }
        return finalCountCheckService.searchFinalCountCheckByCondition(flag, searchValue, page, rows);
    }

    @PostMapping("update_note")
    @ResponseBody
    public Map<String, String> updateNote(FinalCountCheck finalCountCheck){
        boolean b = finalCountCheckService.updateFinalCountCheck(finalCountCheck);
        return ControllerUtil.returnMsg(b);
    }
}
