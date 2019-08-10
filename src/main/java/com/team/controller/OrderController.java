package com.team.controller;

import com.team.bean.COrder;
import com.team.bean.ResponseOV;
import com.team.service.IOrderService;
import com.team.util.ControllerUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import java.io.IOException;
import java.util.HashMap;
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
    public Map<String, String> updateAll(MultipartFile image, MultipartFile file , COrder order) {

        try {
            String imgRelativePath = "/pic/" + image.getOriginalFilename();
            String fileRelativePath = "/file/" + file.getOriginalFilename();
            ControllerUtil.saveFile(image, context.getRealPath("/WEB-INF/upload" + imgRelativePath));
            ControllerUtil.saveFile(image, context.getRealPath("/WEB-INF/upload" + fileRelativePath));
            order.setImage(imgRelativePath);
            order.setFile(fileRelativePath);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            boolean b = orderService.updateOrder(order);
            return ControllerUtil.returnMsg(b);
        }
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
    public void insertJudge() {

    }

    @GetMapping("add")
    public String appPage() {
        return "/WEB-INF/jsp/order_add.jsp";
    }

    @PostMapping("insert")
    @ResponseBody
    public Map<String, String> insert(COrder order) {
        boolean b = orderService.insertOrder(order);
        return ControllerUtil.returnMsg(b);
    }
}
