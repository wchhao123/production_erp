package com.team.controller;

import com.team.bean.Product;
import com.team.bean.ResponseOV;
import com.team.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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


}
