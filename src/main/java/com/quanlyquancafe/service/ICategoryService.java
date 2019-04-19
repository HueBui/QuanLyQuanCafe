package com.quanlyquancafe.service;

import com.quanlyquancafe.model.CategoryModel;

import java.util.List;

public interface ICategoryService {
    List<CategoryModel> getAll();
    boolean update(CategoryModel categoryModel);
}
