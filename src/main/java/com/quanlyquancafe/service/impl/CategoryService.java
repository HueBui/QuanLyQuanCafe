package com.quanlyquancafe.service.impl;

import com.quanlyquancafe.dao.impl.CategoryDAO;
import com.quanlyquancafe.model.CategoryModel;
import com.quanlyquancafe.service.ICategoryService;

import java.util.List;

public class CategoryService implements ICategoryService {
    @Override
    public List<CategoryModel> getAll() {
        CategoryDAO categoryDAO = new CategoryDAO();
        return categoryDAO.getAll();
    }

    @Override
    public boolean update(CategoryModel categoryModel) {
        return false;
    }
}
