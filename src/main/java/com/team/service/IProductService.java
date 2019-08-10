package com.team.service;

import com.team.bean.Product;
import com.team.bean.ResponseOV;

import java.util.List;

public interface IProductService {

    //根据Id获取product
    Product getProductById(String id);

    //所有product数据
    ResponseOV<Product> getProducts(int page, int rows);

    List<Product> getProducts();

    boolean updateProduct(Product product);

    boolean updateProductNoteById(String productId, String note);

    boolean deleteByIds(String[] ids);

    boolean insertProduct(Product product);

    ResponseOV<Product> searchProductByCondition(int flag, String searchValue, int page, int rows);
}
