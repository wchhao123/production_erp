package com.team.controller;

import com.team.bean.Manufacture;
import com.team.bean.ResponseOV;
import com.team.bean.Work;
import com.team.service.IManufactureService;
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
@RequestMapping("manufacture")
public class ManufactureController {

    @Autowired
    private IManufactureService service;

    @GetMapping("find")
    public String find() {
        return "/WEB-INF/jsp/manufacture_list.jsp";
    }

    @GetMapping("list")
    @ResponseBody
    public ResponseOV<Manufacture> list(int page, int rows) {
        return service.getManufacture(page, rows);
    }

    @PostMapping("get_data")
    @ResponseBody
    public List<Manufacture> getData() {
        return service.selectByExample();
    }

    @GetMapping("edit_judge")
    @ResponseBody
    public void editJudge() {

    }

    @GetMapping("edit")
    public String editPage() {
        return "/WEB-INF/jsp/manufacture_edit.jsp";
    }

    @PostMapping("update_all")
    @ResponseBody
    public Map<String, String> updateAll(Manufacture manufacture) {

        boolean b = service.updateManufacture(manufacture);
        return ControllerUtil.returnMsg(b);
    }

    @GetMapping("delete_judge")
    @ResponseBody
    public void deleteJudge() {

    }

    @PostMapping("delete_batch")
    @ResponseBody
    public Map<String, String> deleteBatch(String[] ids) {
        boolean b = service.deleteManufacturesByIds(ids);
        return ControllerUtil.returnMsg(b);
    }

    @GetMapping("add_judge")
    @ResponseBody
    public String insertJudge() {
        return "";
    }

    @GetMapping("add")
    public String addPage() {
        return "/WEB-INF/jsp/manufacture_add.jsp";

    }

    @PostMapping("insert")
    @ResponseBody
    public Map<String, String> insert(Manufacture manufacture) {
        boolean b = service.insertManufacture(manufacture);
        return ControllerUtil.returnMsg(b);
    }

    @GetMapping(value = {"search_manufacture_by_manufactureSn",
            "search_manufacture_by_manufactureOrderId","search_manufacture_by_manufactureTechnologyName"})
    @ResponseBody
    public ResponseOV<Manufacture> searchOrderById(HttpServletRequest request,
                                            String searchValue, int page, int rows) {
        int flag;
        if (request.getRequestURI().endsWith("search_manufacture_by_manufactureSn")) {
            flag = 1;
        } else if (request.getRequestURI().endsWith("search_manufacture_by_manufactureOrderId")) {
            flag= 2;
        } else {
            flag = 3;
        }
        return service.searchManufactureByCondition(flag,searchValue, page, rows);
    }
}
