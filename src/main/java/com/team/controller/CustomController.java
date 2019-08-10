package com.team.controller;

import com.team.bean.Custom;
import com.team.bean.ResponseOV;
import com.team.service.ICustomService;
import com.team.util.ControllerUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("custom")
public class CustomController {

    @Autowired
    private ICustomService customService;

    @RequestMapping("get/{id}")
    @ResponseBody
    public Custom getCustom(@PathVariable("id") String id) {
        return customService.getCustomById(id);
    }

    @GetMapping("find")
    public String find() {
        return "/WEB-INF/jsp/custom_list.jsp";
    }

    @GetMapping("list")
    @ResponseBody
    public ResponseOV<Custom> list(int page, int rows) {
        return customService.getCustoms(page, rows);
    }

    @PostMapping("get_data")
    @ResponseBody
    public List<Custom> getData() {
        return customService.getCustoms();
    }

    @GetMapping("edit_judge")
    @ResponseBody
    public void editJudge() {

    }

    @GetMapping("edit")
    public String editPage() {
        return "/WEB-INF/jsp/custom_edit.jsp";
    }

    @PostMapping("update_all")
    @ResponseBody
    public Map<String, String> updateAll(Custom custom) {

        boolean b = customService.updateCustom(custom);
        return ControllerUtil.returnMsg(b);
    }

    @PostMapping("update_note")
    @ResponseBody
    public Map<String, String> updateNote(String customId, String note) {

        boolean b = customService.updateCustomNoteById(customId, note);
        return ControllerUtil.returnMsg(b);
    }

    @GetMapping("delete_judge")
    @ResponseBody
    public void deleteJudge() {

    }

    @PostMapping("delete_batch")
    @ResponseBody
    public Map<String, String> deleteBatch(String[] ids) {
        boolean b = customService.deleteByIds(ids);
        return ControllerUtil.returnMsg(b);
    }

    @GetMapping("add_judge")
    @ResponseBody
    public String insertJudge() {
        return "";
    }

    @GetMapping("add")
    public String addPage() {
        return "/WEB-INF/jsp/custom_add.jsp";

    }

    @PostMapping("insert")
    @ResponseBody
    public Map<String, String> insert(Custom custom) {
        boolean b = customService.insertCustom(custom);
        return ControllerUtil.returnMsg(b);
    }

    @GetMapping(value = {"search_custom_by_customId","search_custom_by_customName"})
    @ResponseBody
    public ResponseOV<Custom> searchOrderById(HttpServletRequest request,
                                              String searchValue, int page, int rows) {
        int flag;
        if (request.getRequestURI().endsWith("search_custom_by_customId")) {
            flag = 1;
        } else {
            flag= 2;
        }
        return customService.searchCustomByCondition(flag,searchValue, page, rows);
    }
}
