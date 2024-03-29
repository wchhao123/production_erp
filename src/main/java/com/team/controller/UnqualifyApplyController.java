package com.team.controller;

import com.team.bean.ResponseOV;
import com.team.bean.UnqualifyApply;
import com.team.service.UnqualifyApplyService;
import com.team.util.ControllerUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

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

    @GetMapping("add_judge")
    @ResponseBody
    public void addJudge() {

    }

    @GetMapping("add")
    public String add() {
        return "/WEB-INF/jsp/unqualify_add.jsp";
    }

    @PostMapping("insert")
    @ResponseBody
    public Map<String, String> insert(UnqualifyApply unqualifyApply) {
        boolean b = unqualifyApplyService.insertUnqualifyApply(unqualifyApply);
        return ControllerUtil.returnMsg(b);
    }

    @GetMapping("delete_judge")
    @ResponseBody
    public void deleteJudge() {

    }

    @PostMapping("delete_batch")
    @ResponseBody
    public Map<String, String> deleteBatch(String[] ids) {
        boolean b = unqualifyApplyService.deleteByIds(ids);
        return ControllerUtil.returnMsg(b);
    }

    @GetMapping("edit_judge")
    @ResponseBody
    public void editJudge() {

    }

    @GetMapping("edit")
    public String editPage() {
        return "/WEB-INF/jsp/unqualify_edit.jsp";
    }

    @PostMapping("update_all")
    @ResponseBody
    public Map<String, String> updateAll(UnqualifyApply unqualifyApply) {
        boolean b = unqualifyApplyService.updateUnqualifyApply(unqualifyApply);
        return ControllerUtil.returnMsg(b);
    }

    @PostMapping("update_note")
    @ResponseBody
    public Map<String, String> updateNote(UnqualifyApply unqualifyApply) {
        boolean b = unqualifyApplyService.updateUnqualifyApply(unqualifyApply);
        return ControllerUtil.returnMsg(b);
    }

    @GetMapping(value = {"search_unqualify_by_unqualifyId",
            "search_unqualify_by_productName"})
    @ResponseBody
    public ResponseOV<UnqualifyApply> searchUnqualifyById(HttpServletRequest request,
                                              String searchValue, int page, int rows) {
        int flag = 0;
        if (request.getRequestURI().endsWith("search_unqualify_by_unqualifyId")) {
            flag = 1;
        }
        if(request.getRequestURI().endsWith("search_unqualify_by_productName")){
            flag= 2;
        }
        return unqualifyApplyService.searchUnqualifyByCondition(flag, searchValue, page, rows);
    }
}
