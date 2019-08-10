package com.team.controller;

import com.team.bean.COrder;
import com.team.bean.ResponseOV;
import com.team.service.IOrderService;
import com.team.util.ControllerUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("order")
public class OrderController {

    @Autowired
    private IOrderService orderService;

    @Autowired
    private ServletContext context;

    @GetMapping("find")
    public String find() {
        return "/WEB-INF/jsp/order_list.jsp";
    }

    @RequestMapping("list")
    @ResponseBody
    public ResponseOV<COrder> list(int page, int rows) {
        return orderService.getPageCOrder(page, rows);
    }

    @GetMapping("get_data")
    @ResponseBody
    public List<COrder> getData() {
        return orderService.getCOrders();
    }

    @GetMapping("edit_judge")
    @ResponseBody
    public void editJudge() {

    }

    @GetMapping("edit")
    public String editPage() {
        return "/WEB-INF/jsp/order_edit.jsp";
    }

    @PostMapping("update_all")
    @ResponseBody
    public Map<String, String> updateAll(MultipartFile image, COrder order) {

        try {
            String imgRelativePath = "/pic/" + image.getOriginalFilename();
            ControllerUtil.saveFile(image, context.getRealPath("/WEB-INF/upload" + imgRelativePath));
            order.setImage(imgRelativePath);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            boolean b = orderService.updateOrder(order);
            return ControllerUtil.returnMsg(b);
        }
    }

    @PostMapping("update_note")
    @ResponseBody
    public Map<String, String> updateNote(String orderId, String note) {
        boolean b = orderService.updateNoteById(orderId, note);
        return ControllerUtil.returnMsg(b);
    }


    @GetMapping("delete_judge")
    @ResponseBody
    public void deleteJudge() {

    }

    @PostMapping("delete_batch")
    @ResponseBody
    public Map<String, String> deleteBatch(String[] ids) {
        boolean b = orderService.deleteByIds(ids);
        return ControllerUtil.returnMsg(b);
    }

    @GetMapping("add_judge")
    @ResponseBody
    public String insertJudge() {
        return "";
    }

    @GetMapping("add")
    public String addPage() {
        return "/WEB-INF/jsp/order_add.jsp";

    }

    @PostMapping("insert")
    @ResponseBody
    public Map<String, String> insert(COrder order) {
        boolean b = orderService.insertOrder(order);
        return ControllerUtil.returnMsg(b);
    }

    @GetMapping(value = {"search_order_by_orderId",
            "search_order_by_orderCustom","search_order_by_orderProduct"})
    @ResponseBody
    public ResponseOV<COrder> searchOrderById(HttpServletRequest request,
                                              String searchValue, int page, int rows) {
        int flag;
        if (request.getRequestURI().endsWith("search_order_by_orderId")) {
            flag = 1;
        } else if (request.getRequestURI().endsWith("search_order_by_orderCustom")){
            flag= 2;
        } else {
            flag = 3;
        }
        return orderService.searchOrderByCondition(flag,searchValue, page, rows);
    }

    @RequestMapping("get/{id}")
    @ResponseBody
    public COrder getOrder(@PathVariable("id") String id) {
        return orderService.getOrderById(id);
    }
}
