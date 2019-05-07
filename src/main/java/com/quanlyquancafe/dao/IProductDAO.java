package com.quanlyquancafe.dao;

import com.quanlyquancafe.model.ProductModel;
import com.quanlyquancafe.model.custom.ProductCategoryCustom;

import java.util.List;

public interface IProductDAO {
    List<ProductCategoryCustom> getAllProduct();

    void delete(Long id);

    Long saveProduct(ProductModel productModel);

    boolean update(ProductModel productModel);

    List<ProductModel> listAllProduct();

    ProductModel findOne(long id);
}
