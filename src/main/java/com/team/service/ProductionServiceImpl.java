package com.team.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.team.bean.Product;
import com.team.bean.ResponseOV;
import com.team.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductionServiceImpl implements IProductService{

    @Autowired
    private ProductMapper productMapper;

    @Override
    public Product getProductById(String id) {
        return productMapper.selectByPrimaryKey(id);
    }

    @Override
    public ResponseOV<Product> getProducts(int page, int rows) {
        PageHelper.startPage(page, rows);
        List<Product> products = productMapper.selectByExample(null);
        PageInfo<Product> pageInfo = new PageInfo<>(products);

        ResponseOV<Product> ov = new ResponseOV<>();
        ov.setRows(products);
        ov.setTotal((int) pageInfo.getTotal());
        return ov;
    }

    @Override
    public List<Product> getProducts() {
        return productMapper.selectByExample(null);
    }
}
