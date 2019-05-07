package com.quanlyquancafe.service.impl;

import com.quanlyquancafe.dao.ICategoryDAO;
import com.quanlyquancafe.dao.impl.CategoryDAO;
import com.quanlyquancafe.model.CategoryModel;
import com.quanlyquancafe.service.ICategoryService;

import java.util.List;

public class CategoryService implements ICategoryService {
    private ICategoryDAO iCategoryDAO;

    public CategoryService() {
        iCategoryDAO = new CategoryDAO();
    }
    @Override
    public List<CategoryModel> getAll() {
        CategoryDAO categoryDAO = new CategoryDAO();
        return categoryDAO.getAll();
    }

    @Override
    public boolean update(CategoryModel categoryModel) {
        return iCategoryDAO.update(categoryModel);
    }

    @Override
    public CategoryModel findOne(long id) {
        CategoryModel model=iCategoryDAO.findOne(id);
        return model;
    }

    @Override
    public void delete(long[] ids) {
        for (long id : ids) {
            iCategoryDAO.delete(id);
        }
    }

    @Override
    public Long saveCategory(CategoryModel categoryModel) {
        Long categoryId=iCategoryDAO.save(categoryModel);
        return categoryId;
    }

}
