package com.team.service;

import com.team.bean.Product;

public interface IProductService {

    //根据Id获取product
    Product getProductById(String id);
}
