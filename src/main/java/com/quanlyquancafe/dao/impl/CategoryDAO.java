package com.quanlyquancafe.dao.impl;

import com.quanlyquancafe.dao.ICategoryDAO;
import com.quanlyquancafe.mapper.CategoryMapper;
import com.quanlyquancafe.model.CategoryModel;

import java.util.List;

public class CategoryDAO extends AbstractDAO<CategoryModel> implements ICategoryDAO {

    @Override
    public List<CategoryModel> getAll() {
        String sql = "SELECT * FROM category";

        List<CategoryModel> getAll = query(sql,new CategoryMapper());
        return getAll;
    }


}
