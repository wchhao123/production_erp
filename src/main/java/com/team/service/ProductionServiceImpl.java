package com.team.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.team.bean.Product;
import com.team.bean.ProductExample;
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

    @Override
    public boolean updateProduct(Product product) {
        int i = productMapper.updateByPrimaryKey(product);
        return i == 1;
    }

    @Override
    public boolean updateProductNoteById(String productId, String note) {
        Product product = new Product();
        product.setProductId(productId);
        product.setNote(note);

        int i = productMapper.updateByPrimaryKeySelective(product);
        return i == 1;
    }

    @Override
    public boolean deleteByIds(String[] ids) {
        int row = productMapper.batchDeleteByIds(ids);
        return row != 0;
    }

    @Override
    public boolean insertProduct(Product product) {
        return productMapper.insert(product) == 1;
    }

    @Override
    public ResponseOV<Product> searchProductByCondition(int flag, String searchValue, int page, int rows) {
        ProductExample example = new ProductExample();
        String val = "%" + searchValue + "%";
        if (flag == 1) {
            example.createCriteria().andProductIdLike(val);
        } else if (flag == 2) {
            example.createCriteria().andProductNameLike(val);
        } else {
            example.createCriteria().andProductTypeLike(val);
        }
        PageHelper.startPage(page, rows);
        List<Product> products = productMapper.selectByExample(example);
        PageInfo<Product> info = new PageInfo<>(products);

        ResponseOV<Product> ov = new ResponseOV<>();
        ov.setTotal((int) info.getTotal());
        ov.setRows(products);
        return ov;
    }
}
