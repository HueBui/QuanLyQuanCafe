package com.quanlyquancafe.dao.impl;

import com.quanlyquancafe.dao.ICategoryDAO;
import com.quanlyquancafe.mapper.CategoryMapper;
import com.quanlyquancafe.mapper.CountMapper;
import com.quanlyquancafe.model.CategoryModel;
import com.quanlyquancafe.model.custom.CountCustom;

import java.util.List;

public class CategoryDAO extends AbstractDAO<CategoryModel> implements ICategoryDAO {

    @Override
    public List<CategoryModel> getAll() {
        String sql = "SELECT * FROM category";

        List<CategoryModel> getAll = query(sql, new CategoryMapper());
        return getAll;
    }

    @Override
    public Long save(CategoryModel categoryModel) {
        String sql = "INSERT INTO category (type,image)" +
                " VALUES('" + categoryModel.getType() + "', '" + categoryModel.getImage() + "')";
        return insert(sql);
    }

    @Override
    public CategoryModel findOne(Long id) {
        String sql = "SELECT * FROM category WHERE id = ?";
        List<CategoryModel> userModels = query(sql, new CategoryMapper(), id);
        return userModels.isEmpty() ? null : userModels.get(0);
    }

    @Override
    public boolean update(CategoryModel categoryModel) {
        StringBuilder sql = new StringBuilder("UPDATE category SET type = ?, image = ?");
        sql.append(" WHERE id = ?");

        return update(sql.toString(), categoryModel.getType(), categoryModel.getImage(), categoryModel.getId());
    }

    @Override
    public void delete(Long id) {
        String sql = "DELETE FROM category WHERE id = ?";
        update(sql, id);
    }

    public List<CountCustom> count() {
        String sql = "SELECT count(*) as count FROM category";
        return query(sql, new CountMapper());
    }
}
