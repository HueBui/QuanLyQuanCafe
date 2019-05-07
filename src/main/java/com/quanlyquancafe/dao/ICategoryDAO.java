package com.quanlyquancafe.dao;

import com.quanlyquancafe.model.CategoryModel;

import java.util.List;

public interface ICategoryDAO {
    List<CategoryModel> getAll();

    Long save(CategoryModel categoryModel);
    CategoryModel findOne(Long id);

    boolean update(CategoryModel categoryModel);

    void delete(Long id);
}
