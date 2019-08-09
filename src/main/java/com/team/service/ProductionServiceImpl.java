package com.team.service;

import com.team.bean.Product;
import com.team.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductionServiceImpl implements IProductService{

    @Autowired
    private ProductMapper productMapper;

    @Override
    public Product getProductById(String id) {
        return productMapper.selectByPrimaryKey(id);
    }
}
