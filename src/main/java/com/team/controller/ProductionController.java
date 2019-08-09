package com.team.controller;

import com.team.bean.Product;
import com.team.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
}
