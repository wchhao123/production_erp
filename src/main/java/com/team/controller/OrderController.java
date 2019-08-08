package com.team.controller;

import com.team.bean.COrder;
import com.team.bean.ResponseOV;
import com.team.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("order")
public class OrderController {

    @Autowired
    private IOrderService orderService;

    @GetMapping("find")
    public String find() {
        return "/WEB-INF/jsp/order_list.jsp";
    }

    @RequestMapping("list")
    @ResponseBody
    public ResponseOV<COrder> list(int page, int rows) {
        return orderService.getPageCOrder(page, rows);
    }
}
