package com.team.controller;

import com.team.bean.Product;
import com.team.bean.ResponseOV;
import com.team.service.IProductService;
import com.team.util.ControllerUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("product")
public class ProductionController {

    @Autowired
    private IProductService productService;

    @RequestMapping("get/{id}")
    @ResponseBody
    public Product getProduct(@PathVariable("id")String id) {
        return productService.getProductById(id);
    }

    @GetMapping("find")
    public String find() {
        return "/WEB-INF/jsp/product_list.jsp";
    }

    @GetMapping("list")
    @ResponseBody
    public ResponseOV<Product> list(int page, int rows) {
        return productService.getProducts(page, rows);
    }

    @PostMapping("get_data")
    @ResponseBody
    public List<Product> getData() {
        return productService.getProducts();
    }

    @GetMapping("edit_judge")
    @ResponseBody
    public void editJudge() {

    }

    @GetMapping("edit")
    public String editPage() {
        return "/WEB-INF/jsp/product_edit.jsp";
    }

    @PostMapping("update_all")
    @ResponseBody
    public Map<String, String> updateAll(Product product) {

        boolean b = productService.updateProduct(product);
        return ControllerUtil.returnMsg(b);
    }

    @PostMapping("update_note")
    @ResponseBody
    public Map<String, String> updateNote(String productId, String note) {

        boolean b = productService.updateProductNoteById(productId, note);
        return ControllerUtil.returnMsg(b);
    }

    @GetMapping("delete_judge")
    @ResponseBody
    public void deleteJudge() {

    }

    @PostMapping("delete_batch")
    @ResponseBody
    public Map<String, String> deleteBatch(String[] ids) {
        boolean b = productService.deleteByIds(ids);
        return ControllerUtil.returnMsg(b);
    }

    @GetMapping("add_judge")
    @ResponseBody
    public String insertJudge() {
        return "";
    }

    @GetMapping("add")
    public String addPage() {
        return "/WEB-INF/jsp/product_add.jsp";

    }

    @PostMapping("insert")
    @ResponseBody
    public Map<String, String> insert(Product product) {
        boolean b = productService.insertProduct(product);
        return ControllerUtil.returnMsg(b);
    }

    @GetMapping(value = {"search_product_by_productId",
            "search_product_by_productName","search_product_by_productType"})
    @ResponseBody
    public ResponseOV<Product> searchOrderById(HttpServletRequest request,
                                              String searchValue, int page, int rows) {
        int flag;
        if (request.getRequestURI().endsWith("search_product_by_productId")) {
            flag = 1;
        } else if (request.getRequestURI().endsWith("search_product_by_productName")) {
            flag= 2;
        } else {
            flag = 3;
        }
        return productService.searchProductByCondition(flag,searchValue, page, rows);
    }
}
