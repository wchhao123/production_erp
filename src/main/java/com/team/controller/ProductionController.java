package com.team.controller;

import com.team.bean.Product;
import com.team.bean.ResponseOV;
import com.team.service.IProductService;
import com.team.util.ControllerUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("product")
public class ProductionController {

    @Autowired
    private IProductService productService;
    @Autowired
    ServletContext context;

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

    @GetMapping("edit_judge")
    @ResponseBody
    public void judge(){

    }

    @PostMapping("update_all")
    @ResponseBody
    public Map<String, String> updateAll(MultipartFile image, Product product) {
        //图片先上传再提交，上传功能不应该在这里
        try {
            String imgRelativePath = "/pic/" + image.getOriginalFilename();
            ControllerUtil.saveFile(image, context.getRealPath("/WEB-INF/upload" + imgRelativePath));
            product.setImage(imgRelativePath);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            boolean b = productService.updateProduct(product);
            return ControllerUtil.returnMsg(b);
        }
    }
}
