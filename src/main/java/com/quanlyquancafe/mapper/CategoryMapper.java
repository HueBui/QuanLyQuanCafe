package com.quanlyquancafe.mapper;

import com.quanlyquancafe.model.CategoryModel;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CategoryMapper implements RowMapper{
    @Override
    public CategoryModel mapRow(ResultSet resultSet) {
        CategoryModel maper = new CategoryModel();
        try {
            maper.setId(resultSet.getLong("id"));
            maper.setImage(resultSet.getString("image"));
            maper.setType(resultSet.getString("type"));
        } catch (SQLException e) {
            System.out.println("Loi mapper class: "+this.getClass() +e);
        }
        return maper;
    }
}
