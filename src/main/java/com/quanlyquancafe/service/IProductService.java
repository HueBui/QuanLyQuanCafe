package com.quanlyquancafe.service;

import com.quanlyquancafe.model.ProductModel;
import com.quanlyquancafe.model.custom.ProductCategoryCustom;

import java.util.List;

public interface IProductService {
    public List<ProductCategoryCustom> list();

    void delete(long[] ids);

    Long saveProduct(ProductModel productModel);

    boolean update(ProductModel productModel);

    ProductModel findOne(long id);
}
