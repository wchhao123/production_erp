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
}
