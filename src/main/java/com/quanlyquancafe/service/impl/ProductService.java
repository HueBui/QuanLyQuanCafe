package com.quanlyquancafe.service.impl;

import com.quanlyquancafe.dao.IProductDAO;
import com.quanlyquancafe.dao.impl.ProductDAO;
import com.quanlyquancafe.model.ProductModel;
import com.quanlyquancafe.model.custom.ProductCategoryCustom;
import com.quanlyquancafe.service.IProductService;

import java.util.List;

public class ProductService implements IProductService {
    private IProductDAO iProductDAO;

    public ProductService() {
        iProductDAO = new ProductDAO();
    }

    @Override
    public List<ProductCategoryCustom> list() {
        return iProductDAO.getAllProduct();
    }

    @Override
    public void delete(long[] ids) {
        for (long id : ids) {
            iProductDAO.delete(id);
        }
    }

    @Override
    public Long saveProduct(ProductModel productModel) {
        Long userID=iProductDAO.saveProduct(productModel);
        return userID;
    }

    @Override
    public boolean update(ProductModel productModel) {
        return iProductDAO.update(productModel);
    }

    @Override
    public ProductModel findOne(long id) {
        ProductModel model=iProductDAO.findOne(id);
        return model;
    }
}
